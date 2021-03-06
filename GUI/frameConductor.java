/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Usuarios.DAOUsuario;
import java.awt.CardLayout;

/**
 *
 * @author Juan Suaza
 */
public class frameConductor extends javax.swing.JFrame {

    String cedulaConductor;
    String nombreConductor;
    
    CardLayout clConductor;
    
    public frameConductor() {
        initComponents();
        
        panelContenedor.setLayout(new CardLayout());
        
        panelContenedor.add(panelInicialSlogan, "Inicio");
        panelContenedor.add(consultarTurnosPanel, "Turnos");

        clConductor = (CardLayout)panelContenedor.getLayout();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelInicialSlogan = new javax.swing.JPanel();
        slogan = new javax.swing.JLabel();
        consultarTurnosPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTurnos = new javax.swing.JTable();
        panelFondo = new javax.swing.JPanel();
        consultarTurnos = new javax.swing.JButton();
        panelContenedor = new javax.swing.JPanel();
        banner = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        panelInicialSlogan.setBackground(new java.awt.Color(255, 255, 255));

        slogan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/slogan.png"))); // NOI18N

        javax.swing.GroupLayout panelInicialSloganLayout = new javax.swing.GroupLayout(panelInicialSlogan);
        panelInicialSlogan.setLayout(panelInicialSloganLayout);
        panelInicialSloganLayout.setHorizontalGroup(
            panelInicialSloganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInicialSloganLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(slogan)
                .addGap(39, 39, 39))
        );
        panelInicialSloganLayout.setVerticalGroup(
            panelInicialSloganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicialSloganLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(slogan)
                .addContainerGap(178, Short.MAX_VALUE))
        );

        consultarTurnosPanel.setBackground(new java.awt.Color(255, 255, 255));

        jTableTurnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bus", "Inicio", "Fin", "Fecha"
            }
        ));
        jTableTurnos.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTableTurnos);

        javax.swing.GroupLayout consultarTurnosPanelLayout = new javax.swing.GroupLayout(consultarTurnosPanel);
        consultarTurnosPanel.setLayout(consultarTurnosPanelLayout);
        consultarTurnosPanelLayout.setHorizontalGroup(
            consultarTurnosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
        );
        consultarTurnosPanelLayout.setVerticalGroup(
            consultarTurnosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelFondo.setBackground(new java.awt.Color(255, 255, 255));

        consultarTurnos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/Botones/consultarTurno.png"))); // NOI18N
        consultarTurnos.setBorder(null);
        consultarTurnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarTurnosActionPerformed(evt);
            }
        });

        panelContenedor.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 641, Short.MAX_VALUE)
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        banner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/banner.png"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/calendar-1.png"))); // NOI18N

        javax.swing.GroupLayout panelFondoLayout = new javax.swing.GroupLayout(panelFondo);
        panelFondo.setLayout(panelFondoLayout);
        panelFondoLayout.setHorizontalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(consultarTurnos)
                .addGap(18, 18, 18)
                .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(banner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelFondoLayout.setVerticalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addComponent(banner)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(consultarTurnos)
                            .addComponent(jLabel1))
                        .addGap(0, 361, Short.MAX_VALUE))
                    .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void consultarTurnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarTurnosActionPerformed
        // TODO add your handling code here:
        panelContenedor.setVisible(true);
        clConductor.show(panelContenedor, "Turnos");
        System.out.println(cedulaConductor);
        new DAOUsuario().consultarTurno(cedulaConductor, jTableTurnos);
    }//GEN-LAST:event_consultarTurnosActionPerformed

    public String getCedulaConductor() {
        return cedulaConductor;
    }

    public void setCedulaConductor(String cedulaConductor) {
        this.cedulaConductor = cedulaConductor;
    }

    public String getNombreConductor() {
        return nombreConductor;
    }

    public void setNombreConductor(String nombreConductor) {
        this.nombreConductor = nombreConductor;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frameConductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frameConductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frameConductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frameConductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frameConductor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel banner;
    private javax.swing.JButton consultarTurnos;
    private javax.swing.JPanel consultarTurnosPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTurnos;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JPanel panelInicialSlogan;
    private javax.swing.JLabel slogan;
    // End of variables declaration//GEN-END:variables
}
