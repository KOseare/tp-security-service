package negocio;

/**
 * Clase que representa la implementacion Promocion de tipo Dorada
 */
public class Dorada implements Promocion, Cloneable {

    /**
     * Retorna el descuento de la promocion para una contratación de tipo Vivienda.
     * 
     * <b>pre:</b>
     * <ul>
     * <li>El precio base (d) es mayor a 0.</li>
     * </ul>
     * 
     * @param d El precio base de la contratación
     * @return El descuento promocional
     */
    public double PromoVivienda(double d) {
        assert d >= 0 : "El precio base debe ser mayor o igual a 0";
        return 1500;
}

    /**
     * Retorna el descuento de la promocion para una contratación de tipo Comercio.
     * 
     * <b>pre:</b>
     * <ul>
     * <li>El precio base (d) es mayor a 0.</li>
     * </ul>
     * 
     * @param d El precio base de la contratación
     * @return El descuento promocional
     */
    public double PromoComercio(double d) {
        assert d >= 0 : "El precio base debe ser mayor o igual a 0";
        return 2500;
    }
    @Override
    public Object clone () throws CloneNotSupportedException {
        return super.clone();
    }
    
    @Override
    public String toString(){
        return "Dorada ";
    }
    
}
