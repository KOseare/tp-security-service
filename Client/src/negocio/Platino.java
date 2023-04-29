package negocio;

public class Platino implements Promocion {
    @Override
    public double PromoVivienda(double d) {
        return d*0.3;
}

    @Override
    public double PromoComercio(double d) {
        return d*0.35;
    }
    @Override
    public String toString(){
        return "Platino";
    }
}
