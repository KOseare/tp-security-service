package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocio.Domicilio;
import negocio.Persona;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class DialogNuevaContratacion extends JDialog{

	private final JPanel contentPanel = new JPanel();
	private JButton botonCrear;
	private JButton botonCancelar;
	private JRadioButton viviendaRadioBoton;
	private JRadioButton comercioRadioBoton;
	private ButtonGroup buttonGroup;
	private JComboBox<Domicilio> domicilioComboBox;
	private JCheckBox camaraCheckBox;
	private JCheckBox antipanicoCheckBox;
	private JCheckBox movilCheckBox;
  private DefaultComboBoxModel<Domicilio> modeloDomicilios = new DefaultComboBoxModel<Domicilio>();

	/**
	 * Create the dialog.
	 */
	public DialogNuevaContratacion(ArrayList<Domicilio> domicilios) {
		this.buttonGroup = new ButtonGroup();
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("NUEVA CONTRATACION");
		setAlwaysOnTop(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(8, 1, 0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			{
				JLabel domicilioLabel = new JLabel("Domicilio: ");
				panel.add(domicilioLabel);
			}
			{
				this.domicilioComboBox = new JComboBox<>();
				this.domicilioComboBox.setModel(modeloDomicilios);
				for (Domicilio d : domicilios) {
	    		this.modeloDomicilios.addElement(d);
	    	}
				panel.add(this.domicilioComboBox);
			}
		}
		
		viviendaRadioBoton = new JRadioButton("Monitoreo Vivienda");
		viviendaRadioBoton.setSelected(true);
		contentPanel.add(viviendaRadioBoton);
		
		comercioRadioBoton = new JRadioButton("Monitoreo Comercio");
		contentPanel.add(comercioRadioBoton);
		this.buttonGroup.add(comercioRadioBoton);
		{
			this.camaraCheckBox = new JCheckBox("Camara");
			contentPanel.add(this.camaraCheckBox);
		}
		this.buttonGroup.add(viviendaRadioBoton);
		{
			this.antipanicoCheckBox = new JCheckBox("Boton Antipanico");
			contentPanel.add(this.antipanicoCheckBox);
		}
		{
			this.movilCheckBox = new JCheckBox("Movil de Acompañamiento");
			contentPanel.add(this.movilCheckBox);
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				botonCrear = new JButton("CREAR");
				botonCrear.setFont(new Font("Tahoma", Font.BOLD, 11));
				botonCrear.setActionCommand("CrearNuevaContratacion");
				buttonPane.add(botonCrear);
				getRootPane().setDefaultButton(botonCrear);
			}
			{
				botonCancelar = new JButton("Cancelar");
				botonCancelar.setActionCommand("CancelarNuevaContratacion");
				buttonPane.add(botonCancelar);
			}
		}
	}

	public void setControlador (MainControlador c) {
		this.botonCrear.addActionListener(c);
		this.botonCancelar.addActionListener(c);
	}
	
	public Domicilio getDomicilioContratacion() {
		return (Domicilio) this.domicilioComboBox.getSelectedItem();
	}
	public String getTipoContratacion () {
		return this.comercioRadioBoton.isSelected() ? "Comercio" : "Vivienda";
	}
	public boolean getCamaraSelectedContratacion () {
		return this.camaraCheckBox.isSelected();
	}
	public boolean getAntipanicoSelectedContratacion () {
		return this.antipanicoCheckBox.isSelected();
	}
	public boolean getMovilSelectedContratacion () {
		return this.movilCheckBox.isSelected();
	}
}
