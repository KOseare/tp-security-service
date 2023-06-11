package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Objects;

import negocio.Domicilio;
import negocio.Persona;
import negocio.PersonaFisica;
import negocio.PersonaJuridica;
import negocio.ServicioAdicional;
import negocio.SistemaSeguridad;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainControlador implements ActionListener, ListSelectionListener {
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
		this.vista.arranca();
		login.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TO DO: Cambiar string por constantes en interfaz (ej.: InterfazVista.PAGAR_FACTURA)
		if (e.getActionCommand().equals("Pagar Factura")) {
			// Persona p = vista.getPersonaSeleccionada(); TO DO
			// Factura f = vista.getFacturaSeleccionada(); TO DO
			//sistema.pagarFactura(null, null);
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
			 sistema.solicitarTecnico(this);

		} else if (e.getActionCommand().equals("Alta Tecnico")) {
			this.vista.abrirDialogAltaTecnico();
		} else if (e.getActionCommand().equals("Nuevo Abonado")) {
			vista.abrirDialogNuevoAbonado();
		} else if (e.getActionCommand().equals("Actualizar Mes")) {
			sistema.actualizarMes();
			Persona p = vista.getAbonadoSeleccionado();
			if (p != null) {
				vista.updateListaFacturas(p.getFacturas());				
			}
		}else if (e.getActionCommand().equals("Seleccion Abonado")){
			Persona p = vista.getAbonadoSeleccionado();
			if (p != null) {
				vista.updateListaFacturas(p.getFacturas());				
			}
		} else if (e.getActionCommand().equals("Login")) {
			String usuario = login.getUsuario();
			String clave = login.getContrasenia();
			if (Objects.equals(usuario, this.usuario) && Objects.equals(clave, this.clave)) {
				login.setVisible(false);
				vista.updateListaAbonados(sistema.getClientes());
				vista.setVisible(true);
			} else if (sistema.validarUsuario(usuario, clave)){
				login.setVisible(false);
				vista.setAbonadoActivo(sistema.getPersonaUsuario(usuario,clave));
				vista.updateListaFacturas(sistema.getPersonaUsuario(usuario,clave).getFacturas());
				vista.vistaAbonado();
				vista.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(login, "Nombre de usuario invalido", "Error", JOptionPane.ERROR_MESSAGE);
			}
			login.limpiarCampos();
		}
		
		// Actions Alta Tecnico ---------------------------
		else if (e.getActionCommand().equals("CrearAltaTecnico")) {
			String nombre = vista.getNombreAltaTecnico();
			this.sistema.altaTecnico(nombre);
			this.vista.cerrarDialogAltaTecnico();
		} else if (e.getActionCommand().equals("CancelarAltaTecnico")) {
			this.vista.cerrarDialogAltaTecnico();
		}
		// ------------------------------------------------
		
		// Actions Nuevo Abonado -----------------------------
		else if (e.getActionCommand().equals("CrearNuevoAbonado")) {
			String tipo = vista.getTipoNuevoAbonado();
			String nombre = vista.getNombreNuevoAbonado();
			String dni = vista.getDniNuevoAbonado();
			sistema.nuevoAbonado(tipo, nombre, dni);
			vista.updateListaAbonados(sistema.getClientes());
			this.vista.cerrarDialogNuevoAbonado();
		} else if (e.getActionCommand().equals("CancelarNuevoAbonado")) {
			this.vista.cerrarDialogNuevoAbonado();
		}
		// ------------------------------------------------
	}

	public void comunicarConsolaTecnico(String resp){
			vista.dibujarRespuesta(resp);
	}


	@Override
	public void valueChanged(ListSelectionEvent e) {
		vista.abrirDialogFactura();
	}

	public void abrirDialogFactura() {
		vista.abrirDialogFactura();
	}


}

