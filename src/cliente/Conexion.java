/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author aleja
 */
public class Conexion extends Thread {
    
    private Socket socket;
    private BufferedReader entrada;
    private PrintWriter salida;
    private boolean activa;
    
    public Conexion() throws IOException {
        socket = new Socket(InvasionAlien.IP, InvasionAlien.PUERTO);
        entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        salida = new PrintWriter(socket.getOutputStream());
        activa = true;
    }
    
    @Override
    public void run() {
        String paquete;
        while (activa) {
            try {
                paquete = entrada.readLine();
                System.out.println("PAQUETE RECIBIDO: " + paquete);
                if(!paquete.isEmpty()) {
                    analizarPaquete(paquete);
                }
            } catch (IOException ex) {
                System.out.println("Error en la lectura de un paquete.");
            }
        }
        System.out.println("Conexion cerrada exitosamente");
    }
    
    private void analizarPaquete(String paquete) {
        switch (paquete.charAt(0)) {
            case 'I':
                char ingreso = paquete.charAt(2);
                procesarRespuestaIngreso(ingreso);
                break;
            case 'A':
                String reto = paquete.split("-")[1];
                procesarReto(reto);
                break;
            case 'L':
                String competencia = paquete.split("-")[1];
                procesarCompetencia(competencia);
                break;
        }
    }
    
    private void procesarRespuestaIngreso(char ingreso) {
        switch (ingreso) {
            case 'T':
                synchronized (InvasionAlien.IS) {
                    InvasionAlien.IS.notify();
                    InvasionAlien.IS.setVisible(false);
                }
                break;
            case 'U':
                JOptionPane.showMessageDialog(null, "No se ha encontrado el usuario ingresado");
                break;
            case'C':
                JOptionPane.showMessageDialog(null, "La contraseña no coincide con el usuario ingresado");
                break;
        }
    }
    
    private void procesarReto(String reto) {
        switch (reto.charAt(0)) {
            case 'I':
                JOptionPane.showMessageDialog(null, "El usuario ingresado no existe");
                break;
            case 'D':
                JOptionPane.showMessageDialog(null, "El usuario ingresado no se encuentra en linea");
                break;
            case 'R':
                String retador = reto.split(":")[1];
                int dec = JOptionPane.showConfirmDialog(null, "El usuario " + retador + " te ha retado. ¿Aceptas?");
                if (dec == JOptionPane.YES_OPTION) {
                    GestorSalida.enviarAceptacionReto(salida, retador);
                }
                break;
        }
    }
    
    private void procesarCompetencia(String comp) {
        switch (comp.charAt(0)) {
            case 'C':
                String[] competencia = comp.split(":");
                String id = competencia[1];
                String imagenJ1 = competencia[2];
                String imagenJ2 = competencia[3];
                Jugador jugador1 = new Jugador(1, (Integer.parseInt(imagenJ1) + 10) + ".png");
                Jugador jugador2 = new Jugador(2, (Integer.parseInt(imagenJ2) + 10) + ".png");
                ArrayList<Monstruo> m = new ArrayList<>();
                String[] monstruos = competencia[4].split("_");
                for (String mo : monstruos) {
                    if (!mo.isEmpty()) {
                        String[] dMonstruo = mo.split(",");
                        m.add(new Monstruo(Integer.parseInt(dMonstruo[0]), Boolean.getBoolean(dMonstruo[1]), 
                                           Integer.parseInt(dMonstruo[2]), Integer.parseInt(dMonstruo[3]), 
                                           Integer.parseInt(dMonstruo[4])));
                    }
                }
                InvasionAlien.iniciarCompetencia(new Competencia(Integer.parseInt(id), jugador1, jugador2, m));
                break;
            default:
                throw new AssertionError();
        }
    }
    
    public PrintWriter getSalida() {
        return salida;
    }

    public Socket getSocket() {
        return socket;
    }
    
    public void finalizar() {
        activa = false;
    }
    
}
