package negocio;


public class MonitoreoVivienda extends Contratacion {
    
    public MonitoreoVivienda(Domicilio domicilio){
        super(domicilio);
        this.precioDelServicio = 8500.0;
    }

    @Override
    public double calculaPromo(Promocion promocion) {
        return promocion.PromoVivienda(this.precioDelServicio);
    }
    @Override
    public String toString(){
        return "Tipo: Monitoreo de Vivienda" + super.toString();
    }
    
}
