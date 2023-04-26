package negocio;

import java.time.LocalTime;


public class MovilDeAcompaniamiento extends ServicioAdicional {
    private LocalTime entrada, salida;

    public MovilDeAcompaniamiento(LocalTime entrada, LocalTime salida) {
        super(1);
        this.entrada = entrada;
        this.salida = salida;
    }


    public LocalTime getEntrada() {
        return entrada;
    }

    public LocalTime getSalida() {
        return salida;
    }

    @Override
    public double obtenerPrecio() {
        return 7500.0;
    }
    
    @Override
    public String toString() {
        return "Movil de acompaniamiento (De " + this.entrada.toString() + " a " + this.salida.toString() + ")" ;
    }
}
