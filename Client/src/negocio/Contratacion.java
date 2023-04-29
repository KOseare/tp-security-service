package negocio;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase que representa la contratacion de un sistema de monitoreo,
 * que puede incluir servicios adicionales
 */
public abstract class Contratacion {
    /**
     * @aggregation composite
     */
    private ArrayList<ServicioAdicional> serviciosAdicionales = new ArrayList<ServicioAdicional>();
    private static int lastId = 0;
    protected Promocion promo;
    protected double precio;
    protected int id;
    private Domicilio domicilio;
    
    public Contratacion (Domicilio domicilio) {
        this.id = ++Contratacion.lastId;
        this.domicilio = domicilio;
    }
    
    public abstract void setPrecio();

    public double getPrecio() {
        return precio;
    }

    public abstract double calculaPromo (Promocion p);


    public Iterator<ServicioAdicional> getServiciosAdicionalesIterator() {
        return serviciosAdicionales.iterator();
    }
    
    public double obtenerTotalDeServiciosAdicionales () {
        double total = 0;
        for (ServicioAdicional servicio : this.serviciosAdicionales) {
            total += servicio.obtenerPrecio();
        }
        return total;
    }

    public int getId() {
        return id;
    }


    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void agregarServicioAdicional (ServicioAdicional servicio) {
        serviciosAdicionales.add(servicio);
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Contratacion)) {
            return false;
        }
        final Contratacion other = (Contratacion) object;
        if (id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 37;
        int result = 1;
        result = PRIME * result + id;
        return result;
    }
}
