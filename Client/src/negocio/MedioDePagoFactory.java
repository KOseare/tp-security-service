package negocio;

public class MedioDePagoFactory {
    public MedioDePagoDecorator getMedioDePago(String tipo, IFactura factura){
        if(tipo == null)
            return null;
        if(tipo.equalsIgnoreCase("Cheque")){
            return new Cheque(factura);
        }
        else if(tipo.equalsIgnoreCase("Tarjeta")){
            return new Tarjeta(factura);
        }
        else if(tipo.equalsIgnoreCase("Efectivo")){
            return new Efectivo(factura);
        }
        return null;
    }
}
