package negocio;

/**
 * Clase que representa la contratacion de monitoreo para una vivienda.
 * Hereda de la clase abstracta Contratacion.
 */
public class MonitoreoVivienda extends Contratacion {
    
    public MonitoreoVivienda(Domicilio domicilio){
        super(domicilio);
        this.precioDelServicio = 8500.0;
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

        return promocion.PromoVivienda(this.precioDelServicio);
    }
    @Override
    public String toString(){
        return "Tipo: Monitoreo de Vivienda" + super.toString();
    }
    
}
