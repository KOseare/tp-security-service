package negocio;

public class BotonAntiPanico extends ServicioAdicional {
    public BotonAntiPanico(int cantidad) {
        super(cantidad);
    }

    @Override
    public double obtenerPrecio() {
        return this.cantidad * 2000.0;
    }
    
    @Override
    public String toString() {
        return this.cantidad + " boton/es antipanico";
    }
}
