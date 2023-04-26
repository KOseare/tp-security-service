package negocio;


public class Tarjeta extends MedioDePagoDecorator {
    
    public Tarjeta(IFactura abonado){
        this.factura = abonado;
        this.descuento = -0.05;
    }

    @Override
    public void pagarFactura() {
        // TODO Implement this method
    }
}
