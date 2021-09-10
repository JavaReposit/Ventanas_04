/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empresas.gui;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JOptionPane;
import modelo.*;
/**
 *
 * @author tribunal
 */
public class VentanaFinAlta extends javax.swing.JDialog {

    Empresa empresa;
    int codigoEnNumero;
    String cif, codigo, razonSocial;
    
    /**
     * Creates new form VentanaInicioAlta
     */
    public VentanaFinAlta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initHelp();
    }

    private void initHelp(){
        File fichero = new File(".\\src\\help\\help_set.hs");
        try {
            URL hsURL = fichero.toURI().toURL();
            // Crea el HelpSet
            HelpSet helpSet = new HelpSet(null, hsURL);
            HelpBroker hb = helpSet.createHelpBroker();
            hb.enableHelpKey(getRootPane(),"ventana_secundaria", helpSet);
            hb.enableHelp(jButtonFinalizar, "ventana_secundaria", helpSet);
        } catch (Exception eAyuda) {
            System.err.println("No se encuentra el fichero help");  
        }
    }    
    
    
    public void recibeEmpresa(String cif, String codigo, String razonSocial){
        this.cif=cif;
        this.codigo=codigo;
        this.razonSocial=razonSocial;
        jTextFieldCodigo.setText(codigo);
        jTextFieldRazonSocial.setText(razonSocial);
    }
    
    private boolean isNumeric(String codigo){
        boolean testigo;
        try{
            Integer.parseInt(codigo);
            testigo= true;
        } catch (NumberFormatException nfe) {
            testigo = false;
        }
        return testigo;
    }
    
    private void crearEmpresa() throws Exception{
        Empresa empresa = new Empresa();
        empresa.CIF=cif;
        empresa.codigo=codigo;
        empresa.razonSocial=razonSocial;
        try {
            Operaciones.newEmpresa(empresa);
            JOptionPane.showMessageDialog(this, "Empresa guardada con éxito.","Aviso",JOptionPane.WARNING_MESSAGE,null);
            dispose();
        } catch (IOException eCrearEmpresa) {
            JOptionPane.showMessageDialog(this, "No se ha podido crear la empresa", "Error", JOptionPane.ERROR_MESSAGE, null);
        }
    }
    
    private void cancelarVentana(){
        int opcion;
        opcion = JOptionPane.showConfirmDialog(this, "Si continúa, se cancelaran los datos introducidos. ¿Desea Continuar?", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (opcion==JOptionPane.YES_OPTION)
            dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelAltaEmpresa = new javax.swing.JPanel();
        jLabelCodigoEmpresa = new javax.swing.JLabel();
        jLabelRazonSocial = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jTextFieldRazonSocial = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonFinalizar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelAltaEmpresa.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Nuevo Código de empresa"));

        jLabelCodigoEmpresa.setText("Código de empresa");

        jLabelRazonSocial.setText("Razón Social");

        jTextFieldCodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldCodigoFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanelAltaEmpresaLayout = new javax.swing.GroupLayout(jPanelAltaEmpresa);
        jPanelAltaEmpresa.setLayout(jPanelAltaEmpresaLayout);
        jPanelAltaEmpresaLayout.setHorizontalGroup(
            jPanelAltaEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAltaEmpresaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAltaEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCodigoEmpresa)
                    .addComponent(jLabelRazonSocial))
                .addGap(5, 5, 5)
                .addGroup(jPanelAltaEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanelAltaEmpresaLayout.setVerticalGroup(
            jPanelAltaEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAltaEmpresaLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanelAltaEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCodigoEmpresa)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanelAltaEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRazonSocial)
                    .addComponent(jTextFieldRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Se va a proceder a dar de alta una empresa.");

        jLabel3.setText("Pulse 'Finalizar' para aceptar,");

        jLabel4.setText("'Cancelar' para abandonar la opción o informe otro C.I.F.");

        jButtonFinalizar.setText("Finalizar");
        jButtonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarActionPerformed(evt);
            }
        });
        jButtonFinalizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonFinalizarKeyPressed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jButtonCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonCancelarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanelAltaEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonFinalizar)
                .addGap(5, 5, 5)
                .addComponent(jButtonCancelar)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanelAltaEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFinalizar)
                    .addComponent(jButtonCancelar))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCodigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCodigoFocusLost
        codigo = jTextFieldCodigo.getText();
        if (!codigo.isEmpty()){
            if (isNumeric(codigo)){
                codigoEnNumero = Integer.parseInt(codigo);
                if (codigoEnNumero <= 0 || codigoEnNumero >= 3201)
                    JOptionPane.showMessageDialog(this, "El código de la empresa "
                            + "debe estar entre 1 y 3200.", "Aviso", 
                            JOptionPane.WARNING_MESSAGE, null);
                
            } else {
            JOptionPane.showMessageDialog(this, "El código de la empresa debe ser "
                    + "numérico.", "Aviso", JOptionPane.WARNING_MESSAGE, null);
            }
        }
    }//GEN-LAST:event_jTextFieldCodigoFocusLost

    private void jButtonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarActionPerformed
        try {
            crearEmpresa();
        } catch (Exception ex) {
            Logger.getLogger(VentanaFinAlta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonFinalizarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        cancelarVentana();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonFinalizarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonFinalizarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            try {
                crearEmpresa();
            } catch (Exception ex) {
                Logger.getLogger(VentanaFinAlta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonFinalizarKeyPressed

    private void jButtonCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonCancelarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            cancelarVentana();
        }
    }//GEN-LAST:event_jButtonCancelarKeyPressed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonFinalizar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelCodigoEmpresa;
    private javax.swing.JLabel jLabelRazonSocial;
    private javax.swing.JPanel jPanelAltaEmpresa;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldRazonSocial;
    // End of variables declaration//GEN-END:variables
}