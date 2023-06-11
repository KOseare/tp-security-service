package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.TreeSet;

import negocio.excepciones.SaldoInsuficienteExeception;

/**
 * Clase abstracta que representa a una persona.
 */
public abstract class Persona implements Cloneable {
    /**
     * @aggregation shared
     */
    private String nombre, dni;

    /**
     * @aggregation composite
     */
    private ArrayList<Domicilio> domicilios = new ArrayList<Domicilio>();

    /**
     * @aggregation composite
     */
    private TreeSet<Factura> facturas = new TreeSet<Factura>();
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setDomicilios(ArrayList<Domicilio> domicilios) {
        this.domicilios = domicilios;
    }

    public void setFacturas(TreeSet<Factura> facturas) {
        this.facturas = facturas;
    }
    public Persona() {
    }
    //

    public Persona(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        Factura facturaInicial = new Factura(new Date(), this);
        facturas.add(facturaInicial);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public TreeSet<Factura> getFacturas() {
        return facturas;
    }
    
    public Factura ultimaFactura() {
        return this.facturas.last();
    }

    public ArrayList<Domicilio> getDomicilios() {
        return domicilios;
    }

    public void agregarDomicilio(Domicilio domicilio) {
        this.domicilios.add(domicilio);
    }

    public ArrayList<Contratacion> getContrataciones() {
        return this.ultimaFactura().getContratos();
    }

    public abstract ArrayList<Double> recibeDescuento(ArrayList<Contratacion> contratos);

    @Override
    public Object clone() throws CloneNotSupportedException {
        Persona personaClonada = null;
        personaClonada = (Persona) super.clone();
        
        personaClonada.domicilios = new ArrayList<Domicilio>();
        for(Domicilio domicilio : this.domicilios){
            personaClonada.domicilios.add((Domicilio) domicilio.clone());
        }
        
        return personaClonada;

    }

    @SuppressWarnings("deprecation")
		public void facturacionMensual () {
    	Factura nuevaFactura;
			try {
				nuevaFactura = (Factura) this.ultimaFactura().clone();
				
				int mes = nuevaFactura.getFecha().getMonth();
	    	mes = mes == 11 ? 0 : mes + 1;
	    	
	    	nuevaFactura.getFecha().setMonth(mes);
	    	this.facturas.add(nuevaFactura);
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
    }
    
    public void agregarContrato(Contratacion contrato){
        this.ultimaFactura().agregarContrato(contrato);
    }
    
    public void darBajaServicio(Contratacion contrato) {
        this.ultimaFactura().darBajaServicio(contrato);
    }
    
    public void pagarFactura(Factura f, double importe) throws SaldoInsuficienteExeception {
        f.pagarFactura(importe);
    }
    

    public String toString() {
        return " Nombre:" + this.nombre + " DNI " + this.dni;
    }
}
