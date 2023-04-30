package negocio;


public class Dorada implements Promocion, Cloneable {

    public double PromoVivienda(double d) {
        return 1500;
}

    public double PromoComercio(double d) {
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
