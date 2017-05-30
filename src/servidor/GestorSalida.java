package servidor;

import java.io.PrintWriter;

/**
 *
 * @author aleja
 */
public class GestorSalida {
    
    public static void enviar(PrintWriter salida, String paquete) {
	if (salida != null && !paquete.isEmpty() && !paquete.equals("")) {
            salida.println(paquete);
            salida.flush();
	}
    }
    
    public static void enviarIngresoExitoso(PrintWriter salida) {
        String paquete = "I-T";
        enviar(salida, paquete);
    }
    
    public static void enviarIngresoFallidoUsuario(PrintWriter salida) {
        String paquete = "I-U";
        enviar(salida, paquete);
    }
    
    public static void enviarIngresoFallidoContraseña(PrintWriter salida) {
        String paquete = "I-C";
        enviar(salida, paquete);
    }
    
    public static void enviarReto(PrintWriter salida, String retador) {
        String paquete = "A-R:" + retador;
        enviar(salida, paquete);
    }
    
    public static void enviarUsuarioInexistente(PrintWriter salida) {
        String paquete = "A-I";
        enviar(salida, paquete);
    }
    
    public static void enviarUsuarioDesconectado(PrintWriter salida) {
        String paquete = "A-D";
        enviar(salida, paquete);
    }
    
}
