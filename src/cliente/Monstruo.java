package cliente;

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JPanel;

/**
 *
 * @author Juan Felipe López Hurtado
 */
public class Monstruo extends Dibujo {
    
    private int tipo;
    private boolean direccion;
    private int altura;
    private int velocidad;
    private int secuencia;
    private int tiempoEntrada;
    private int limSecuencia;
    private boolean ladoIzquierdo;

    public Monstruo(int tipo, boolean direccion, int altura, int velocidad, int tiempoEntrada, boolean ladoIzquierdo) {
        super(0, 0, 150, 112, tipo + "-1.png");
        this.tipo = tipo;
        this.direccion = direccion;
        this.altura = altura;
        this.velocidad = velocidad;
        this.ladoIzquierdo = ladoIzquierdo;
        y = 250 + ((altura - 1) * 150);
        if (ladoIzquierdo) {
            if (direccion) {
                x = -67;
            } else {
                x = 750;
            }
        } else {
            if (direccion) {
                x = 616;
            } else {
                x = 1433;
            }
        }
        this.tiempoEntrada = tiempoEntrada;
        setLimSec();
        secuencia = 1;
    }    
    
    @Override
    public void dibujar(Graphics g, JPanel p) {
        if (direccion) {
            g.drawImage(loadImage("/recursos/" + imagen), x, y, ancho, alto, p);
        } else {
            g.drawImage(loadImage("/recursos/" + imagen), x, y, x - ancho, y + alto, 0, 0, 200, 150, p);
        }
    }
    
    public void mover() {
        if (direccion) {
            x += 10;
        } else {
            x -= 10;
        }        
        secuencia++;
        if (secuencia == limSecuencia + 1) {
            secuencia = 1;
        }
        imagen = tipo + "-" + secuencia + ".png";
    }
    
    public int getPuntos() {
        return (tipo * 10);
    }
    
    private void setLimSec() {
        switch (tipo) {
            case 1:
                limSecuencia = 1;
                break;
            case 2:
                limSecuencia = 2;
                break;
            case 3:
                limSecuencia = 3;
                break;
            case 4:
                limSecuencia = 5;
                break;
            case 5:
                limSecuencia = 4;
                break;
            case 6:
                limSecuencia = 2;
                break;
            case 7:
                limSecuencia = 4;
                break;
            case 8:
                limSecuencia = 4;
                break;
            case 9:
                limSecuencia = 2;
                break;
            case 10:
                limSecuencia = 4;
                break;
        }
    }

    public int getTiempoEntrada() {
        return tiempoEntrada;
    }

    public boolean isLadoIzquierdo() {
        return ladoIzquierdo;
    }
    
    public Rectangle getCorazon() {
        if (direccion) {
            return new Rectangle(x, y, 200, 150);
        }
        return new Rectangle(x - 200, y, 200, 150);
    }

    public boolean isDireccion() {
        return direccion;
    }
    
}
