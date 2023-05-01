package negocio;

import java.util.ArrayList;
import java.util.Date;

import negocio.excepciones.SaldoInsuficienteExeception;
/**
 * Clase que representa al sistema general de la empresa.
 */
public class SistemaSeguridad {
    private ArrayList<Persona> clientes = new ArrayList<Persona>();
    private ArrayList<Factura> facturas = new ArrayList<Factura>();
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

    /**
     * Genera adecuadamente una factura.
     * 
     * <b>pre:</b>
     * <ul>
     * <li>Tanto la fecha, como el cliente y el contrato deben estar inicializados (no ser null).</li>
     * </ul>
     * 
     * <b>post:</b>
     * <ul>
     * <li>Genera una factura y es agregada al sistema.</li>
     * </ul>
     * 
     * @param fecha Fecha de creacion de la factura
     * @param cliente Cliente asociado a la factura
     * @param contratos Contratos asociados a la factura
     */
    public void generarFactura(Date fecha, Persona cliente, ArrayList<Contratacion> contratos){
        assert fecha != null : "La fecha es null";
        assert cliente != null : "El cliente es null";
        assert contratos != null : "La lista de contratos es null";
        
        Factura nueva_factura = new Factura(fecha,cliente,contratos);
        nueva_factura.calcularImporteBruto();
        agregarFactura(nueva_factura);
        
        assert this.facturas.contains(nueva_factura) : "La factura no fue agregada al sistema";
    }
    
    /**
     * Genera adecuadamente una factura.
     * 
     * <b>pre:</b>
     * <ul>
     * <li>Tanto la fecha, como el cliente y el contrato deben estar inicializados (no ser null).</li>
     * </ul>
     * 
     * <b>post:</b>
     * <ul>
     * <li>Genera una factura y es agregada al sistema.</li>
     * </ul>
     * 
     * @param fecha Fecha de creacion de la factura
     * @param cliente Cliente asociado a la factura
     * @param contrato Contrato asociado a la factura
     */
    public void generarFactura(Date fecha, Persona cliente, Contratacion contrato){
        assert fecha != null : "La fecha es null";
        assert cliente != null : "El cliente es null";
        assert contrato != null : "El contrato es null";
        
        Factura nueva_factura = new Factura(fecha,cliente,contrato);
        nueva_factura.calcularImporteBruto();
        agregarFactura(nueva_factura);
        
        assert this.facturas.contains(nueva_factura) : "La factura no fue agregada al sistema";
    }

    /**
     * Genera el reporte detallado de la factura.
     * 
     * @return Reporte de la factura
     */
    public String generarReporte(){
        String reporte="";
        for(IFactura factura : this.facturas){
            reporte += factura.detalle();
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
