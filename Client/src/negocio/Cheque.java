package negocio;


public class Cheque extends MedioDePagoDecorator {
    
    public Cheque(IFactura abonado){
        this.factura = abonado;
    }

    @Override
    public double getDescuento() {
        return this.factura.getDescuento() * 1.1;
    }

    @Override
    public double getImporteNeto() {
        return this.factura.getImporteNeto() * 1.1;
    }

    @Override
    public void pagarFactura() {
        // TODO Implement this method
    }
}
