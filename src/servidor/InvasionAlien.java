package servidor;

/**
 *
 * @author aleja
 */
public class InvasionAlien {
    
    public static boolean CERRANDO;
    public static Servidor SERVIDOR;
    public static final String ARCHIVO_CARGA = "Cuentas.txt";
    public static final int CANT_MOUNSTROS_COMPETENCIA = 100;
    
    public static void main(String[] args) {
        SERVIDOR = new Servidor(8500);
        SERVIDOR.start();
    }
    
}
