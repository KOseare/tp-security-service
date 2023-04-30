package negocio;

import java.util.Date;

public class Efectivo extends MedioDePagoDecorator {


    public Efectivo(IFactura persona) {
        super();
        this.factura = persona;
}

    @Override
    public double getDescuento() {
        return this.factura.getDescuento() * 0.2;
    }

    @Override
    public double getImporteNeto() {
        return this.factura.getImporteNeto() * 0.2;
    }



    /**
     * @param contrato
     */

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
        
        return this.factura.detalle() + " Pago en Efectivo, descuento de " + this.descuento*100 + "%";
    }
}
