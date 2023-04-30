package negocio;

import java.util.Date;

import negocio.excepciones.SaldoInsuficienteExeception;


public interface IFactura{

    double getImporteNeto();
    void pagarFactura(double importe)throws SaldoInsuficienteExeception;
    public boolean isPagado();
    public String detalle();


}
