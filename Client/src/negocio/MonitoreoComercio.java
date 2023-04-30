package negocio;

/**
 * Clase que representa la contratacion de monitoreo para un comercio.
 * Hereda de la clase abstracta Contratacion.
 */
public class MonitoreoComercio extends Contratacion {
    
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
     * @param promocion La promocion aplicable a la contratacion.
     * @return El descuento correspondiente a la promocion.
     */
    @Override
    public double calculaPromo(Promocion promocion) {
        assert promocion != null : "La promocion es null";

        return promocion.PromoComercio(this.precioDelServicio);
    }
    
    @Override
    public String toSting(){
        return "Tipo: Monitoreo de Comercio" + super.toSting();
}
}
