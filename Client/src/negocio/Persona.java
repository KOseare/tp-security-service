package negocio;

import java.util.ArrayList;


public abstract class Persona{
    /**
     * @aggregation shared
     */
    private String nombre,dni;
    /**
     * @aggregation shared
     */
    private ArrayList<Factura> facturas = new ArrayList<Factura>();
    
    public abstract void generarFactura();
}
