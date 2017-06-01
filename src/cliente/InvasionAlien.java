package cliente;

import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author Juan Felipe López Hurtado
 */
public class InvasionAlien {
    
    public static final String IP = "127.0.0.1";
    public static final int PUERTO = 7200;
    public static Conexion CONEXION;
    public static Controlador CONTR;
    public static InicioSesion IS;
    public static ClienteJuego CJ;
    public static Competencia C;
    
    public static void main(String[] args) {
        try {
            CONEXION = new Conexion();
            CONEXION.start();
            IS = new InicioSesion();
            CONTR = new Controlador(CONEXION, IS);
            IS.setVisible(true);
            synchronized (IS) {
                IS.wait();
            }
            CONTR = new Controlador(CONEXION, CJ);
            CJ.setVisible(true);
        } catch (IOException ex) {
            System.out.println("No se pudo realizar la conexion con el servidor.");
        } catch (InterruptedException ex) {}
    }
    
    public static void iniciarCompetencia(Competencia c) {
        C = c;
        JFrame J = new JFrame();
        J.add(c);
        J.setSize(1366, 700);
        J.setLocationRelativeTo(null);
        J.setTitle("Invacion Alien");
        J.setUndecorated(true);
        J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        J.setVisible(true);
        GestorSalida.enviarCompetenciaCargada(InvasionAlien.CONEXION.getSalida(), c.getId());
    }
    
}
