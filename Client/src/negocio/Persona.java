package negocio;

import java.util.ArrayList;
import java.util.Date;

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
    private ArrayList<Factura> facturas = new ArrayList<Factura>();
    private ArrayList<Contratacion> contrataciones = new ArrayList<Contratacion>();

    public Persona(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
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

    public ArrayList<Factura> getFacturas() {
        return facturas;
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

    public String toString() {
        return " Nombre:" + this.nombre + " DNI " + this.dni;
    }
}
