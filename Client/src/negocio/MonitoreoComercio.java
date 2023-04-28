package negocio;

public class MonitoreoComercio extends Contratacion {
    
    public MonitoreoComercio(Domicilio domicilio){
        super(domicilio);
        this.precioDelServicio = 10000.0;
    }
    

    
    @Override
    public double calculaPromo(Promocion promocion) {
        return promocion.PromoComercio(this.precioDelServicio);
    }
}
