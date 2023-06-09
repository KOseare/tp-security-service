package negocio;

/**
 * Clase abstracta que representa un servicio adicional.
 */
public abstract class ServicioAdicional implements Cloneable {
    protected int cantidad;

    public ServicioAdicional() {
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }
    //

    /**
     * <b>pre:</b>
     * <ul>
     * <li>La cantidad debe ser mayor que cero.</li>
     * </ul>
     *
     * <b>post:</b>
     * <ul>
     * <li>Se crea el servicio adicional</li>
     * <li>Se inicializa la cantidad del servicio adicional</li>
     * </ul>
     *
     * @param cantidad La cantidad del servicio adicional.
     */

    public ServicioAdicional(int cantidad) {
        assert cantidad > 0 : "La cantidad debe ser mayor a cero.";

        this.cantidad = cantidad;
    }

    public abstract double obtenerPrecio();

    public abstract String toString();

    @Override
    public Object clone() throws CloneNotSupportedException {
        return (ServicioAdicional) super.clone();
    }


}
