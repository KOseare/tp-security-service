package negocio;

import java.util.ArrayList;
import java.util.Date;

public class SistemaSeguridad {
    private ArrayList<Persona> clientes = new ArrayList<Persona>();
    private ArrayList<Factura> facturas = new ArrayList<Factura>();
    private static SistemaSeguridad _instancia = null;
    
    public static SistemaSeguridad getSistema(){
        if(_instancia == null)
            _instancia = new SistemaSeguridad();
        
        return _instancia;
    }

    public void agregarCliente(Persona cliente){
        clientes.add(cliente);
    }

    public void agregarFactura(Factura factura){
        facturas.add(factura);
    }

    public void eliminarCliente(Persona cliente){
        clientes.remove(cliente);
    }

    public void eliminarFactura(Factura factura){
        facturas.remove(factura);
    }

    public ArrayList<Persona> getClientes(){
        return clientes;
    }

    public ArrayList<Factura> getFacturas(){
        return facturas;
    }

    public void generarFactura(Date fecha, Persona cliente, ArrayList<Contratacion> contratos){
        Factura nueva_factura = new Factura(fecha,cliente,contratos);
        agregarFactura(nueva_factura);
    }
    public void generarFactura(Date fecha, Persona cliente, Contratacion contrato){
        Factura nueva_factura = new Factura(fecha,cliente,contrato);
        agregarFactura(nueva_factura);
    }
    
    public String generarReporte(){
        String reporte="";
        for(IFactura factura : this.facturas){
            reporte += factura.detalle();
        }
        return reporte;
    }
    public IFactura solicitarDuplicado(Factura factura)throws CloneNotSupportedException{
        Factura clon;
        try{
            clon = (Factura)factura.clone();
            return clon;
        }catch(CloneNotSupportedException e){
            throw e;
        }
    }
}
