package negocio;


public class Cheque extends MedioDePagoDecorator {
    
    public Cheque(IFactura abonado){
        this.factura = abonado;
        this.descuento = -0.1;
    }

    @Override
    public void pagarFactura() {
        // TODO Implement this method
    }
}
