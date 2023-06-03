package negocio;

import java.util.ArrayList;

import javax.swing.plaf.nimbus.State;

/**
 * Clase que representa a una persona fisica.
 */
public class PersonaFisica extends Persona {


    private States estado;

    public PersonaFisica(String nombre, String dni) {
        // TODO Implement this method
        super(nombre, dni);
        this.setEstado(new SinContratacionState(this)); 
    }
    //nuevo, llamar a los metodos de factura y agregarlos en persona
    public void pagarFactura(){
        }
    public void contratarServicio(){
        
        }
    public void darBajaServicio(){
        }

    public void actualizarEstado(){
       this.estado.actualizarEstado(); 
    }

    /**
     * Calcula los descuentos que recibe en cada una de sus contrataciones.
     * 
     * <b>pre:</b>
     * <ul>
     * <li>La lista de contratos esta inicializada (no es null).</li>
     * </ul>
     * 
     * @param contratos Lista de contrataciones de la persona fisica.
     * @return Lista de valores de descuento para cada contrato.
     */
    @Override
    public ArrayList<Double> recibeDescuento(ArrayList<Contratacion> contratos) {
        assert contratos != null : "La lista de contratos no esta inicializada";
        
        ArrayList<Double> valores = new ArrayList<Double>();
        for(Contratacion c : contratos){
                valores.add(1.0);
        }
        return valores;
    }
    
    public void setEstado(States estado) {
        this.estado = estado;
    }
    @Override
    public String toString(){
        return super.toString() + " Tipo: Persona Fisica ";
    }
}
