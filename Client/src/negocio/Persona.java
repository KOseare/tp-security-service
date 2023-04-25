package negocio;


public abstract class Persona {
    /**
     * @aggregation shared
     */
    private String nombre,dni;
    /**
     * @aggregation shared
     */
    private Contratacion contrato;
    /**
     * @aggregation shared
     */
    private IFactura factura;
    
}
