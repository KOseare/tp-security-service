package negocio;

/**
 * Clase que representa la implementacion Promocion de tipo Platino
 */
public class Platino implements Promocion {

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
    @Override
    public double PromoVivienda(double d) {
        assert d >= 0 : "El precio base debe ser mayor o igual a 0";

        return d*0.3;
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
    @Override
    public double PromoComercio(double d) {
        assert d >= 0 : "El precio base debe ser mayor o igual a 0";

        return d*0.35;
    }
    @Override
    public String toString(){
        return "Platino";
    }
    @Override
    public Object clone () throws CloneNotSupportedException {
        return super.clone();
    }
}
