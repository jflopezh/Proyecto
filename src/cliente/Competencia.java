package cliente;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author aleja
 */
public class Competencia extends JPanel implements ActionListener {
    
    private int id;
    private Jugador jugador1;
    private Jugador jugador2;
    private ArrayList<Monstruo> monstruos;
    private ArrayList<Monstruo> removerM;
    private ArrayList<Dibujo> aDibujar;
    private ArrayList<Dibujo> removerD;
    private Timer timer;
    private int count;
    private int tiempo;
    
    public Competencia(int id, Jugador jugador1, Jugador jugador2, ArrayList<Monstruo> monstruos) {
        removerM = new ArrayList<>();
        removerD = new ArrayList<>();
        this.id = id;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        aDibujar = new ArrayList<>();
        aDibujar.add(jugador1);
        aDibujar.add(jugador2);
        this.monstruos = monstruos;
        timer = new Timer(100, this);
        timer.start();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(loadImage("/recursos/FondoJuego.png"), 0, 0, 1366, 700, this);
        for (Dibujo d : aDibujar) {
            d.dibujar(g, this);
        }
    }
    
    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(getClass().getResource(imageName));
        Image image = ii.getImage();
        return image;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        count++;
        if (count == 10) {
            tiempo++;
            for (int i = 0; i < monstruos.size(); i++) {
                Monstruo m = monstruos.get(i);
                if (m.getTiempoEntrada() == tiempo) {
                    aDibujar.add(m);
                    removerM.add(m);
                }
            }
            monstruos.removeAll(removerM);
            removerM.clear();
            count = 0;
        }
        for (Dibujo d : aDibujar) {
            if (d instanceof Monstruo) {
                Monstruo m = (Monstruo) d;
                m.mover();
                if (m.isDireccion() && (m.getX() > 600 && m.getX() <700)) {
                    removerD.add(m);
                } else if (!m.isDireccion() && (m.getX() > -50 && m.getX() <50)) {
                    removerD.add(m);
                }
            }
        }
        aDibujar.removeAll(removerD);
        removerD.clear();
        repaint();
    }
}
