package negocio;

public abstract class MedioDePagoDecorator implements IFactura {
    /**
     * @aggregation composite
     */
    private IFactura factura;
}
