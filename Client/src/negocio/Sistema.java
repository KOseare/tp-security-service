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
        return "";
    }
    
    public IFactura solicitarDuplicado(IFactura factura)throws CloneNotSupportedException{
        Factura clon;
        try{
            clon = (Factura) factura.clone();
            return clon;
        }catch(CloneNotSupportedException e){
            throw e;
        }
    }
    
    
    
}
