package negocio;

import java.util.ArrayList;
import java.util.Date;

public class SistemaSeguridad {
    private ArrayList<Persona> Clientes = new ArrayList<Persona>();
    private ArrayList<Factura> Facturas = new ArrayList<Factura>();
    public SistemaSeguridad() {
        super();
    }

    public void agregarCliente(Persona cliente){
        Clientes.add(cliente);
    }

    public void agregarFactura(Factura factura){
        Facturas.add(factura);
    }

    public void eliminarCliente(Persona cliente){
        Clientes.remove(cliente);
    }

    public void eliminarFactura(Factura factura){
        Facturas.remove(factura);
    }

    public ArrayList<Persona> getClientes(){
        return Clientes;
    }

    public ArrayList<Factura> getFacturas(){
        return Facturas;
    }

    public void generarFactura(double importe, Date fecha, Persona cliente, ArrayList<Contratacion> contratos, double descuento){
        Factura nueva_factura = new Factura(importe,fecha,cliente,contratos,descuento);
        agregarFactura(nueva_factura);
    }
}
