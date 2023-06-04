package negocio;

/**
 * Clase que representa un servicio adicional de camara para una contratacion de monitoreo.
 */
public class BotonAntiPanico extends ServicioAdicional {



    public BotonAntiPanico(int cantidad) {
        super(cantidad);
    }

    /**
     * Devuelve el precio total del servicio de boton antipanico.
     *
     * <b>pre:</b>
     * <ul>
     * <li>La cantidad de botones debe ser mayor que cero.</li>
     * </ul>
     *
     * @return el precio total del servicio de boton antipanico.
     */
    @Override
    public double obtenerPrecio() {
        assert this.cantidad > 0 : "La cantidad de botones debe ser mayor a 0";

        return this.cantidad * 2000.0;
    }

    @Override
    public String toString() {
        return this.cantidad + " boton/es antipanico";
    }
}
