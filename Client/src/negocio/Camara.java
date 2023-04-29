package negocio;

/**
 * Clase que representa un servicio adicional de camara para una contratacion de monitoreo.
 */
public class Camara extends ServicioAdicional {

    public Camara(int cantidad) {
        super(cantidad);
    }

    /**
     * Devuelve el precio total del servicio de camaras
     * 
     * <b>pre:</b>
     * <ul>
     * <li>La cantidad de camaras debe ser mayor que cero.</li>
     * </ul>
     * 
     * @return el precio total del servicio de camaras
     */
    @Override
    public double obtenerPrecio() {
        assert this.cantidad > 0 : "La cantidad de camaras debe ser mayor a 0";
        
        return this.cantidad * 3000.0;
    }

    @Override
    public String toString() {
        return this.cantidad + " camara/s";
    }
}
