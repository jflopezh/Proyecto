package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author aleja
 */
public class Servidor extends Thread{
    
    private static ServerSocket servidor;
    private static TreeMap<Integer, EntradaUsuario> clientes;
    private static ArrayList<Cuenta> cuentas;
    private static TreeMap<Integer, Cuenta> ranking;
    private static TreeMap<Integer, Competencia> competencias;
    
    public Servidor(int puerto) {
        try {
            servidor = new ServerSocket(puerto);
        } catch (IOException ex) {
            System.out.println("El servidor no pudo ser creado");
        }
    }
    
    @Override
    public void run() {
        while (!InvasionAlien.cerrando) {
            try {
                EntradaUsuario cliente = new EntradaUsuario(servidor.accept());
                cliente.start();
                System.out.println("Se ha conectado un usuario");
                Conector conexion = new Conector(cliente);
                conexion.start();
            } catch (IOException ex) {}
        }
    }
    
    public static void añadirCliente(int idCuenta, EntradaUsuario cliente) {
        clientes.put(idCuenta, cliente);
    }
    
    public static ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }
}
