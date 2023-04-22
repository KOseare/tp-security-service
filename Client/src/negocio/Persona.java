package negocio;


public abstract class Persona {
    /**
     * @aggregation shared
     */
    private String nombre,dni;
    /**
     * @aggregation shared
     */
    private Contrataciones contrato;
    /**
     * @aggregation shared
     */
    private Factura factura;
    
}
