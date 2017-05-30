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

    public Cuenta(int id, String usuario, String contraseña, int puntos, int posRanking) {
        this.id = id;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.puntos = puntos;
        this.posRanking = posRanking;
    }

    public Cuenta() {};
    
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
