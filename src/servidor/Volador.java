package servidor;

/**
 *
 * @author aleja
 */
public class Volador {
    
    private int tipo;
    private boolean direccion;
    private int altura;
    private int velocidad;
    private int tiempoSalida;

    public Volador() {
        this.tipo = (int) (Math.random() * 10 + 1);
        this.direccion = (int) (Math.random() * 2 + 1) == 1;
        this.altura = (int) (Math.random() * 3 + 1);
        this.velocidad = (int) (Math.random() * 25 + 5);
        this.tiempoSalida = (int) (Math.random() * 150);
    }

    public int getTipo() {
        return tipo;
    }

    public boolean isDireccion() {
        return direccion;
    }

    public int getAltura() {
        return altura;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getTiempoSalida() {
        return tiempoSalida;
    }

    @Override
    public String toString() {
        return tipo + "," + direccion + "," + altura + "," + velocidad + "," + tiempoSalida;
    }
}
