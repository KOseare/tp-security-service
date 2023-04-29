package negocio;

import java.util.ArrayList;


public abstract class Persona {
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
}
