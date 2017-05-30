package servidor;

/**
 *
 * @author aleja
 */
public class InvasionAlien {
    
    public static boolean CERRANDO;
    public static Servidor SERVIDOR;
    public static final String ARCHIVO_CARGA = "Cuentas.txt";
    
    public static void main(String[] args) {
        SERVIDOR = new Servidor(7540);
        SERVIDOR.start();
    }
    
}
