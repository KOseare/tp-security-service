package negocio;

/**
 * Clase que representa la contratacion de monitoreo para un comercio.
 * Hereda de la clase abstracta Contratacion.
 */
public class MonitoreoComercio extends Contratacion {
    
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
    public MonitoreoComercio(Domicilio domicilio){
        super(domicilio);
        this.precioDelServicio = 10000.0;
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
     * @param promocion La promoción aplicable a la contratacion.
     * @return El descuento correspondiente a la promocion.
     */
    @Override
    public double calculaPromo(Promocion promocion) {
        return promocion.PromoComercio(this.precioDelServicio);
    }
    
    @Override
    public String toSting(){
        return "\tTipo: Monitoreo de Comercio" + super.toSting();
}
}
