package negocio;


public class Dorada implements Promocion {

    @Override
    public double PromoVivienda(double d) {
        return 1500;
    }

    @Override
    public double PromoComercio(double d) {
        return 2500;
    }
}
