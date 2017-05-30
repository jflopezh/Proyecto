package servidor;

/**
 *
 * @author aleja
 */
public class Cuenta {
    private int id;
    private String usuario;
    private String contraseña;
    private int puntos;
    private int posRanking;

    public Cuenta(String usuario, String contraseña, int puntos) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.puntos = puntos;
    }

    public Cuenta() {
        id = 0;
    }
    
    public void añadirVictoria() {
        puntos += 20;
    }
    
    public void añadirDerrota() {
        puntos -= 20;
    }

    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }
    
}
