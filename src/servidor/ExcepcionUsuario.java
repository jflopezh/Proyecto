package servidor;

/**
 *
 * @author aleja
 */
public class ExcepcionUsuario extends Exception {

    public ExcepcionUsuario() {
        super("El usuario ingresado no existe en la base de datos");
    }
    
}
