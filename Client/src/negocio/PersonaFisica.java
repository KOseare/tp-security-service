package negocio;

import java.util.ArrayList;

public class PersonaFisica extends Persona {
    @Override
    public void generarFactura() {
        // TODO Implement this method
    }

    @Override
    public ArrayList<Double> recibeDescuento(ArrayList<Contratacion> contratos) {
        ArrayList<Double> valores = new ArrayList<Double>();
        for(Contratacion c : contratos){
                valores.add(1.0);
        }
        return valores;
    }
}
