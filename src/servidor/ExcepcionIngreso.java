package servidor;

/**
 *
 * @author aleja
 */
public class ExcepcionIngreso extends Exception {

    public ExcepcionIngreso() {
        super("La contraseña no coincide con el usuario ingresado.");
    }      
    
}
