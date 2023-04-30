package negocio;

import negocio.excepciones.SaldoInsuficienteExeception;

public abstract class MedioDePagoDecorator implements IFactura {
    /**
     * @aggregation composite
     */
    protected IFactura factura;
    protected double descuento;

    public abstract double getDescuento();

    public void pagarFactura(double importe) throws SaldoInsuficienteExeception{
        if(importe > this.getImporteNeto()){
            this.factura.pagarFactura(importe);
        }else{
            throw new SaldoInsuficienteExeception(this.getImporteNeto(),importe);
        }
    }
    
    public String detalle(){
        return this.factura.detalle();
    }
}
