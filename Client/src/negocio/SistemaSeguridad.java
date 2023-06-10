package negocio;


import java.util.ArrayList;
import java.util.Date;

import negocio.excepciones.SaldoInsuficienteExeception;

import presentacion.MainControlador;

/**
 * Clase que representa al sistema general de la empresa.
 */
public class SistemaSeguridad {
    private ArrayList<Persona> clientes = new ArrayList<Persona>();
    private static SistemaSeguridad _instancia = null;
    private ServicioTecnico serviciotecnico;

    private SistemaSeguridad() {
    }

    public void setClientes(ArrayList<Persona> clientes) {
        this.clientes = clientes;
    }

    public static SistemaSeguridad getSistema() {
        if (_instancia == null) {
        	_instancia = new SistemaSeguridad();
        	_instancia.serviciotecnico = new ServicioTecnico();
        }

        return _instancia;
    }

    public void agregarCliente(Persona cliente) {
        clientes.add(cliente);
    }

    public void eliminarCliente(Persona cliente) {
        clientes.remove(cliente);
    }

    public ArrayList<Persona> getClientes() {
        return clientes;
    }

    public void setServiciotecnico(ServicioTecnico serviciotecnico) {
        this.serviciotecnico = serviciotecnico;
    }

    public ServicioTecnico getServiciotecnico() {
        return serviciotecnico;
    }

    /**
     * Genera el reporte detallado de la factura.
     *
     * @return Reporte de la factura
     */
    public String generarReporte() {
        String reporte = "";
        for (Persona cliente : this.clientes) {
            reporte += cliente.ultimaFactura().detalle();
        }
        return reporte;
    }

    /**
     * Genera el clon de una factura.
     *
     * <b>pre:</b>
     * <ul>
     * <li>La factura debe estar instanciada (no es null).</li>
     * </ul>
     *
     * <b>post:</b>
     * <ul>
     * <li>regresa un clon de la factura solicitada o regresa una excepcion.</li>
     * </ul>
     *
     * @param factura Factura a duplicar
     * @return Factura duplicada
     */
    public IFactura solicitarDuplicado(Factura factura) throws CloneNotSupportedException {
        Factura clon;
        try {
            clon = (Factura) factura.clone();
            return clon;
        } catch (CloneNotSupportedException e) {
            throw e;
        }
    }
    
    public void pagarFactura (Persona persona, Factura factura) {
    	if (persona.getFacturas().contains(factura)) {
    		try {
					factura.pagarFactura(1); // TO DO: Agregar interfaz para el saldo
				} catch (SaldoInsuficienteExeception e) {
					System.out.println("SALDO INSUFICIENTE"); // TO DO: Observer, zona de notificaciones
				}
    	}
    }
    
    public void agregarContrato (Persona persona, String tipo, Domicilio domicilio, ArrayList<ServicioAdicional> servicios) {
    	Contratacion contrato;
    	if (tipo.equals("Comercio")) {
    		contrato = new MonitoreoComercio();
    	} else {
    		contrato = new MonitoreoVivienda();
    	}
    	contrato.setServiciosAdicionales(servicios); // TO DO: Revisar si seria necesario instancia aca los servicios
    	persona.agregarContrato(contrato);
    }
    
    public void bajaContratacion (Persona persona, Contratacion c) {
    	persona.getContrataciones().remove(c);
    }
    
    public void solicitarTecnico (MainControlador observer){

            new Thread(new ServicioTecnicoRunnable(this.serviciotecnico,observer)).start();
    }
    
    public void altaTecnico (String nombre) {
    	Tecnico tecnico = new Tecnico(nombre);
    	this.serviciotecnico.agregarTecnico(tecnico);
    }
    
    public void nuevoAbonado (String tipo, String nombre, String dni) {
    	Persona p;
    	if (tipo.equals("Juridica")) {
    		p = new PersonaJuridica(nombre, dni);
    	} else {
    		p = new PersonaFisica(nombre, dni);
    	}
    	this.clientes.add(p);
    }
    
    public void actualizarMes () {
    	for (Persona persona : this.clientes) {
        persona.facturacionMensual();
    }
    }
}
