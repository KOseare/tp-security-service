package negocio;

import java.util.ArrayList;
import java.util.Date;

public class Factura implements Cloneable,IFactura {
    private double importe_bruto,importe_neto,descuento;
    private Date fecha;
    private boolean pagado;

    private Persona cliente;
    private ArrayList<Contratacion> contratos = new ArrayList<Contratacion>();


    public Factura(double importe, Date fecha, Persona cliente, ArrayList<Contratacion> contratos,double descuento){
        this.fecha = fecha;
        this.pagado = false;
        this.cliente = cliente;
        this.contratos = contratos;
    }

    public void calcularImporteBruto(){ //Una vez generada la factura, se calcula el importe bruto según la cantidad de contrataciones
        double importe = 0;
        ArrayList<Double> descuentos = this.cliente.recibeDescuento(this.contratos);
        for(int i = 0;i<contratos.size();i++){
            importe += contratos.get(i).getPrecio() * descuentos.get(i);
        }
        this.importe_bruto = importe;
        this.importe_neto = importe; /* El importe neto se calcula según el decorator de tipo de pago */
    }

    public double getImporteBruto() {
        return importe_bruto;
    }

    @Override
    public void pagarFactura() {

    }

    @Override
    public double getDescuento() {
        return this.descuento;
    }

    public double getImporteNeto() {return importe_neto;}
    public void setDescuentos(double descuento) {
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

}
