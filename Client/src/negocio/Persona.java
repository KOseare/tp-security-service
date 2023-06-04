package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.TreeSet;

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
    private ArrayList<Contratacion> contrataciones = new ArrayList<Contratacion>();

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

    public void setContrataciones(ArrayList<Contratacion> contrataciones) {
        this.contrataciones = contrataciones;
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
        return contrataciones;
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

    public void facturacionMensual () {
        // TO DO: Implementar
        // Debe generar una copia de la ultima factura, pasarla al siguiente mes
        // y agregarla como ultima (factura actual)
    }
    
    public void agregarContrato(Contratacion contrato){
        this.ultimaFactura().agregarContrato(contrato);
    }

    public String toString() {
        return " Nombre:" + this.nombre + " DNI " + this.dni;
    }
}
