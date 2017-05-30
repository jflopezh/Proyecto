package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aleja
 */
public class EntradaUsuario extends Thread {
    
    private Cuenta cuenta;
    private Socket cliente;
    private BufferedReader entrada;
    private PrintWriter salida;
    
    public EntradaUsuario(Socket cliente) {
        cuenta = new Cuenta();
        try {
            this.cliente = cliente;
            entrada = new BufferedReader(new InputStreamReader(this.cliente.getInputStream()));
            salida = new PrintWriter(this.cliente.getOutputStream());
        } catch (IOException ex) {
            try {
                this.cliente.close();
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        }
    }
    
    @Override
    public void run() {
        String paquete;
        while (!InvasionAlien.cerrando) {
            try {
                paquete = entrada.readLine();
                if(!paquete.isEmpty()) {
                    analizarPaquete(paquete);
                }
            } catch (IOException ex) {
                Logger.getLogger(EntradaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void analizarPaquete(String paquete) {
        switch (paquete.charAt(0)) {
            case 'I':
                String[] ingreso = paquete.split("-");
                String usuario = ingreso[1];
                String contraseña = ingreso[2];
                ingresar(usuario, contraseña);
                break;
            default:
                throw new AssertionError();
        }
    }
    
    private void ingresar(String usuario, String contraseña) {
        boolean usuarioInexistente = true;
        for (Cuenta c : Servidor.getCuentas()) {
            if (c.getUsuario().equals(usuario)) {
                usuarioInexistente = false;
                if (c.getContraseña().equals(contraseña)) {
                    synchronized (cuenta) {
                        cuenta = c;
                        cuenta.notify();
                    }
                    GestorSalida.enviarIngresoExitoso(salida);
                } else {
                    GestorSalida.enviarIngresoFallidoContraseña(salida);
                }
                break;
            }
        }
        if (usuarioInexistente) {
            GestorSalida.enviarIngresoFallidoUsuario(salida);
        }
    }

    public Cuenta getCuenta() {
        return cuenta;
    }
    
}
