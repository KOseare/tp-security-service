package negocio;

import java.util.Date;

/**
 * Clase que representa un medio de pago de tipo Cheque que se aplica sobre la factura.
 */
public class Cheque extends MedioDePagoDecorator {
    
    /**
     * <b>pre:</b>
     * <ul>
     * <li>La factura no debe ser null.</li>
     * </ul>
     * 
     * @param factura Factura a la que se le aplicara el medio de pago cheque.
     */
    public Cheque(IFactura factura){
        super();
        assert factura != null : "La persona es null";

        this.factura = factura;
        this.descuento = -0.1;
    }

    @Override
    public double getDescuento() {
        return this.descuento;
    }

    @Override
    public double getImporte_neto() {
        return this.factura.getImporte_neto() * (1-this.descuento);
    }



    @Override
    public boolean isPagado() {

        return this.factura.isPagado();
    }

    @Override
    public String detalle() {
        
        return this.factura.detalle() + " Pago en Cheque, incremento de " + -this.descuento*100 + "%, total a pagar: " + this.getImporte_neto();
    }

    @Override
    public void setRecargo(Recargo recargo) {
        this.factura.setRecargo(recargo);
    }
}
