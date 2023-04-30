package negocio;

import java.util.Date;


public interface IFactura  implements Cloneable{

    public Date getFecha();
    public boolean isPagado();
    public String detalle();

    double getDescuento();
    double getImporteNeto();
    void pagarFactura();
}
