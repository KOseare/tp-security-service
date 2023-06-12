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
import java.awt.Component;
import java.awt.Window.Type;
import java.awt.Dialog.ModalityType;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogAltaTecnico extends JDialog{

	private final JPanel contentPanel = new JPanel();
	private JTextField nombreField;
	private JButton botonCrear;
	private JButton botonCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogAltaTecnico dialog = new DialogAltaTecnico();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogAltaTecnico() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("ALTA TECNICO");
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
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				botonCrear = new JButton("CREAR");
				botonCrear.setFont(new Font("Tahoma", Font.BOLD, 11));
				botonCrear.setActionCommand("CrearAltaTecnico");
				buttonPane.add(botonCrear);
				getRootPane().setDefaultButton(botonCrear);
			}
			{
				botonCancelar = new JButton("Cancelar");
				botonCancelar.setActionCommand("CancelarAltaTecnico");
				buttonPane.add(botonCancelar);
			}
		}
	}

	public void setControlador (MainControlador c) {
		this.botonCrear.addActionListener(c);
		this.botonCancelar.addActionListener(c);
	}
	
	public String getNombreAltaTecnico () {
		return this.nombreField.getText();
	}
}
