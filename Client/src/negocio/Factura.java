package negocio;

import java.util.ArrayList;
import java.util.Date;

public class Factura implements Cloneable,IFactura {
    private double importe_bruto,importe_neto,descuentos;
    private Date fecha;
    private boolean pagado;

    private Persona cliente;
    private ArrayList<Contratacion> contratos = new ArrayList<Contratacion>();
    

    public Factura(double importe, Date fecha) {
        this.importe_bruto = importe;
        this.fecha = fecha;
        this.pagado = false;
        this.descuentos = 0;
    }

public Factura(double importe, Date fecha, Persona cliente, ArrayList<Contratacion> contratos,double descuento){
        this.importe_bruto = importe;
        this.fecha = fecha;
        this.pagado = false;
        this.cliente = cliente;
        if(cliente.recibeDescuento(contratos)){
            descuento = descuento * 0.5;
        }
        this.contratos = contratos;
        this.descuentos = descuento;
        this.importe_neto = importe - (importe * descuento);
    }

    public double getImporteBruto() {
        return importe_bruto;
    }
    public double getImporteNeto() {return importe_neto;}
    public void setDescuentos(double descuentos) {
        this.descuentos = descuentos;
    }

    public double getDescuentos() {
        return descuentos;
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
        Factura clon;
        try {
            clon = (Factura) super.clone();
            return clon;
        } catch (CloneNotSupportedException e) {
            throw e;
        }

    }

    @Override
    public String detalle() {
        // TODO Implement this method
        return null;
    }
}
