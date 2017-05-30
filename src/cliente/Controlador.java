/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 *
 * @author aleja
 */
public class Controlador implements ActionListener {
    
    private Conexion conexion;
    private Ventana ventana;

    public Controlador(Conexion conexion, Ventana ventana) {
        this.conexion = conexion;
        this.ventana = ventana;
        this.ventana.initListeners(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ventana instanceof InicioSesion) {
            InicioSesion is = (InicioSesion) ventana;
            if (ae.getSource().equals(is.getBotonI())) {
                String usuario = is.getUsuarioTF().getText();
                StringBuilder s = new StringBuilder();
                s.append(is.getContraseñaTF().getPassword());
                String contraseña = s.toString();
                if (!usuario.isEmpty() && !contraseña.isEmpty()) {
                    GestorSalida.enviarIngreso(conexion.getSalida(), usuario, contraseña);
                }
            } else if (ae.getSource().equals(is.getBotonC())) {
                try {
                    conexion.finalizar();
                    GestorSalida.enviarCerrar(conexion.getSalida());
                    conexion.getSocket().close();
                } catch (IOException ex) {
                    System.out.println("No se pudo cerrar la conexion");
                }
                System.exit(0);
            }
        } else if (ventana instanceof ClienteJuego) {
            ClienteJuego cj = (ClienteJuego) ventana;
            if (ae.getSource().equals(cj.getSalidaB())) {
                try {
                    conexion.finalizar();
                    GestorSalida.enviarCerrar(conexion.getSalida());
                    conexion.getSocket().close();
                } catch (IOException ex) {
                    System.out.println("No se pudo cerrar la conexion");
                }
                System.exit(0);
            } else if (ae.getSource().equals(cj.getClasificacionB())) {
                
            } else if (ae.getSource().equals(cj.getRetarB())) {
                String retado = cj.getRetarTF().getText();
                if (!retado.isEmpty()) {
                    GestorSalida.enviarReto(conexion.getSalida(), retado);
                }
            }
        }
    }
    
}
