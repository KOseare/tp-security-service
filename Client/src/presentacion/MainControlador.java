package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import negocio.Domicilio;
import negocio.Persona;
import negocio.ServicioAdicional;
import negocio.SistemaSeguridad;

import javax.swing.*;

public class MainControlador implements ActionListener {
	private VistaSistema vista;
	private VistaLogin login;
	private SistemaSeguridad sistema;
	private String usuario = "superusuario";
	private String clave = "2c2023";
	
	public MainControlador (VistaSistema vista,VistaLogin login) {
		this.vista = vista;
		this.login = login;
		this.sistema = SistemaSeguridad.getSistema();
		this.login.setControlador(this);
		this.vista.setControlador(this);
		login.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TO DO: Cambiar string por constantes en interfaz (ej.: InterfazVista.PAGAR_FACTURA)
		if (e.getActionCommand().equals("Pagar Factura")) {
			// Persona p = vista.getPersonaSeleccionada(); TO DO
			// Factura f = vista.getFacturaSeleccionada(); TO DO
			sistema.pagarFactura(null, null);
		} else if (e.getActionCommand().equals("Nueva Contratacion")) {
			// Persona p = vista.getPersonaSeleccionada(); TO DO
			// String tipoContratacion = vista.getTipoContratacionSeleccionada(); TO DO
			// Domicilio d = vista.getTipoDomicilioSeleccionado(); TO DO
			// ArrayList<ServicioAdicional> s = vista.getTipoServiciosSeleccionados(); TO DO
			// sistema.agregarContrato (p, tipoContratacion, d, s);
		} else if (e.getActionCommand().equals("Baja Contratacion")) {
			// Persona p = vista.getPersonaSeleccionada(); TO DO
			// Contratacion c = vista.getContratacionSeleccionada(); TO DO
			// sistema.bajaContratacion (p, c);
		} else if (e.getActionCommand().equals("Solicitar Tecnico")) {
			// sistema.solicitarTecnico();
		} else if (e.getActionCommand().equals("Alta Tecnico")) {
			// String nombre = vista.getNombreTecnico();
			// sistema.altaTecnico(nombre);
		} else if (e.getActionCommand().equals("Nuevo Abonado")) {
			// String tipo = vista.getTipoAbonado(); TO DO
			// String nombre = vista.getNombreAbonado(); TO DO
			// String dni = vista.getDniAbonado(); TO DO
			// sistema.nuevoAbonado(String tipo, String nombre, String dni);
		} else if (e.getActionCommand().equals("Actualizar Mes")) {
			sistema.actualizarMes();
		} else if (e.getActionCommand().equals("Login")) {
			String usuario = login.getUsuario();
			String clave = login.getContrasenia();

			if (usuario == this.usuario && clave == this.clave) {
				login.setVisible(false);
				vista.setVisible(true);
			} else if (sistema.validarUsuario(usuario, clave)){
				login.setVisible(false);
				vista.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(login, "Nombre de usuario invalido", "Error", JOptionPane.ERROR_MESSAGE);
			}
			login.limpiarCampos();
		}
	}

}

