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
        nueva_factura.calcularImporteBruto();
        agregarFactura(nueva_factura);
    }
    
    public void generarFactura(Date fecha, Persona cliente, Contratacion contrato){
        Factura nueva_factura = new Factura(fecha,cliente,contrato);
        nueva_factura.calcularImporteBruto();
        agregarFactura(nueva_factura);
    }
    /**
     * Agrega a la contratacion un nuevo servicio adicional.
     *
     * <b>pre:</b>
     * <ul>
     * <li>La factura debe estar instanciada (no es null).</li>
     * <li>El tipo de pago debe existir.</li>
     * <li>el importe debe ser mayor a 0.</li>
     * </ul>
     *
     * <b>post:</b>
     * <ul>
     * <li>Se paga la factura o se lanza una excepcion.</li>
     * </ul>
     *
     * @param factura Factura especifica a pagar
     * @param tipo_de_pago medio de pago usado
     * @param importe 
     * @throws SaldoInsuficienteExeception
     */
    public void pagarFactura(Factura factura, String tipo_de_pago,double importe)throws SaldoInsuficienteExeception{
        MedioDePagoFactory factory = new MedioDePagoFactory();
        MedioDePagoDecorator medio = factory.getMedioDePago(tipo_de_pago,factura);
        medio.factura.pagarFactura(importe);
    }

    public String generarReporte(){
        String reporte="";
        for(IFactura factura : this.facturas){
            reporte += factura.detalle();
        }
        return reporte;
    }
    /**
     * Agrega a la contratacion un nuevo servicio adicional.
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
     * @param servicio Duplicado de Factura
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
