package negocio;

import java.util.ArrayList;

/**
 * Clase que representa la contratacion de monitoreo para una vivienda.
 * Hereda de la clase abstracta Contratacion.
 */
public class MonitoreoVivienda extends Contratacion {
    
    public MonitoreoVivienda(){
    }

    public MonitoreoVivienda(Domicilio domicilio){
        super(domicilio);
        this.precioDelServicio = 8500.0;
    /**
     * Establece el precio de la contratacion.
     * 
     * <b>post:</b>
     * <ul>
     * <li>Se establece un precio incial de la contratacion.</li>
     * <li>Se suman los precios de los servicios adicionales.</li>
     * <li>Se resta el descuento de la promocion (si corresponde).</li>
     * </ul>
     */    
    }


    /**
     * Calcula el descuento de la promocion aplicable a la contratacion.
     * 
     * <b>pre:</b>
     * <ul>
     * <li>La promocion no es null.</li>
     * </ul>
     * 
     * <b>post:</b>
     * <ul>
     * <li>Se devuelve el descuento correspondiente a la promocion.</li>
     * </ul>
     * 
     * @param promocion La promoci�n aplicable a la contratacion.
     * @return El descuento correspondiente a la promocion.
     */
    @Override
    public double calculaPromo(Promocion promocion) {
        assert (promocion != null) : "La promocion es null";
        return promocion.PromoVivienda(this.precioDelServicio);
    }
    @Override
    public String toString(){
        return "\tTipo: Monitoreo de Vivienda" + super.toString();
    }
    
}
