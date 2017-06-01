package cliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Juan Felipe López Hurtado
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
    private int tiempo;
    private int tiempoActual;

    public Competencia(int id, Jugador jugador1, Jugador jugador2, ArrayList<Monstruo> monstruos) {
        tiempo = 150;
        removerM = new ArrayList<>();
        removerD = new ArrayList<>();
        this.id = id;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        aDibujar = new ArrayList<>();
        this.monstruos = monstruos;
        addKeyListener(new TAdapter());
        setFocusable(true);
        tiempoActual = (int) (System.currentTimeMillis() / 1000);
        timer = new Timer(50, this);
    }
    
    public void iniciarTimer() {
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(loadImage("/recursos/FondoJuego.png"), 0, 0, 1366, 700, this);
        for (Dibujo d : aDibujar) {
            d.dibujar(g, this);
        }
        jugador1.dibujar(g, this);
        jugador2.dibujar(g, this);
        g.drawImage(loadImage("/recursos/InterJuego.png"), 0, 0, 1366, 700, this);
        g.setColor(Color.WHITE);
        g.setFont(new Font("xxx", 1, 30));
        if (tiempo > 99) {
            g.drawString(String.valueOf(tiempo), 655, 360);
        } else if (tiempo > 9) {
            g.drawString(String.valueOf(tiempo), 665, 360);
        } else {
            g.drawString(String.valueOf(tiempo), 675, 360);
        }
        g.drawString(String.valueOf(jugador1.getPuntaje()), 500, 30);
        g.drawString(String.valueOf(jugador2.getPuntaje()), 1200, 30);
    }

    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(getClass().getResource(imageName));
        Image image = ii.getImage();
        return image;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int ta = (int) (System.currentTimeMillis() / 1000);
        if (ta != tiempoActual) {
            tiempo--;
            for (int i = 0; i < monstruos.size(); i++) {
                Monstruo m = monstruos.get(i);
                if (m.getTiempoEntrada() == tiempo) {
                    aDibujar.add(m);
                    removerM.add(m);
                }
            }
            monstruos.removeAll(removerM);
            removerM.clear();
            tiempoActual = ta;
        }
        if (jugador1.getDisparo() != 0) {
            procesarDisparos1();
        }
        if (jugador2.getDisparo() != 0) {
            procesarDisparos2();
        }
        for (Dibujo d : aDibujar) {
            if (d instanceof Monstruo) {
                Monstruo m = (Monstruo) d;
                m.mover();
                if (m.isDireccion() && m.isLadoIzquierdo() && m.getX() > 570) {
                    removerD.add(m);
                } else if (!m.isDireccion() && m.isLadoIzquierdo() && m.getX() < 80) {
                    removerD.add(m);
                } else if (m.isDireccion() && !m.isLadoIzquierdo() && m.getX() > 1390) {
                    removerD.add(m);
                } else if (!m.isDireccion() && !m.isLadoIzquierdo() && m.getX() < 830) {
                    removerD.add(m);
                }
            }
        }
        aDibujar.removeAll(removerD);
        removerD.clear();
        if (tiempo == 0) {

            timer.stop();
        }
        repaint();
    }

    private void procesarDisparos1() {
        for (Dibujo d : aDibujar) {
            if (d instanceof Monstruo) {
                Monstruo m = (Monstruo) d;
                if (jugador1.getAreaDisparo().contains(m.getCorazon())) {
                    jugador1.sumarPuntos(m.getPuntos());
                    removerD.add(m);
                }
            }
        }
    }

    private void procesarDisparos2() {
        for (Dibujo d : aDibujar) {
            if (d instanceof Monstruo) {
                Monstruo m = (Monstruo) d;
                if (jugador2.getAreaDisparo().contains(m.getCorazon())) {
                    jugador2.sumarPuntos(m.getPuntos());
                    removerD.add(m);
                }
            }
        }
    }

    public Jugador getJugador2() {
        return jugador2;
    }
    
    public int getId() {
        return id;
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_Z:
                    jugador1.disparar(0);
                    GestorSalida.enviarMovimiento(InvasionAlien.CONEXION.getSalida(), id, "R");
                    break;
                case KeyEvent.VK_X:
                    jugador1.disparar(0);
                    GestorSalida.enviarMovimiento(InvasionAlien.CONEXION.getSalida(), id, "R");
                    break;
                case KeyEvent.VK_C:
                    jugador1.disparar(0);
                    GestorSalida.enviarMovimiento(InvasionAlien.CONEXION.getSalida(), id, "R");
                    break;
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    jugador1.moverIzquierda();
                    GestorSalida.enviarMovimiento(InvasionAlien.CONEXION.getSalida(), id, "I");
                    break;
                case KeyEvent.VK_RIGHT:
                    jugador1.moverDerecha();
                    GestorSalida.enviarMovimiento(InvasionAlien.CONEXION.getSalida(), id, "D");
                    break;
                case KeyEvent.VK_Z:
                    jugador1.disparar(1);
                    GestorSalida.enviarMovimiento(InvasionAlien.CONEXION.getSalida(), id, "Z");
                    break;
                case KeyEvent.VK_X:
                    jugador1.disparar(2);
                    GestorSalida.enviarMovimiento(InvasionAlien.CONEXION.getSalida(), id, "X");
                    break;
                case KeyEvent.VK_C:
                    jugador1.disparar(3);
                    GestorSalida.enviarMovimiento(InvasionAlien.CONEXION.getSalida(), id, "C");
                    break;
            }
        }
    }
    
}
