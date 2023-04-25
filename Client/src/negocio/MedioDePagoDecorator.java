package negocio;

public abstract class MedioDePagoDecorator implements IFactura {
    /**
     * @aggregation composite
     */
    protected IFactura factura;
    protected double descuento;
    
    public abstract void pagarFactura();
}
