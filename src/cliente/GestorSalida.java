package cliente;

import java.io.PrintWriter;

/**
 *
 * @author Juan Felipe López Hurtado
 */
public class GestorSalida {
    
    public static void enviar(PrintWriter salida, String paquete) {
	if (salida != null && !paquete.isEmpty() && !paquete.equals("")) {
            salida.println(paquete);
            salida.flush();
	}
    }
    
    public static void enviarIngreso(PrintWriter salida, String usuario, String contraseña) {
        String paquete = "I-" + usuario + "-" + contraseña;
        enviar(salida, paquete);
    }
    
    public static void enviarCerrar(PrintWriter salida) {
        String paquete = "C";
        enviar(salida, paquete);
    }
    
    public static void enviarReto(PrintWriter salida, String retado) {
        String paquete = "A-R:" + retado;
        enviar(salida, paquete);
    }
    
    public static void enviarAceptacionReto(PrintWriter salida, String retador) {
        String paquete = "A-A:" + retador;
        enviar(salida, paquete);
    }
    
    public static void enviarCompetenciaCargada(PrintWriter salida, int idCompetencia) {
        String paquete = "L-C:" + idCompetencia;
        enviar(salida, paquete);
    }
    
    public static void enviarMovimiento(PrintWriter salida, int idCompetencia, String mov) {
        String paquete = "L-M:" + idCompetencia + ":" + mov;
        enviar(salida, paquete);
    }
    
}
