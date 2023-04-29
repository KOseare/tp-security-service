package negocio;

public interface IFactura {
    double getDescuento();
    double getImporteNeto();
    void pagarFactura();
}
