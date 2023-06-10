package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import negocio.Domicilio;
import negocio.Persona;
import negocio.ServicioAdicional;
import negocio.SistemaSeguridad;

public class MainControlador implements ActionListener {
	private VistaSistema vista;
	private SistemaSeguridad sistema; // modelo
	
	public MainControlador (VistaSistema vista, SistemaSeguridad sistema) {
		this.vista = vista;
		this.sistema = sistema;
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
			this.vista.abrirDialogAltaTecnico();
		} else if (e.getActionCommand().equals("Nuevo Abonado")) {
			// String tipo = vista.getTipoAbonado(); TO DO
			// String nombre = vista.getNombreAbonado(); TO DO
			// String dni = vista.getDniAbonado(); TO DO
			// sistema.nuevoAbonado(String tipo, String nombre, String dni);
		} else if (e.getActionCommand().equals("Actualizar Mes")) {
			sistema.actualizarMes();
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
	}
}
