package negocio;

public abstract class MedioDePagoDecorator implements IFactura,Cloneable {
    /**
     * @aggregation composite
     */
    protected IFactura factura;
    protected double descuento;

    public abstract double getDescuento();

    public abstract void pagarFactura();
}
