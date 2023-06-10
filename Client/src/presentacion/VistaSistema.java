
package presentacion;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.DefaultListModel;

import negocio.Contratacion;
import negocio.Factura;
import negocio.Persona;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;


public class VistaSistema extends javax.swing.JFrame {

    /** Creates new form NewJFrame */
    public VistaSistema() {
        initComponents();
    }
    private MainControlador controlador;
    private JButton botonActualizarMes;
    private JButton botonAltaTecnico;
    private JButton botonBajaContratacion;
    private JButton botonContratacion;
    private JButton botonFactura;
    private JButton botonNuevaFactura;
    private JButton botonNuevoAbonado;
    private JButton botonSolicitarTecnico;
    private JComboBox<Persona> comboAbonados;
    private JList<Factura> listaFacturas;
    private JScrollPane panelFacturas;
    private JScrollPane panelRespuesta;
    private JScrollPane panelContrataciones;
    private JTextArea respuesta;
    private JPanel zonaBotones;
    private JPanel zonaPrincipal;
    private JPanel zonaRespuesta;
    private JList<Contratacion> listaContrataciones;
    private DefaultComboBoxModel<Persona> modeloAbonados = new DefaultComboBoxModel<Persona>();
    private DefaultListModel<Factura> modeloFacturas = new DefaultListModel<Factura>();
    private DefaultListModel<Contratacion> modeloContrataciones = new DefaultListModel<Contratacion>();
    private DialogAltaTecnico dialogAltaTecnico;

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        zonaPrincipal = new JPanel();
        panelContrataciones = new JScrollPane();
        panelFacturas = new JScrollPane();
        listaFacturas = new JList<>();
        zonaBotones = new JPanel();
        botonFactura = new JButton();
        botonContratacion = new JButton();
        botonSolicitarTecnico = new JButton();
        botonBajaContratacion = new JButton();
        botonAltaTecnico = new JButton();
        botonNuevoAbonado = new JButton();
        botonNuevaFactura = new JButton();
        botonActualizarMes = new JButton();
        zonaRespuesta = new JPanel();
        panelRespuesta = new JScrollPane();
        respuesta = new JTextArea();
        comboAbonados = new JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listaFacturas.setModel(modeloFacturas);
        listaFacturas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        panelFacturas.setViewportView(listaFacturas);

        GroupLayout zonaPrincipalLayout = new GroupLayout(zonaPrincipal);
        zonaPrincipal.setLayout(zonaPrincipalLayout);
        zonaPrincipalLayout.setHorizontalGroup(
            zonaPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(zonaPrincipalLayout.createSequentialGroup()
                .addComponent(panelFacturas, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContrataciones, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE))
        );
        zonaPrincipalLayout.setVerticalGroup(
            zonaPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panelContrataciones, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
            .addComponent(panelFacturas)
        );
        
        listaContrataciones = new JList<>();
        listaContrataciones.setModel(modeloContrataciones);
        listaContrataciones.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        panelContrataciones.setViewportView(listaContrataciones);

        zonaBotones.setPreferredSize(new java.awt.Dimension(113, 450));

