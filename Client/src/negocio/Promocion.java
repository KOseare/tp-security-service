package negocio;



public interface Promocion extends Cloneable {
    public double PromoVivienda(double d);
    public double PromoComercio(double d);
    public Object clone() throws CloneNotSupportedException;
}