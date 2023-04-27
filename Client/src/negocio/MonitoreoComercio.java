package negocio;

public class MonitoreoComercio extends Contratacion {
    
    public MonitoreoComercio(Domicilio domicilio){
        super(domicilio);
    }
    
    @Override
    public void setPrecio() {
        this.precio = 8500.0;
        this.precio += this.obtenerTotalDeServiciosAdicionales();
        this.precio-=calculaPromo(this.promo);
    }

    @Override
    public double calculaPromo(Promocion promocion) {
        return promocion.PromoComercio(this.precio);
    }
}
