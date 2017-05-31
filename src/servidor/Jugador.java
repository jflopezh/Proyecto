package servidor;

/**
 *
 * @author aleja
 */
public class Jugador {
    
    private int idCuenta;
    private int apariencia;
    
    public Jugador(int idCuenta) {
        this.idCuenta = idCuenta;
        this.apariencia = (int) (Math.random() * 5 + 1);
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public int getApariencia() {
        return apariencia;
    }
    
}
