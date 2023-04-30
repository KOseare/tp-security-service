package negocio;

import java.util.ArrayList;

public class PersonaFisica extends Persona {

    public PersonaFisica(String nombre, String dni) {
        // TODO Implement this method
        super(nombre, dni);
    }

    @Override
    public ArrayList<Double> recibeDescuento(ArrayList<Contratacion> contratos) {
        ArrayList<Double> valores = new ArrayList<Double>();
        for(Contratacion c : contratos){
                valores.add(1.0);
        }
        return valores;
    }
    @Override
    public String toString(){
        return super.toString() + " Tipo: Persona Fisica ";
    }
}
