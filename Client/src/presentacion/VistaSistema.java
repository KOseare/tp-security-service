
package presentacion;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.TreeSet;

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


public class VistaSistema extends javax.swing.JFrame implements MouseListener {

    private DialogFactura dialogFactura;

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
    private DialogNuevoAbonado dialogNuevoAbonado;

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

        botonContratacion.setText("Nueva Contratacion");

        botonSolicitarTecnico.setText("Solicitar Tecnico");

        botonSolicitarTecnico.setActionCommand("");

        botonBajaContratacion.setText("Baja Contratacion");

        botonAltaTecnico.setText("Alta Tecnico");

        botonNuevoAbonado.setText("Nuevo Abonado");

        botonNuevaFactura.setText("Nueva Factura");

        botonActualizarMes.setText("Actualizar Mes");

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
                .addGap(29, 29, 29)
                .addComponent(botonFactura, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGap(28,28,28 )
                .addComponent(botonContratacion, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(botonSolicitarTecnico, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(botonAltaTecnico, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(botonNuevoAbonado, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
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
        comboAbonados.setActionCommand("Seleccion Abonado");

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
    }
    public void arranca () {
    	this.pack();
    	this.setLocationRelativeTo(null);
    	this.setVisible(true);
    }
    
    public void setControlador (MainControlador c) {
        this.controlador = c;
    	botonActualizarMes.addActionListener(c);
    	botonAltaTecnico.addActionListener(c);
    	botonBajaContratacion.addActionListener(c);
    	botonContratacion.addActionListener(c);
    	botonFactura.addActionListener(c);
    	botonNuevaFactura.addActionListener(c);
    	botonNuevoAbonado.addActionListener(c);
    	botonSolicitarTecnico.addActionListener(c);
      comboAbonados.addActionListener(c);
        comboAbonados.addActionListener(c);
        listaFacturas.addListSelectionListener(c);
    }
    
    public void updateListaAbonados (ArrayList<Persona> abonados) {
    	this.modeloAbonados.removeAllElements();
    	for (Persona p : abonados) {
    		this.modeloAbonados.addElement(p);
    	}
    	this.repaint();
    }
    
    public void updateListaFacturas (TreeSet<Factura> facturas) {
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

    public Persona getAbonadoSeleccionado () {
    	return (Persona) this.comboAbonados.getSelectedItem();
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

    public void abrirDialogFactura(){
        this.dialogFactura = new DialogFactura(listaFacturas.getSelectedValue());
        this.dialogFactura.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.dialogFactura.setVisible(true);
    }

    public String getNombreAltaTecnico () {
    	return this.dialogAltaTecnico.getNombreAltaTecnico();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == listaFacturas && e.getClickCount() == 1) {
            this.controlador.abrirDialogFactura();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    public void dibujarRespuesta(String resp){
        this.respuesta.append(resp +"\n");
    }

    public void abrirDialogNuevoAbonado () {
    	this.dialogNuevoAbonado = new DialogNuevoAbonado();
    	this.dialogNuevoAbonado.setControlador(this.controlador);
    	this.dialogNuevoAbonado.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    	this.dialogNuevoAbonado.setVisible(true);
    }

    public void cerrarDialogNuevoAbonado () {
    	if (this.dialogNuevoAbonado != null) {
    		this.dialogNuevoAbonado.dispose();
    		this.dialogNuevoAbonado.setVisible(false);
    		this.dialogNuevoAbonado = null;
    	}
    }

    public String getNombreNuevoAbonado () {
    	return this.dialogNuevoAbonado.getNombreNuevoAbonado();
    }
    public String getDniNuevoAbonado () {
    	return this.dialogNuevoAbonado.getDniNuevoAbonado();
    }
    public String getTipoNuevoAbonado () {
    	return this.dialogNuevoAbonado.getTipoNuevoAbonado();
    }
}
