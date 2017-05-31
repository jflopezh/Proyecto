package cliente;

import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;

/**
 *
 * @author aleja
 */
public class Monstruo extends Dibujo {
    
    private int tipo;
    private boolean direccion;
    private int altura;
    private int velocidad;
    private int secuencia;
    private int tiempoEntrada;
    private int limSecuencia;

    public Monstruo(int tipo, boolean direccion, int altura, int velocidad, int tiempoEntrada, boolean ladoIzquierdo) {
        super(0, 0, 150, 112, tipo + "-1.png");
        this.tipo = tipo;
        this.direccion = direccion;
        this.altura = altura;
        this.velocidad = velocidad;
        y = 250 + ((altura - 1) * 150);
        if (direccion) {
            if (ladoIzquierdo) {
                x = -150;
            } else {
                x = 670;
            }
        } else {
            if (ladoIzquierdo) {
                x = 750;
            } else {
                x = 750 + 700;
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
    
    public Point getCorazon() {
        if (direccion) {
            return new Point(x + 100, y + 75);
        }
        return new Point(x - 100, y + 75);
    }

    public boolean isDireccion() {
        return direccion;
    }
    
}
