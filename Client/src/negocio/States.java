package negocio;

import negocio.excepciones.SaldoInsuficienteExeception;

public interface States {
    
    public void pagarFactura(Factura factura,double importe) throws SaldoInsuficienteExeception;
    public void agregarContrato(Contratacion contrato);
    public void darBajaServicio(Contratacion contrato);
    public void actualizarEstado();
}