        botonFactura.setText("Pagar Factura");
        botonFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonFacturaMouseClicked(evt);
            }
        });
        botonFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFacturaActionPerformed(evt);
            }
        });

        botonContratacion.setText("Nueva Contratacion");
        botonContratacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonContratacionMouseClicked(evt);
            }
        });

        botonSolicitarTecnico.setText("Solicitar Tecnico");
        botonSolicitarTecnico.setActionCommand("");

        botonBajaContratacion.setText("Baja Contratacion");
        botonBajaContratacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonBajaContratacionMouseClicked(evt);
            }
        });

        botonAltaTecnico.setText("Alta Tecnico");
        botonAltaTecnico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonAltaTecnicoMouseClicked(evt);
            }
        });

        botonNuevoAbonado.setText("Nuevo Abonado");
        botonNuevoAbonado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonNuevoAbonadoMouseClicked(evt);
            }
        });

        botonNuevaFactura.setText("Nueva Factura");
        botonNuevaFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonNuevaFacturaMouseClicked(evt);
            }
        });

        botonActualizarMes.setText("Actualizar Mes");
        botonActualizarMes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonActualizarMesMouseClicked(evt);
            }
        });

        GroupLayout zonaBotonesLayout = new GroupLayout(zonaBotones);
        zonaBotones.setLayout(zonaBotonesLayout);
        zonaBotonesLayout.setHorizontalGroup(
            zonaBotonesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(botonFactura, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(botonContratacion, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
            .addComponent(botonBajaContratacion, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(botonSolicitarTecnico, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(botonActualizarMes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(botonNuevaFactura, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(botonNuevoAbonado, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(botonAltaTecnico, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        zonaBotonesLayout.setVerticalGroup(
            zonaBotonesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(zonaBotonesLayout.createSequentialGroup()
                .addComponent(botonBajaContratacion, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(botonFactura, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(botonContratacion, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonSolicitarTecnico, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonAltaTecnico, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonNuevoAbonado, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonNuevaFactura, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonActualizarMes, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        );

        respuesta.setEditable(false);
        respuesta.setColumns(20);
        respuesta.setRows(5);
        panelRespuesta.setViewportView(respuesta);

        GroupLayout zonaRespuestaLayout = new GroupLayout(zonaRespuesta);
        zonaRespuesta.setLayout(zonaRespuestaLayout);
        zonaRespuestaLayout.setHorizontalGroup(
            zonaRespuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panelRespuesta)
        );
        zonaRespuestaLayout.setVerticalGroup(
            zonaRespuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panelRespuesta, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
        );

        comboAbonados.setModel(modeloAbonados);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(comboAbonados, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(zonaRespuesta, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(zonaPrincipal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(zonaBotones, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(comboAbonados, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(zonaBotones, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(zonaPrincipal, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addComponent(zonaRespuesta, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }//GEN-END:initComponents

    private void botonFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonFacturaActionPerformed

    private void botonFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonFacturaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_botonFacturaMouseClicked

    private void botonContratacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonContratacionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_botonContratacionMouseClicked

    private void botonBajaContratacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonBajaContratacionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_botonBajaContratacionMouseClicked

    private void botonAltaTecnicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAltaTecnicoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_botonAltaTecnicoMouseClicked

    private void botonNuevoAbonadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonNuevoAbonadoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_botonNuevoAbonadoMouseClicked

    private void botonNuevaFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonNuevaFacturaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_botonNuevaFacturaMouseClicked

    private void botonActualizarMesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonActualizarMesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_botonActualizarMesMouseClicked

    public void arranca () {
    	this.pack();
    	this.setLocationRelativeTo(null);
    	this.setVisible(true);
    }
    
    public void setControlador (MainControlador c) {
    	botonActualizarMes.addActionListener(c);
    	botonAltaTecnico.addActionListener(c);
    	botonBajaContratacion.addActionListener(c);
    	botonContratacion.addActionListener(c);
    	botonFactura.addActionListener(c);
    	botonNuevaFactura.addActionListener(c);
    	botonNuevoAbonado.addActionListener(c);
    	botonSolicitarTecnico.addActionListener(c);
    }
    
    public void updateListaAbonados (ArrayList<Persona> abonados) {
    	this.modeloAbonados.removeAllElements();
    	for (Persona p : abonados) {
    		this.modeloAbonados.addElement(p);
    	}
    	this.repaint();
    }
    
    public void updateListaFacturas (ArrayList<Factura> facturas) {
    	this.modeloFacturas.clear();
    	for (Factura f : facturas) {
    		this.modeloFacturas.addElement(f);
    	}
    	this.repaint();
    }
    
    public void updateListaContrataciones (ArrayList<Contratacion> contrataciones) {
    	this.modeloContrataciones.clear();
    	for (Contratacion c : contrataciones) {
    		this.modeloContrataciones.addElement(c);
    	}
    	this.repaint();
    }
    
    public void abrirDialogAltaTecnico () {
    	this.dialogAltaTecnico = new DialogAltaTecnico();
    	this.dialogAltaTecnico.setControlador(this.controlador);
    	this.dialogAltaTecnico.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    	this.dialogAltaTecnico.setVisible(true);
    }

    public void cerrarDialogAltaTecnico () {
    	if (this.dialogAltaTecnico != null) {
    		this.dialogAltaTecnico.dispose();
    		this.dialogAltaTecnico.setVisible(false);
    		this.dialogAltaTecnico = null;
    	}
    }

    public String getNombreAltaTecnico () {
    	return this.dialogAltaTecnico.getNombreAltaTecnico();
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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing
                                                                   .UIManager
                                                                   .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing
                         .UIManager
                         .setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util
                .logging
                .Logger
                .getLogger(VistaSistema.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util
                .logging
                .Logger
                .getLogger(VistaSistema.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util
                .logging
                .Logger
                .getLogger(VistaSistema.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util
                .logging
                .Logger
                .getLogger(VistaSistema.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt
            .EventQueue
            .invokeLater(new Runnable() {
                public void run() {
                    new VistaSistema().setVisible(true);
                }
            });
    }
}
