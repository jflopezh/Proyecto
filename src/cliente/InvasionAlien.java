package cliente;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author aleja
 */
public class InvasionAlien {
    
    public static final String IP = "127.0.0.1";
    public static final int PUERTO = 7540;
    
    public static void main(String[] args) {
        try {
            Socket s = new Socket(IP, PUERTO);
            InicioSesion is = new InicioSesion();
            is.setVisible(true);
        } catch (IOException ex) {
            System.out.println("No se pudo iniciar la conexion con el servidor.");
        }
        
    }
    
}
