package negocio;

public class Efectivo extends MedioDePagoDecorator {


    public Efectivo(IFactura persona) {
        super();
        this.factura = persona;
        this.descuento = .2;
    }

    /**
     * @param contrato
     */

    @Override
    public void pagarFactura() {
        // TODO Implement this method
    }
}
