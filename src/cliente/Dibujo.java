package cliente;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author aleja
 */
public abstract class Dibujo {
    
    protected int x;
    protected int y;
    protected int ancho;
    protected int alto;
    protected String imagen;

    public Dibujo(int x, int y, int ancho, int alto, String imagen) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.imagen = imagen;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getImagen() {
        return imagen;
    }
    
    public abstract void dibujar(Graphics g, JPanel p);
    
}
