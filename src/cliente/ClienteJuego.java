package cliente;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Juan Felipe López Hurtado
 */
public class ClienteJuego extends javax.swing.JFrame implements Ventana {

    private Controlador controlador;
    
    public ClienteJuego(String usuario, String pos, String puntaje) {
        initComponents();
        usuarioL.setText(usuario);
        posicionL.setText(pos);
        puntajeL.setText(puntaje);
        this.setLocationRelativeTo(null);
        this.setSize(700, 700);
        this.setTitle("Invasion Alien");
    }
    
    public void initListeners(Controlador controlador) {
        this.controlador = controlador;
        salidaB.addActionListener(this.controlador);
        retarB.addActionListener(this.controlador);
        clasificacionB.addActionListener(this.controlador);
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        salidaB = new javax.swing.JButton();
        supPanelL = new javax.swing.JLabel();
        supPanelFL = new javax.swing.JLabel();
        usuL = new javax.swing.JLabel();
        usuarioL = new javax.swing.JLabel();
        posL = new javax.swing.JLabel();
        posicionL = new javax.swing.JLabel();
        punL = new javax.swing.JLabel();
        puntajeL = new javax.swing.JLabel();
        retarTF = new javax.swing.JTextField();
        clasificacionB = new javax.swing.JButton();
        retarB = new javax.swing.JButton();
        panelInfoL = new javax.swing.JLabel();
        panelRetarL = new javax.swing.JLabel();
        tituloL = new javax.swing.JLabel();
        fondoTituloL = new javax.swing.JLabel();
        fondoL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        salidaB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Cerrar.png"))); // NOI18N
        salidaB.setBorderPainted(false);
        salidaB.setContentAreaFilled(false);
        salidaB.setPreferredSize(new java.awt.Dimension(30, 30));
        getContentPane().add(salidaB, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, -1, -1));

        supPanelL.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 30)); // NOI18N
        supPanelL.setForeground(new java.awt.Color(255, 255, 255));
        supPanelL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        supPanelL.setText("Informacion del Jugador");
        getContentPane().add(supPanelL, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 144, 360, 40));

        supPanelFL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/SupInfo.png"))); // NOI18N
        supPanelFL.setText("jLabel4");
        getContentPane().add(supPanelFL, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 440, 50));

        usuL.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        usuL.setForeground(new java.awt.Color(255, 255, 255));
        usuL.setText("Usuario:");
        getContentPane().add(usuL, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 90, -1));

        usuarioL.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        usuarioL.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(usuarioL, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 260, 29));

        posL.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        posL.setForeground(new java.awt.Color(255, 255, 255));
        posL.setText("Posicion en la Clasificacion:");
        getContentPane().add(posL, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, -1, -1));

        posicionL.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        posicionL.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(posicionL, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, 90, 29));

        punL.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        punL.setForeground(new java.awt.Color(255, 255, 255));
        punL.setText("Puntaje:");
        getContentPane().add(punL, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, -1, -1));

        puntajeL.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        puntajeL.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(puntajeL, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, 130, 29));

        retarTF.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        retarTF.setForeground(new java.awt.Color(51, 51, 51));
        retarTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        retarTF.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 133, 179), 3, true));
        getContentPane().add(retarTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 560, 300, 60));

        clasificacionB.setBackground(new java.awt.Color(255, 204, 0));
        clasificacionB.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        clasificacionB.setForeground(new java.awt.Color(255, 255, 255));
        clasificacionB.setText("Ver Clasificacion");
        clasificacionB.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(195, 152, 0), 3, true));
        getContentPane().add(clasificacionB, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 260, 40));

        retarB.setBackground(new java.awt.Color(30, 167, 225));
        retarB.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 36)); // NOI18N
        retarB.setForeground(new java.awt.Color(255, 255, 255));
        retarB.setText("Retar");
        retarB.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 133, 179), 3, true));
        getContentPane().add(retarB, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 560, 140, 60));

        panelInfoL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/PanelInfo.png"))); // NOI18N
        panelInfoL.setText("jLabel2");
        getContentPane().add(panelInfoL, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 440, 340));

        panelRetarL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/PanelRet.png"))); // NOI18N
        panelRetarL.setText("jLabel3");
        getContentPane().add(panelRetarL, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 530, 540, 120));

        tituloL.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 40)); // NOI18N
        tituloL.setForeground(new java.awt.Color(255, 255, 255));
        tituloL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloL.setText("Invasion Alien");
        tituloL.setToolTipText("");
        getContentPane().add(tituloL, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 450, 70));

        fondoTituloL.setBackground(new java.awt.Color(255, 255, 255));
        fondoTituloL.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fondoTituloL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/SupInter.png"))); // NOI18N
        fondoTituloL.setText("Invasion Alien");
        fondoTituloL.setToolTipText("");
        getContentPane().add(fondoTituloL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 70));

        fondoL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/FondoJFrame.png"))); // NOI18N
        fondoL.setText("jLabel1");
        fondoL.setPreferredSize(new java.awt.Dimension(700, 700));
        getContentPane().add(fondoL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clasificacionB;
    private javax.swing.JLabel fondoL;
    private javax.swing.JLabel fondoTituloL;
    private javax.swing.JLabel panelInfoL;
    private javax.swing.JLabel panelRetarL;
    private javax.swing.JLabel posL;
    private javax.swing.JLabel posicionL;
    private javax.swing.JLabel punL;
    private javax.swing.JLabel puntajeL;
    private javax.swing.JButton retarB;
    private javax.swing.JTextField retarTF;
    private javax.swing.JButton salidaB;
    private javax.swing.JLabel supPanelFL;
    private javax.swing.JLabel supPanelL;
    private javax.swing.JLabel tituloL;
    private javax.swing.JLabel usuL;
    private javax.swing.JLabel usuarioL;
    // End of variables declaration//GEN-END:variables

    public JButton getClasificacionB() {
        return clasificacionB;
    }

    public JButton getRetarB() {
        return retarB;
    }

    public JTextField getRetarTF() {
        return retarTF;
    }

    public JButton getSalidaB() {
        return salidaB;
    }
    
}
