package negocio;

public abstract class ServicioAdicional {
    protected int cantidad;
    
    public ServicioAdicional (int cantidad) {
        this.cantidad = cantidad;
    }
    
    public abstract double obtenerPrecio();
    public abstract String toString();
}
