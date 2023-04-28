package negocio;

import java.util.ArrayList;

public class PersonaFisica extends Persona {
    @Override
    public void generarFactura() {
        // TODO Implement this method
    }

    @Override
    public boolean recibeDescuento(ArrayList<Contratacion> contratos) {
        return false;
    }
}
