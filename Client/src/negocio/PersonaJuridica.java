package negocio;

import java.util.ArrayList;

public class PersonaJuridica extends Persona {
    @Override
    public void generarFactura() {
        // TODO Implement this method
    }

    @Override
    public boolean recibeDescuento(ArrayList<Contratacion> contratos) {
        return contratos.size() > 3;
    }
    @Override
    public String toString(){
        return "Tipo: Persona Juridica";
    }
}
