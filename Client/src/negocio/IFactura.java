package negocio;

import java.util.Date;


public interface IFactura {
    double getDescuento();
    double getImporteNeto();
    void pagarFactura();
    public Date getFecha();
    public boolean isPagado();
    public String detalle();
    

}
