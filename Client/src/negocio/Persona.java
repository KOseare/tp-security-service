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

    private Contratacion contrato;
    /**
     * @aggregation shared
     */
    private Factura factura;
    
    public abstract void generarFactura();
}
