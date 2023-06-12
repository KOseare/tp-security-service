package negocio;

import java.util.ArrayList;
import java.util.Date;

import negocio.excepciones.SaldoInsuficienteExeception;

/**
 * Clase que representa una factura generada para una persona.
 * Contiene las contrataciones realizadas por la persona e informacion
 * relevante para la facturacion.
 */
public class Factura implements Cloneable, IFactura, Comparable<Factura> {
    private double importe_bruto, importe_neto, descuento = 0, importeDePago = 0;
    private Date fecha;
    private boolean pagado;
    private Recargo recargo;
    /**
     * @aggregation shared
     */
    private Persona cliente;

    /**
     * @aggregation composite
     */
    private ArrayList<Contratacion> contratos = new ArrayList<Contratacion>();

    /**
     * <b>pre:</b>
     * <ul>
     * <li>La fecha y el cliente no son null.</li>
     * <li>La lista de contratos esta inicializada (no es null).</li>
     * </ul>
     *
     * <b>post:</b>
     * <ul>
     * <li>Se crea una nueva factura con los datos proporcionados.</li>
     * <li>Se inicializa la factura como "no pagada".</li>
     * </ul>
     *
     * @param fecha La fecha de emisi�n de la factura
     * @param cliente El cliente al que pertenece la factura
     * @param contratos La lista de contrataciones realizadas por la persona
     */
    public Factura(Date fecha, Persona cliente, ArrayList<Contratacion> contratos) {
        assert fecha != null : "La fecha es nula";
        assert cliente != null : "El cliente es nulo";
        assert contratos != null : "La lista de contrataciones es nula";

        this.fecha = fecha;
        this.pagado = false;
        this.cliente = cliente;
        this.contratos = contratos;
        this.calcularImporteBruto();
    }

    public Factura(Date fecha, Persona cliente, Contratacion contrato) {
        this.fecha = fecha;
        this.pagado = false;
        this.cliente = cliente;
        this.contratos.add(contrato);
        this.calcularImporteBruto();
    }

    public Factura(Date fecha, Persona cliente) {
        this.fecha = fecha;
        this.pagado = false;
        this.cliente = cliente;
        this.calcularImporteBruto();
    }
    
    public Factura() {

    }
    
    public void setContratos(ArrayList<Contratacion> contratos) {
        this.contratos = contratos;
    }

    public ArrayList<Contratacion> getContratos() {
        return contratos;
    }

    public void setImporte_bruto(double importe_bruto) {
        this.importe_bruto = importe_bruto;
    }

    public double getImporte_bruto() {
        return importe_bruto;
    }

    public void setImporte_neto(double importe_neto) {
        this.importe_neto = importe_neto;
    }

    public double getImporte_neto() {
        return importe_neto;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setImporteDePago(double importeDePago) {
        this.importeDePago = importeDePago;
    }

    public double getImporteDePago() {
        return importeDePago;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    public Persona getCliente() {
        return cliente;
    }

    /**
     * Calcula el importe bruto de la factura en funci�n de la lista de contrataciones y los descuentos del cliente.
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
    public void calcularImporteBruto() { //Una vez generada la factura, se calcula el importe bruto segun la cantidad de contrataciones

        assert this.contratos != null : "La lista de contrataciones es nula";

        double importe = 0;
                descuento=0;
        ArrayList<Double> descuentos = this.cliente.recibeDescuento(this.contratos);
        for (int i = 0; i < contratos.size(); i++) {
            importe += contratos.get(i).getPrecioDelServicio() + contratos.get(i).obtenerTotalDeServiciosAdicionales();
            this.descuento +=
                contratos.get(i).getPrecioDelServicio() * (1 - descuentos.get(i)) +
                contratos.get(i).getPrecioPromo(); //1-desc porque agrega el porcentaje a descontar
        }
        if(recargo != null) descuento -= importe * recargo.getPorcentaje();

        this.importe_bruto = importe;
        this.importe_neto = importe - descuento; /* El importe neto se calcula según el decorator de tipo de pago */
    }




    public void agregarContrato(Contratacion contrato) {
        this.contratos.add(contrato);
        this.calcularImporteBruto();
    }

    /**
     * Intenta pagar la factura con el importe especificado.
     *
     * <b>pre:</b>
     * <ul>
     * <li>El importe debe ser mayor a 0.</li>
     * </ul>
     *
     * <b>post:</b>
     * <ul>
     * <li>Se paga la factura o se lanza una excepcion.</li>
     * </ul>
     *
     * @param importeDePago
     * @throws SaldoInsuficienteExeception
     */
    @Override
    public void pagarFactura(double importeDePago) throws SaldoInsuficienteExeception {
        pagado = true;
        this.importeDePago = importeDePago;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Factura facturaClonada = null;
        facturaClonada = (Factura) super.clone();
        facturaClonada.fecha = (Date) this.fecha.clone();

        facturaClonada.contratos = new ArrayList<Contratacion>();
        for (Contratacion contrato : this.contratos) {
            facturaClonada.contratos.add((Contratacion) contrato.clone());
        }
        
        try {
            facturaClonada.cliente = (Persona) this.cliente.clone();
        } catch (PersonaJuridicaCloneException e) {
        		facturaClonada.cliente = this.cliente;
            System.out.println(e.getMessage());
        }

        return facturaClonada;
    }

    @Override
    public String detalle() {
        String detalle = "Fecha: " + this.fecha + " Abonado: " + this.cliente + "\n Contratos: \n";
        this.calcularImporteBruto();
        for (Contratacion contrato : contratos){
            detalle += contrato.toString();
            detalle += "\n";
        }
        detalle +=
            "Importe Bruto: " + this.importe_bruto + "\nDescuentos: " + this.descuento ;
        detalle += (recargo!=null)?this.recargo.toString():"";
        detalle += "\nImporte Neto: " + this.importe_neto + ",\nPagado: " + this.isPagado() + "\n\n";

        return detalle;
    }

    @Override
    public int compareTo(Factura factura) {
        return this.getFecha().compareTo(factura.getFecha());
    }

    public String toString() {
        return "Fecha: " + this.fecha + "\n Abonado: \n" + this.cliente + "\n";
    }

    void darBajaServicio(Contratacion contrato) {
        this.contratos.remove(contrato);
        this.calcularImporteBruto();
    }

    @Override
    public void setRecargo(Recargo recargo) {
        this.recargo = recargo;
    }
}
