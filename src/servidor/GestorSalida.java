package servidor;

import java.io.PrintWriter;

/**
 *
 * @author aleja
 */
public class GestorSalida {
    
    public static void enviar(PrintWriter salida, String packet) {
	if (salida != null && !packet.isEmpty() && !packet.equals("")) {
            salida.println(packet);
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
}
