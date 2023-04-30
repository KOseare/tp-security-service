package negocio;

import java.util.ArrayList;

public class Sistema {
    private static Sistema _instancia = null;
    ArrayList<IFactura> facturas = new ArrayList<IFactura>();
    ArrayList<Persona> abonados = new ArrayList<Persona>();
    
    public static Sistema getSistema(){
        if(_instancia == null)
            _instancia = new Sistema();
        
        return _instancia;
    }
    
    public String generarReporte(){
        String reporte="";
        for(IFactura factura : this.facturas){
            reporte += factura.detalle();
        }
        return reporte;
    }
    //precondicion factura validada
    public Factura solicitarDuplicado(Factura factura)throws CloneNotSupportedException{
        Factura clon;
        try{
            clon = (Factura)factura.clone();
            return clon;
        }catch(CloneNotSupportedException e){
            throw e;
        }
    }
    
    public void agregarAbonado(Persona p){
        this.abonados.add(p);
    }
    public void agregarFactura(IFactura f){
        this.facturas.add(f);
    }
    
    
}
