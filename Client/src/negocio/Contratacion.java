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

    /**
     * @aggregation shared
     */
    protected Promocion promo;
    protected double precio;
    protected int id;
    // TO DO: Agregar agregacion de domicilio
    
    public abstract void setPrecio();
    
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
    
    public void agregarServicioAdicional (ServicioAdicional servicio) {
        serviciosAdicionales.add(servicio);
    }
}
