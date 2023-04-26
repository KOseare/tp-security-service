package negocio;


public class Camara extends ServicioAdicional {

    public Camara(int cantidad) {
        super(cantidad);
    }

    @Override
    public double obtenerPrecio() {
        return this.cantidad * 3000.0;
    }

    @Override
    public String toString() {
        return this.cantidad + " camara/s";
    }
}
