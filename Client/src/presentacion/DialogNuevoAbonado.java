package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class DialogNuevoAbonado extends JDialog{

	private final JPanel contentPanel = new JPanel();
	private JTextField nombreField;
	private JButton botonCrear;
	private JButton botonCancelar;
	private JTextField dniField;
	private JRadioButton fisicaRadioBoton;
	private JRadioButton juridicaRadioBoton;
	private ButtonGroup buttonGroup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogNuevoAbonado dialog = new DialogNuevoAbonado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogNuevoAbonado() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("NUEVO ABONADO");
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
				JLabel nombreLabel = new JLabel("Nombre: ");
				panel.add(nombreLabel);
			}
			{
				nombreField = new JTextField();
				panel.add(nombreField);
				nombreField.setColumns(10);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			{
				JLabel dniLabel = new JLabel("DNI:       ");
				panel.add(dniLabel);
			}
			{
				this.dniField = new JTextField();
				panel.add(this.dniField);
				this.dniField.setColumns(10);
			}
		}
		
		fisicaRadioBoton = new JRadioButton("Persona Fisica");
		fisicaRadioBoton.setSelected(true);
		contentPanel.add(fisicaRadioBoton);
		
		juridicaRadioBoton = new JRadioButton("Persona Juridica");
		contentPanel.add(juridicaRadioBoton);
		
		this.buttonGroup = new ButtonGroup();
		this.buttonGroup.add(fisicaRadioBoton);
		this.buttonGroup.add(juridicaRadioBoton);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				botonCrear = new JButton("CREAR");
				botonCrear.setFont(new Font("Tahoma", Font.BOLD, 11));
				botonCrear.setActionCommand("CrearNuevoAbonado");
				buttonPane.add(botonCrear);
				getRootPane().setDefaultButton(botonCrear);
			}
			{
				botonCancelar = new JButton("Cancelar");
				botonCancelar.setActionCommand("CancelarNuevoAbonado");
				buttonPane.add(botonCancelar);
			}
		}
	}

	public void setControlador (MainControlador c) {
		this.botonCrear.addActionListener(c);
		this.botonCancelar.addActionListener(c);
	}
	
	public String getNombreNuevoAbonado () {
		return this.nombreField.getText();
	}
	public String getDniNuevoAbonado () {
		return this.dniField.getText();
	}
	public String getTipoNuevoAbonado () {
		return this.juridicaRadioBoton.isSelected() ? "Juridica" : "Fisica";
	}
}
