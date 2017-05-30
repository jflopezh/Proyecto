package servidor;

/**
 *
 * @author aleja
 */
public class Conector extends Thread {
    
    private EntradaUsuario cliente;

    public Conector(EntradaUsuario cliente) {
        this.cliente = cliente;
    }
    
    @Override
    public void run() {
        synchronized (cliente.getCuenta()) {
            if (cliente.getCuenta().getId() == 0) {
                try {
                    cliente.getCuenta().wait();
                } catch (InterruptedException ex) {}
            }
            Servidor.añadirCliente(cliente.getCuenta().getId(), cliente);
        }
    }
    
}
