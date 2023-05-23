package negocio;

public class SinContratacionState implements States {
    private PersonaFisica personaFisica;


    public SinContratacionState(PersonaFisica personaFisica) {
        this.personaFisica = personaFisica;
    }

    @Override
    public void pagarFactura() {
        // no puede pagar factura exeption?
        
    }

    @Override
    public void contratarServicio() {
        // si puede, llamar al metodo de contratacion de la persona
        //llamar al metodo pasar a ConContratacionesState
        this.personaFisica.setEstado(new ConContratacionesState(this.personaFisica));
    }

    @Override
    public void darBajaServicio() {
        // nop enviar exception
    }

    @Override
    public void actualizarEstado() {
        // no hace nada
        
    }
}
