package cliente;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Juan Felipe López Hurtado
 */
public class InicioSesion extends javax.swing.JFrame implements Ventana {
    
    private Controlador controlador;
    
    public InicioSesion() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setSize(700, 700);
        this.setTitle("Invasion Alien");
    }
    
    public void initListeners(Controlador controlador) {
        this.controlador = controlador;
        salidaB.addActionListener(this.controlador);
        ingresoB.addActionListener(this.controlador);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        salidaB = new javax.swing.JButton();
        iconoL = new javax.swing.JLabel();
        usuarioTF = new javax.swing.JTextField();
        contraseñaTF = new javax.swing.JPasswordField();
        contraseñaL = new javax.swing.JLabel();
        usuarioL = new javax.swing.JLabel();
        ingresoB = new javax.swing.JButton();
        panelL = new javax.swing.JLabel();
        fondoL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Invasion Alien");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        salidaB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Cerrar.png"))); // NOI18N
        salidaB.setBorder(null);
        salidaB.setBorderPainted(false);
        salidaB.setContentAreaFilled(false);
        getContentPane().add(salidaB, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, 30, 30));

        iconoL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/IconoFondo.png"))); // NOI18N
        iconoL.setText("jLabelIcono");
        getContentPane().add(iconoL, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 130, 130));

        usuarioTF.setFont(new java.awt.Font("Arial Narrow", 1, 20)); // NOI18N
        usuarioTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usuarioTF.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 3, true));
        usuarioTF.setPreferredSize(new java.awt.Dimension(300, 40));
        getContentPane().add(usuarioTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, -1, -1));

        contraseñaTF.setFont(new java.awt.Font("Arial Narrow", 1, 20)); // NOI18N
        contraseñaTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        contraseñaTF.setToolTipText("");
        contraseñaTF.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 3, true));
        contraseñaTF.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        contraseñaTF.setPreferredSize(new java.awt.Dimension(300, 40));
        getContentPane().add(contraseñaTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, -1, -1));

        contraseñaL.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 36)); // NOI18N
        contraseñaL.setForeground(new java.awt.Color(51, 51, 51));
        contraseñaL.setText("Contraseña");
        getContentPane().add(contraseñaL, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 420, 150, 30));

        usuarioL.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 36)); // NOI18N
        usuarioL.setForeground(new java.awt.Color(51, 51, 51));
        usuarioL.setText("Usuario");
        getContentPane().add(usuarioL, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, 100, 30));

        ingresoB.setBackground(new java.awt.Color(30, 167, 225));
        ingresoB.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        ingresoB.setForeground(new java.awt.Color(255, 255, 255));
        ingresoB.setText("Iniciar Sesion");
        ingresoB.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(23, 127, 171), 3, true));
        getContentPane().add(ingresoB, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 560, 170, 40));

        panelL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/PanelInicioSesion.png"))); // NOI18N
        panelL.setText("jLabel4");
        getContentPane().add(panelL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 400, 400));

        fondoL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/FondoJFrame.png"))); // NOI18N
        fondoL.setText("jLabelFondo");
        getContentPane().add(fondoL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel contraseñaL;
    private javax.swing.JPasswordField contraseñaTF;
    private javax.swing.JLabel fondoL;
    private javax.swing.JLabel iconoL;
    private javax.swing.JButton ingresoB;
    private javax.swing.JLabel panelL;
    private javax.swing.JButton salidaB;
    private javax.swing.JLabel usuarioL;
    private javax.swing.JTextField usuarioTF;
    // End of variables declaration//GEN-END:variables
    
    public JButton getBotonI() {
        return ingresoB;
    }
    
    public JButton getBotonC() {
        return salidaB;
    }

    public JPasswordField getContraseñaTF() {
        return contraseñaTF;
    }

    public JTextField getUsuarioTF() {
        return usuarioTF;
    }
    
}
