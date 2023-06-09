package negocio;

import java.time.LocalTime;

/**
 * Clase que representa un servicio adicional de movil de acompaniamiennto para una contratacion de monitoreo.
 */
public class MovilDeAcompaniamiento extends ServicioAdicional {
    private LocalTime entrada, salida;
    
    public MovilDeAcompaniamiento() {
    }
    

    public LocalTime getEntrada() {
        return entrada;
    }

    public LocalTime getSalida() {
        return salida;
    }

    public void setEntrada(LocalTime entrada) {
        this.entrada = entrada;
    }

    public void setSalida(LocalTime salida) {
        this.salida = salida;
    }

    /**
     * <b>pre:</b>
     * <ul>
     * <li>La entrada y salida deben estar instanciadas correctamente (no son null)</li>
     * </ul>
     *
     * <b>post:</b>
     * <ul>
     * <li>Se crea el movil de acompaniamiento con entrada y salida inicializadas.</li>
     * <li>La cantidad es igual a 1.</li>
     * </ul>
     *
     * @param entrada Hora de entrada del servicio de acompaniamiento
     * @param salida Hora de salida del servicio de acompañamiento
     */
    public MovilDeAcompaniamiento(LocalTime entrada, LocalTime salida) {
        super(1);
        
        assert entrada != null : "La entrada es null";
        assert salida != null : "La salida es null";
        
        this.entrada = entrada;
        this.salida = salida;
        
        assert this.cantidad != 1: "La cantidad de moviles es distinta de 1";
    }


    /**
     * Devuelve el precio del servicio de acompaniamiento.
     * 
     * @return el precio del servicio de acompaniamiento.
     */
    @Override
    public double obtenerPrecio() {
        return 7500.0;
    }
    
    @Override
    public String toString() {
        return "Movil de acompaniamiento (De " /*+ this.entrada.toString() + " a " + this.salida.toString()*/ + ")" ;
    }

}
