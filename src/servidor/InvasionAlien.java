package servidor;

/**
 *
 * @author aleja
 */
public class InvasionAlien {
    
    public static boolean cerrando;
    
    public static void main(String[] args) {
        Servidor servidor = new Servidor(7540);
        servidor.start();
    }
    
}
