package negocio;

import java.util.Date;

import negocio.excepciones.SaldoInsuficienteExeception;


/**
 * Interfaz encargada de modelar el comportamiento de la clase Factura y su respectivo decorador.
 */
public interface IFactura{

    double getImporte_neto();
    void pagarFactura(double importe)throws SaldoInsuficienteExeception;
    public boolean isPagado();
    public String detalle();


}
