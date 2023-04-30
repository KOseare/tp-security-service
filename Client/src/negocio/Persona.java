package negocio;

import java.util.ArrayList;
import java.util.Date;

/**
 * Clase abstracta que representa a una persona.
 */
public abstract class Persona implements Cloneable{
    /**
     * @aggregation shared
     */
    private String nombre,dni;

    /**
     * @aggregation composite
     */
    private ArrayList<Domicilio> domicilios;
    
    public abstract void generarFactura();

    public abstract ArrayList<Double> recibeDescuento(ArrayList<Contratacion> contratos);
    
    @Override
    
    public Object clone() throws CloneNotSupportedException {
        Persona personaClonada = null;
        personaClonada = (Persona) super.clone();
        personaClonada.domicilios=(ArrayList<Domicilio>) this.domicilios.clone();
        return super.clone();
    }
}
