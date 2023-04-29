package negocio;

import java.util.Date;


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

    @Override
    public String detalle() {
        return this.factura.detalle() + " Pago en Tarjeta, incremento de " + this.descuento*100 + "%";
    }

    @Override
    public Factura clone() {
        // TODO Implement this method
        return null;
    }
}
