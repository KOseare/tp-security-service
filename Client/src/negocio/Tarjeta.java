package negocio;

import java.util.Date;


public class Tarjeta extends MedioDePagoDecorator {
    
    public Tarjeta(IFactura abonado){
        this.factura = abonado;
        this.descuento = -0.05;
    }

    @Override
    public void pagarFactura() {
        // TODO Implement this method
    }

    @Override
    public double getMonto() {
        // TODO Implement this method
        return 0.0;
    }

    @Override
    public Date getFecha() {
        // TODO Implement this method
        return null;
    }

    @Override
    public boolean isPagado() {
        // TODO Implement this method
        return false;
    }
}
