package negocio;

import java.util.ArrayList;
import java.util.Date;

import negocio.excepciones.SaldoInsuficienteExeception;
/**
 * Clase que representa al sistema general de la empresa.
 */
public class SistemaSeguridad {
    private ArrayList<Persona> clientes = new ArrayList<Persona>();
    private static SistemaSeguridad _instancia = null;
    
    private SistemaSeguridad () {}
    
    public static SistemaSeguridad getSistema(){
        if(_instancia == null)
            _instancia = new SistemaSeguridad();
        
        return _instancia;
    }

    public void agregarCliente(Persona cliente){
        clientes.add(cliente);
    }

    public void eliminarCliente(Persona cliente){
        clientes.remove(cliente);
    }

    public ArrayList<Persona> getClientes(){
        return clientes;
    }

    /**
     * Genera el reporte detallado de la factura.
     * 
     * @return Reporte de la factura
     */
    public String generarReporte(){
        String reporte="";
        for(Persona cliente : this.clientes){
            reporte += cliente.ultimaFactura().detalle();
        }
        return reporte;
    }
    
    /**
     * Genera el clon de una factura.
     * 
     * <b>pre:</b>
     * <ul>
     * <li>La factura debe estar instanciada (no es null).</li>
     * </ul>
     * 
     * <b>post:</b>
     * <ul>
     * <li>regresa un clon de la factura solicitada o regresa una excepcion.</li>
     * </ul>
     * 
     * @param factura Factura a duplicar
     * @return Factura duplicada
     */
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
