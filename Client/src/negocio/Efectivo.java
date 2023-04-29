package negocio;

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
}
