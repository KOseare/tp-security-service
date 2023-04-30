package negocio;

import java.util.ArrayList;
import java.util.Date;

public class Factura implements Cloneable, IFactura {
    private double importe_bruto, importe_neto, descuento = 0;
    private Date fecha;
    private boolean pagado;

    private Persona cliente;
    private ArrayList<Contratacion> contratos = new ArrayList<Contratacion>();

    public Factura(Date fecha, Persona cliente, ArrayList<Contratacion> contratos){
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

    public void calcularImporteBruto(){ //Una vez generada la factura, se calcula el importe bruto según la cantidad de contrataciones
        double importe = 0;
        ArrayList<Double> descuentos = this.cliente.recibeDescuento(this.contratos);
        for(int i = 0;i<contratos.size();i++){
            importe += contratos.get(i).getPrecio() * descuentos.get(i);
            for(ServicioAdicional s : contratos.get(i).getServiciosAdicionales())
                importe += s.obtenerPrecio();
        }

        this.importe_bruto = importe;
        this.importe_neto = importe; /* El importe neto se calcula según el decorator de tipo de pago */
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
    public String detalle() {
        String detalle="Fecha: "+ this.fecha + " Abonado: " + this.cliente + " Contratos: ";
        for(Contratacion contrato:contratos)
            detalle += contrato.toSting();
        detalle += ", Importe Bruto: "+ getImporteBruto() + " Descuentos: " + this.descuento + " Importe Neto: "+ this.getImporteNeto() + "\n";
        
        return detalle; 
    }
    @Override
    public Factura clone() throws CloneNotSupportedException {
        return (Factura)super.clone();
    }

}
