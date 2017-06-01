package servidor;

/**
 *
 * @author Juan Felipe López Hurtado
 */
public class Jugador {
    
    private int idCuenta;
    private int apariencia;
    private boolean listo;
    
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

    public boolean estaListo() {
        return listo;
    }
    
    public void listo() {
        listo = true;
    }
    
}
