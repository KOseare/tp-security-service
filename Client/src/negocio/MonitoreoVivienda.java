package negocio;


public class MonitoreoVivienda extends Contratacion {

    @Override
    public void setPrecio() {
        this.precio = 8500.0;
        this.precio += this.obtenerTotalDeServiciosAdicionales();
        this.precio-=calculaPromo(this.promo);
    }

    @Override
    public double calculaPromo(Promocion promocion) {
        return promocion.PromoVivienda(this.precio);
    }
}
