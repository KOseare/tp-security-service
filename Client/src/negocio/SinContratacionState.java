package negocio;

import negocio.excepciones.EstadoException;

public class SinContratacionState implements States {
    private PersonaFisica personaFisica;

    public SinContratacionState() {

    }

    public void setPersonaFisica(PersonaFisica personaFisica) {
        this.personaFisica = personaFisica;
    }

    public PersonaFisica getPersonaFisica() {
        return personaFisica;
    }

    public SinContratacionState(PersonaFisica personaFisica) {
        this.personaFisica = personaFisica;
    }

    @Override
    public void pagarFactura(IFactura factura, double importe) throws EstadoException {
       throw new EstadoException("No puede pagar la factura sin contratos");

    }

    @Override
    public void agregarContrato(Contratacion contrato) {
        // si puede, llamar al metodo de contratacion de la persona
        //llamar al metodo pasar a ConContratacionesState
        this.personaFisica.ultimaFactura().agregarContrato(contrato);
        this.personaFisica.setEstado(new ConContratacionesState(this.personaFisica));
    }

    @Override
    public void darBajaServicio(Contratacion contrato) {
        // nop enviar exception
    }

    @Override
    public void actualizarEstado() {
        // no hace nada
    }
    public String toString(){
        return "Sin Contrataciones";
    }
}
