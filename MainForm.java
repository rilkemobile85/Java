/*
 * MainForm.java
 *
 * Created on December 14, 2006, 9:43 PM
 */

package gui;

import aeropuerto.*;
import eda.ListaSE;
import java.util.ArrayList;

public class MainForm extends javax.swing.JFrame implements java.awt.event.ActionListener {
    
    /** Creates new form MainForm */
    public MainForm() {
        initComponents();
        
        controladorAereo = new ControladorAereo();
        
        listaAterrizados = new ListaSE<Avión>();
    }
    
    private ListaSE<Avión> listaAterrizados;
    
    
// <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        mostrarAterrizados = new java.awt.List();
        listaVolando = new java.awt.List();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        
        label1.setText("Aterrizados");
        
        label2.setText("En el aire");
        
        jMenu1.setText("Operaciones");
        jMenuItem1.setText("Agregar avi\u00f3n de pasajeros");
        jMenuItem1.addActionListener(this);
        
        jMenu1.add(jMenuItem1);
        
        jMenuItem2.setText("Agregar avi\u00f3n de carga");
        jMenuItem2.addActionListener(this);
        
        jMenu1.add(jMenuItem2);
        
        jMenuItem3.setText("Agregar Jet ejecutivo");
        jMenuItem3.addActionListener(this);
        
        jMenu1.add(jMenuItem3);
        
        jMenuItem4.setText("Aterrizar");
        jMenuItem4.addActionListener(this);
        
        jMenu1.add(jMenuItem4);
        
        jMenuItem5.setText("Salir");
        jMenuItem5.addActionListener(this);
        
        jMenu1.add(jMenuItem5);
        
        menuBar.add(jMenu1);
        
        setJMenuBar(menuBar);
        
        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(layout.createSequentialGroup()
                .add(89, 89, 89)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(mostrarAterrizados, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 290, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(label1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 91, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(35, 35, 35)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(label2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(listaVolando, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 281, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
                );
        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(layout.createSequentialGroup()
                .add(45, 45, 45)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(label1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(label2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 11, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                .add(org.jdesktop.layout.GroupLayout.TRAILING, listaVolando, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(org.jdesktop.layout.GroupLayout.TRAILING, mostrarAterrizados, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addContainerGap())
                );
        pack();
    }
    
// Code for dispatching events from components to event handlers.
    
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == jMenuItem1) {
            MainForm.this.jMenuItem1ActionPerformed(evt);
        } else if (evt.getSource() == jMenuItem2) {
            MainForm.this.jMenuItem2ActionPerformed(evt);
        } else if (evt.getSource() == jMenuItem3) {
            MainForm.this.jMenuItem3ActionPerformed(evt);
        } else if (evt.getSource() == jMenuItem4) {
            MainForm.this.jMenuItem4ActionPerformed(evt);
        } else if (evt.getSource() == jMenuItem5) {
            MainForm.this.jMenuItem5ActionPerformed(evt);
        }
    }// </editor-fold>//GEN-END:initComponents
    
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        try {
            listaAterrizados.Adicionar(controladorAereo.Aterrizar());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        actualizarListVolando();
        
        mostrarAterrizados.removeAll();
        
        for (int i = 0; i < listaAterrizados.Longitud(); i++) {
            Avión a = null;
            try {
                a = listaAterrizados.Obtener(i);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            mostrarAterrizados.add(a.getMatricula() + " de " + a.getAerolinea() + "(" + a.getPrioridad() + ")");
        }
        
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed
    
    void actualizarListVolando() {
        listaVolando.removeAll();
        ListaSE<Avión> lista = null;
        try {
            lista = controladorAereo.getAviones();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        for (int i = 0; i < lista.Longitud(); i++) {
            Avión a = null;
            try {
                a = lista.Obtener(i);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            listaVolando.add(a.getMatricula() + " de " + a.getAerolinea() + "(" + a.getPrioridad() + ")");
        }
        
    }
    
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem5ActionPerformed
    
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        FJetEjecutivo f = new FJetEjecutivo(controladorAereo);
        f.setVisible(true);
        actualizarListVolando();
    }//GEN-LAST:event_jMenuItem3ActionPerformed
    
    private ControladorAereo controladorAereo;
    
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        FAviónCarga f = new FAviónCarga(controladorAereo);
        f.setVisible(true);
        actualizarListVolando();
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        FAviónPasajeros f = new FAviónPasajeros(controladorAereo);
        f.setVisible(true);
        actualizarListVolando();
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }
    
// Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.List listaVolando;
    private javax.swing.JMenuBar menuBar;
    private java.awt.List mostrarAterrizados;
// End of variables declaration//GEN-END:variables
    
}
