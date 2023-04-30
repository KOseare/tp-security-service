package negocio;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase que representa la contratacion de un sistema de monitoreo,
 * que puede incluir servicios adicionales.
 */
public abstract class Contratacion {
    private static int lastId;

    /**
     * @aggregation composite
     */
    private ArrayList<ServicioAdicional> serviciosAdicionales = new ArrayList<ServicioAdicional>();

    /**
     * @aggregation shared
     */
    protected Promocion promo=null;
    protected double precioDelServicio,precioPromo=0;
    protected int id;
    private Domicilio domicilio;
    
    /**
     * <b>pre:</b>
     * <ul>
     * <li>El domicilio deb estar instanciado (no es null).</li>
     * <li>El domicilio no debe estar incluido en otra contratacion.</li>
     * </ul>
     * 
     * <b>post:</b>
     * <ul>
     * <li>Se crea una nueva contratacion asociada a un domicilio.</li>
     * <li>La contratacion obtiene un id unico generado automaticamente.</li>
     * </ul>
     * 
     * @param domicilio Docimilio asociado a la contratacion de monitoreo.
     */
    public Contratacion (Domicilio domicilio) {
        this.id = ++Contratacion.lastId;
        this.domicilio = domicilio;
    }
    
    
    public abstract double calculaPromo (Promocion promocion);

    public double getPrecio() {
        return this.precioDelServicio;
    }


    /**
     * @return el iterador de los servicios adicionales agregados a la contratacion.
     */
    public Iterator<ServicioAdicional> getServiciosAdicionalesIterator() {
        return serviciosAdicionales.iterator();
    }
    
    /**
     * @return la suma total de los precios de los servicios adicionales.
     */
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

    public ArrayList<ServicioAdicional> getServiciosAdicionales() {
        return serviciosAdicionales;
    }

    public Promocion getPromo() {
        return promo;
    }

    public double getPrecioPromo() {
        return precioPromo;
    }


    public Domicilio getDomicilio() {
        return domicilio;
    }

    /**
     * Agrega a la contratacion un nuevo servicio adicional.
     * 
     * <b>pre:</b>
     * <ul>
     * <li>El servicio debe estar instanciado (no es null).</li>
     * </ul>
     * 
     * <b>post:</b>
     * <ul>
     * <li>Se agrega un servicio mas a la lista de servicios de la contratacion.</li>
     * </ul>
     * 
     * @param servicio Servicio adicional que se le quiera agregar a la contratacion
     */
    public void agregarServicioAdicional (ServicioAdicional servicio) {
        serviciosAdicionales.add(servicio);
    }

    public void setPromocion(Promocion promo) {
        this.promo = promo;
        this.precioPromo = this.calculaPromo(this.promo);
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

    public String toSting() {
        String detalle = "[ id: " + id + ", precioDelServicio: " + this.precioDelServicio + ", Servicios adicionales: " +
               this.serviciosAdicionales.toString();
        if(promo!=null){
            detalle +=  ", Promocion: " + promo.toString() + ", Descuento de la promocion: " + calculaPromo(this.promo); 
}
            detalle += ", domicilio: " + this.domicilio.toString()+"]\n ";
        
        return detalle;
}
}
