package negocio;

import java.util.Date;


public interface IFactura{
    public double getMonto();
    public Date getFecha();
    public boolean isPagado();

}
