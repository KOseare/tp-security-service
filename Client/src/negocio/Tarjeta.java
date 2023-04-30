package negocio;

import java.util.Date;

/**
 * Clase que representa un medio de pago de tipo Tarjeta que se aplica sobre la factura.
 */
public class Tarjeta extends MedioDePagoDecorator {
    
    /**
     * <b>pre:</b>
     * <ul>
     * <li>La factura no debe ser null.</li>
     * </ul>
     * 
     * @param factura Factura a la que se le aplicara el medio de pago tarjeta.
     */
    public Tarjeta(IFactura factura){
        super();
        assert factura != null : "La persona es null";

        this.factura = factura;
        this.descuento = -0.05;
    }

    @Override
    public double getDescuento() {
        return this.descuento;
    }

    @Override
    public double getImporteNeto() {
        return this.factura.getImporteNeto() * (1-this.descuento);
    }


    @Override
    public boolean isPagado(){
        return this.factura.isPagado();
    }

    @Override
    public String detalle() {
        return this.factura.detalle() + " Pago en Tarjeta, incremento de " + -this.descuento*100 + "%, total a pagar: " + this.getImporteNeto();
    }

}
