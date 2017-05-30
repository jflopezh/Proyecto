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
    private boolean activa;
    
    public EntradaUsuario(Socket cliente) {
        cuenta = new Cuenta();
        activa = true;
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
        while (!InvasionAlien.CERRANDO && activa) {
            try {
                paquete = entrada.readLine();
                if(paquete != null) {
                    if (!paquete.isEmpty()) {
                        analizarPaquete(paquete);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(EntradaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Conexion cerrada exitosamente");
    }
    
    private void analizarPaquete(String paquete) {
        switch (paquete.charAt(0)) {
            case 'I':
                String[] ingreso = paquete.split("-");
                String usuario = ingreso[1];
                String contraseña = ingreso[2];
                ingresar(usuario, contraseña);
                break;
            case 'C':
                finalizarConexion();
                break;
            case 'A':
                String reto = paquete.split("-")[1];
                
        }
    }
    
    private void ingresar(String usuario, String contraseña) {
        boolean usuarioInexistente = true;
        for (Cuenta c : InvasionAlien.SERVIDOR.getCuentas()) {
            if (c.getUsuario().equals(usuario)) {
                usuarioInexistente = false;
                if (c.getContraseña().equals(contraseña)) {
                    System.out.println(contraseña);
                    synchronized (cuenta) {
                        cuenta.notify();
                        cuenta = c;
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
    
    private void analizarReto(String reto) {
        switch (reto) {
            case "A":
                
                break;
            case "R":
                String retado = reto.split(":")[1];
                int idRetado = InvasionAlien.SERVIDOR.getIdRetado(retado);
                if (idRetado == -1) {
                    GestorSalida.enviarUsuarioInexistente(salida);
                } else if (InvasionAlien.SERVIDOR.getCliente(idRetado) == null) {
                    GestorSalida.enviarUsuarioDesconectado(salida);
                } else if (InvasionAlien.SERVIDOR.getCliente(idRetado) != null) {
                    EntradaUsuario retadoc = InvasionAlien.SERVIDOR.getCliente(idRetado);
                    GestorSalida.enviarReto(retadoc.getSalida(), cuenta.getUsuario());
                }
                break;
        }
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public PrintWriter getSalida() {
        return salida;
    }
    
    public void finalizarConexion() {
        activa = false;
        InvasionAlien.SERVIDOR.removerCliente(cuenta.getId());
        try {
            cliente.close();
        } catch (IOException ex) {
            System.out.println("No se pudo cerrar la conexion con el cliente.");
        }
    }
    
}
