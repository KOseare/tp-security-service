package negocio;


public class Tarjeta extends MedioDePagoDecorator {
    
    public Tarjeta(IFactura abonado){
        this.factura = abonado;
    }

    @Override
    public double getDescuento() {
        return this.factura.getDescuento() * 1.05;
    }

    @Override
    public double getImporteNeto() {
        return this.factura.getImporteNeto() * 1.05;
    }

    @Override
    public void pagarFactura() {
        // TODO Implement this method
    }
}
