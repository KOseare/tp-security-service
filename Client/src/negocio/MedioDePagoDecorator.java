package negocio;

import negocio.excepciones.SaldoInsuficienteExeception;

/**
 * Clase abstracta para poder implementar metodos del patron Decorator que 
 * modelara de manera dinamica la factura en funcion de su forma de pago. 
 */
public abstract class MedioDePagoDecorator implements IFactura {
    /**
     * @aggregation composite
     */
    protected IFactura factura;
    protected double descuento;

    public abstract double getDescuento();


    /**
     * Agrega a la contratacion un nuevo servicio adicional.
     *
     * <b>pre:</b>
     * <ul>
     * <li>El importe debe ser mayor a 0.</li>
     * </ul>
     *
     * <b>post:</b>
     * <ul>
     * <li>se paga el servicio o en caso contrario lanza una excepcion</li>
     * </ul>
     *
     * @param importe
     * @throws SaldoInsuficienteExeception
     */
    public void pagarFactura(double importe) throws SaldoInsuficienteExeception{
        if(importe > this.getImporte_neto()){
            this.factura.pagarFactura(importe);
        }else{
            throw new SaldoInsuficienteExeception(this.getImporte_neto(),importe);
        }
    }
    
    public String detalle(){
        return this.factura.detalle();
    }
}
