package cliente;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author aleja
 */
public class Jugador extends Dibujo {

    private int puntaje;
    private int numero;

    public Jugador(int numero, String imagen) {
        super(0, 0, 124, 140, imagen);
        this.numero = numero;
        if (numero == 1) {
            x = 80;
            y = 80;
        } else {
            x = 800;
            y = 80;
        }
        puntaje = 0;
    }
    
    public void dibujar(Graphics g, JPanel p) {
        g.drawImage(Competencia.loadImage("/recursos/" + imagen), x, y, x + ancho, y + alto, p);
    }
    
}
