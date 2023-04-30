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
}
