package servidor;

import java.util.ArrayList;

/**
 *
 * @author Juan Felipe López Hurtado
 */
public class Competencia {
    
    private int id;
    private Jugador jugador1;
    private Jugador jugador2;
    private ArrayList<Volador> monstruos;

    public Competencia(int id, int jugador1, int jugador2) {
        this.id = id;
        this.jugador1 = new Jugador(jugador1);
        this.jugador2 = new Jugador(jugador2);
        monstruos =  new ArrayList<>();
        for (int i = 0; i < InvasionAlien.CANT_MOUNSTROS_COMPETENCIA; i++) {
            monstruos.add(new Volador());
        }
    }

    @Override
    public String toString() {
        String x = id + ":" + jugador1.getApariencia() + ":" + jugador2.getApariencia() + ":";
        for (Volador v : monstruos) {
            x += v.toString() + "_";
        }
        return x;
    }

    public int getId() {
        return id;
    }
    
    public int getContrincante(int idJugador) {
        if (jugador1.getIdCuenta() != idJugador) {
            return jugador1.getIdCuenta();
        }
        return jugador2.getIdCuenta();
    }
    
    public void jugadorListo(int idJugador) {
        if (jugador1.getIdCuenta() == idJugador) {
            jugador1.listo();
        } else {
            jugador2.listo();
        }
    }
    
    public boolean estanJugadoresListos() {
        return  (jugador1.estaListo() && jugador2.estaListo());
    }
    
}
