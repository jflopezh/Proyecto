package cliente;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
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
    
    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(getClass().getResource(imageName));
        Image image = ii.getImage();
        return image;
    }
}
