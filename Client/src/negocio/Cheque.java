package negocio;

import java.util.Date;


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
        
        return this.factura.detalle() + " Pago en Cheque, incremento de " + this.descuento*100 + "%";
    }

    @Override
    public Factura clone() {
        // TODO Implement this method
        return null;
    }
}
