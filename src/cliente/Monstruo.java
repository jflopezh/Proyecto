package cliente;

import java.awt.Graphics;
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
    private int limSec;

    public Monstruo(int tipo, boolean direccion, int altura, int velocidad, int tiempoEntrada) {
        super(0, 0, 200, 150, tipo + "-1.png");
        this.tipo = tipo;
        this.direccion = direccion;
        this.altura = altura;
        this.velocidad = velocidad;
        y = 250 + ((altura - 1) * 150);
        if (direccion) {
            x = -200;
        } else {
            x = 853;
        }
        this.tiempoEntrada = tiempoEntrada;
        setLimSec();
        secuencia = 1;
    }    
    
    @Override
    public void dibujar(Graphics g, JPanel p) {
        if (direccion) {
            g.drawImage(loadImage("/recursos/" + imagen), x, y, x + ancho, y + alto, p);
            g.drawImage(loadImage("/recursos/" + imagen), x + 712, y, x + ancho + 712, y + alto, p);
        } else {
            g.drawImage(loadImage("/recursos/" + imagen), x, y, x - ancho, y + alto, 0, 0, 200, 150, p);
            g.drawImage(loadImage("/recursos/" + imagen), x + 712, y, x - ancho + 712, y + alto, 0, 0, 200, 150, p);
        }
    }
    
    public void mover() {
        if (direccion) {
            x += 20;
        } else {
            x -= 20;
        }        
        secuencia++;
        if (secuencia == limSec + 1) {
            secuencia = 1;
        }
        imagen = tipo + "-" + secuencia;
    }
    
    private void setLimSec() {
        switch (tipo) {
            case 1:
                limSec = 1;
                break;
            case 2:
                limSec = 2;
                break;
            case 3:
                limSec = 3;
                break;
            case 4:
                limSec = 5;
                break;
            case 5:
                limSec = 4;
                break;
            case 6:
                limSec = 2;
                break;
            case 7:
                limSec = 4;
                break;
            case 8:
                limSec = 4;
                break;
            case 9:
                limSec = 2;
                break;
            case 10:
                limSec = 4;
                break;
        }
    }

    public int getTiempoEntrada() {
        return tiempoEntrada;
    }

    public boolean isDireccion() {
        return direccion;
    }
    
}
