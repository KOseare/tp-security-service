package negocio;

public class MonitoreoComercio extends Contratacion {
    
    @Override
    public double obtenerPrecio() {
        double precio = 8500.0;
        return precio + this.obtenerTotalDeServiciosAdicionales();
    }
}
