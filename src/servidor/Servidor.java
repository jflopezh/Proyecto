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
    
    private ServerSocket servidor;
    private TreeMap<Integer, EntradaUsuario> clientes;
    private ArrayList<Cuenta> cuentas;
    private TreeMap<Integer, Cuenta> ranking;
    private TreeMap<Integer, Competencia> competencias;
    
    public Servidor(int puerto) {
        try {
            servidor = new ServerSocket(puerto);
        } catch (IOException ex) {
            System.out.println("El servidor no pudo ser creado");
        }
        clientes = new TreeMap<>();
        cuentas = new ArrayList<>();
        ranking = new TreeMap<>();
        competencias = new TreeMap<>();
        Cuenta c = new Cuenta(1, "juan", "miculo123", 1000, 3);
        Cuenta c2 = new Cuenta(2, "mario", "jajaja", 1200, 4);
        cuentas.add(c);
        cuentas.add(c2);
    }
    
    @Override
    public void run() {
        while (!InvasionAlien.CERRANDO) {
            try {
                EntradaUsuario cliente = new EntradaUsuario(servidor.accept());
                cliente.start();
                System.out.println("Se ha conectado un usuario");
                Conector conexion = new Conector(cliente);
                conexion.start();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void añadirCliente(int idCuenta, EntradaUsuario cliente) {
        clientes.put(idCuenta, cliente);
    }
    
    public void removerCliente(int id) {
        clientes.remove(id);
    }
    
    public EntradaUsuario getCliente(int id) {
        if (!clientes.containsKey(id)) {
            return null;
        }
        return clientes.get(id);
    }
    
    public void añadirCompetencia(int id, Competencia competencia) {
        competencias.put(id, competencia);
    }
    
    public int getIndexCompetencias() {
        return competencias.lastKey();
    }
    
    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }
    
    public synchronized int getIdRetado(String retado) {
        for (Cuenta c : cuentas) {
            if (c.getUsuario().equals(retado)) {
                return c.getId();
            }
        }
        return -1;
    }
}
