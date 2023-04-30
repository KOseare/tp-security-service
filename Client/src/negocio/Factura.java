package negocio;

import java.util.ArrayList;
import java.util.Date;

/**
 * Clase que representa una factura generada para una persona.
 * Contiene las contrataciones realizadas por la persona e informacion
 * relevante para la facturacion.
 */
public class Factura implements Cloneable, IFactura {
    private double importe_bruto, importe_neto, descuento = 0;
    private Date fecha;
    private boolean pagado;

    private Persona cliente;
    private ArrayList<Contratacion> contratos = new ArrayList<Contratacion>();

    /**
     * <b>pre:</b>
     * <ul>
     * <li>La fecha y el cliento no son null.</li>
     * <li>La lista de contratos esta inicializada (no es null).</li>
     * </ul>
     * 
     * <b>post:</b>
     * <ul>
     * <li>Se crea una nueva factura con los datos proporcionados.</li>
     * <li>Se inicializa la factura como "no pagada".</li>
     * </ul>
     * 
     * @param fecha La fecha de emisión de la factura
     * @param cliente El cliente al que pertenece la factura
     * @param contratos La lista de contrataciones realizadas por la persona
     */
    public Factura(Date fecha, Persona cliente, ArrayList<Contratacion> contratos){
        assert fecha != null : "La fecha es nula";
        assert cliente != null : "El cliente es nulo";
        assert contratos != null : "La lista de contrataciones es nula";
                
        this.fecha = fecha;
        this.pagado = false;
        this.cliente = cliente;
        this.contratos = contratos;
        this.calcularImporteBruto();
    }
    public Factura(Date fecha, Persona cliente, Contratacion contrato){
        this.fecha = fecha;
        this.pagado = false;
        this.cliente = cliente;
        this.contratos.add(contrato);
        this.calcularImporteBruto();
        }

    /**
     * Calcula el importe bruto de la factura en función de la lista de contrataciones y los descuentos del cliente.
     * 
     * <b>pre:</b>
     * <ul>
     * <li>La lista de contratos esta inicializada (no es null).</li>
     * </ul>
     * 
     * <b>post:</b>
     * <ul>
     * <li>Se estable el importe_bruto (atributo).</li>
     * </ul>
     */
    public void calcularImporteBruto(){ //Una vez generada la factura, se calcula el importe bruto segun la cantidad de contrataciones
        assert this.contratos != null : "La lista de contrataciones es nula";
    
        double importe = 0,importeNeto = 0;
        ArrayList<Double> descuentos = this.cliente.recibeDescuento(this.contratos);
        for(int i = 0;i<contratos.size();i++){
            importe += contratos.get(i).getPrecio() + contratos.get(i).obtenerTotalDeServiciosAdicionales();
            this.descuento +=  contratos.get(i).getPrecio() * (1-descuentos.get(i)) + contratos.get(i).getPrecioPromo();//1-desc porque agrega el porcentaje a descontar
        }


        this.importe_bruto = importe;
        this.importe_neto = importe - descuento; /* El importe neto se calcula segÃºn el decorator de tipo de pago */
    }

    public double getImporteBruto() {
        return importe_bruto;
    }

    public void agregarContrato(Contratacion contrato){
        this.contratos.add(contrato);
        this.calcularImporteBruto();
    }

    @Override
    public void pagarFactura() {

    }

    @Override
    public double getDescuento() {
        return this.descuento;
    }

    public double getImporteNeto() {
        return this.importe_neto;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public boolean isPagado() {
        return pagado;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        Factura facturaClonada = null;
        facturaClonada = (Factura) super.clone();
        facturaClonada.fecha=(Date) this.fecha.clone();
        facturaClonada.cliente=(Persona) this.cliente.clone();
        facturaClonada.contratos = (ArrayList<Contratacion>) this.contratos.clone(); 

        return facturaClonada;
    }
    @Override
    public String detalle() {
        String detalle="Fecha: "+ this.fecha + " Abonado: " + this.cliente + "\n Contratos: \n";
        for(Contratacion contrato:contratos)
            detalle += contrato.toSting();
        detalle += "Importe Bruto: "+ getImporteBruto() + " Descuentos: " + this.descuento + " Importe Neto: "+ this.getImporteNeto() + ", Pagado: "+ this.isPagado() + "\n\n";
        
        return detalle; 
    }

}
