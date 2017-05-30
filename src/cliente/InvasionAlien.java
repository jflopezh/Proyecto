package cliente;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author aleja
 */
public class InvasionAlien {
    
    public static final String IP = "127.0.0.1";
    public static final int PUERTO = 7540;
    public static Conexion CONEXION;
    public static Controlador CONTR;
    public static InicioSesion IS;
    public static ClienteJuego CJ;
    
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
            CJ = new ClienteJuego();
            CONTR = new Controlador(CONEXION, CJ);
        } catch (IOException ex) {
            System.out.println("No se pudo realizar la conexion con el servidor.");
        } catch (InterruptedException ex) {}
    }
    
}
