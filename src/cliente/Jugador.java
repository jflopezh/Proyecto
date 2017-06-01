package cliente;

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JPanel;

/**
 *
 * @author Juan Felipe López Hurtado
 */
public class Jugador extends Dibujo {

    private int puntaje;
    private int disparo;

    public Jugador(int numero, String imagen) {
        super(0, 80, 124, 140, imagen);
        if (numero == 1) {
            x = 80;
        } else {
            x = 800;
        }
        puntaje = 0;
    }
    
    public void dibujar(Graphics g, JPanel p) {
        if (disparo != 0) {
            int altod = 90 + ((disparo - 1) * 150) + 60;
            g.drawImage(loadImage("/recursos/" + imagen + "-1.png"), x + 47, 160, 30, altod, p);
            g.drawImage(loadImage("/recursos/" + imagen + "-2.png"), x + 9, 260 + ((disparo - 1) * 150), 100, 100, p);
        }
        g.drawImage(loadImage("/recursos/" + imagen + ".png"), x, y, ancho, alto, p);
    }
    
    public int getPuntaje() {
        return puntaje;
    }
    
    public void sumarPuntos(int puntos) {
        puntaje += puntos;
    }
    
    public void moverDerecha() {
        x += 15;
    }
    
    public void moverIzquierda() {
        x -= 15;
    }
    
    public void disparar(int d) {
        disparo = d;
    }

    public int getDisparo() {
        return disparo;
    }
    
    public Rectangle getAreaDisparo() {
        return new Rectangle(x + 19, 270 + ((disparo - 1) * 150), 80, 80);
    }
}
