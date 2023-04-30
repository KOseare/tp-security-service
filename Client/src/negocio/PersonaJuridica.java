package negocio;

import java.util.ArrayList;

/**
 * Clase que representa a una persona juridica.
 */
public class PersonaJuridica extends Persona {
    @Override
    public void generarFactura() {
        // TODO Implement this method
    }

    /**
     * Calcula los descuentos que recibe en cada una de sus contrataciones.
     * 
     * <b>pre:</b>
     * <ul>
     * <li>La lista de contratos esta inicializada (no es null).</li>
     * </ul>
     * 
     * @param contratos Lista de contrataciones de la persona juridica.
     * @return Lista de valores de descuento para cada contrato.
     */
    @Override
    public ArrayList<Double> recibeDescuento(ArrayList<Contratacion> contratos) {
        assert contratos != null : "La lista de contratos no esta inicializada";
        
        ArrayList<Double> valores = new ArrayList<Double>();
        for(int i = 0;i<contratos.size();i++){
            if(i>2){
                valores.add(0.5);
            }else{
                valores.add(1.0);
            }
        }
        return valores;
    }

    @Override
    public String toString(){
        return "Tipo: Persona Juridica";
    }
}
