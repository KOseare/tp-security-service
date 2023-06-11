package negocio;

import negocio.excepciones.SaldoInsuficienteExeception;

public class ConContratacionesState implements States {
    private PersonaFisica personaFisica;


    public ConContratacionesState() {

    }

    public void setPersonaFisica(PersonaFisica personaFisica) {
        this.personaFisica = personaFisica;
    }

    public PersonaFisica getPersonaFisica() {
        return personaFisica;
    }
    //
    public ConContratacionesState(PersonaFisica personaFisica) {
        this.personaFisica = personaFisica;
    }

    @Override
    public void pagarFactura(Factura factura, double importe) throws SaldoInsuficienteExeception {
        // si, llamar metodo de personafisica

        //precondicion
        //solo puede pagar facturas que no esten pagas
        //la factura anterior a esta debe estar pagada
        this.personaFisica.pagarFactura(factura,importe);
    }

    @Override
    public void agregarContrato(Contratacion contrato) {
        // si, llamar metodo de personafisica
        this.personaFisica.ultimaFactura().agregarContrato(contrato);
    }

    @Override
    public void darBajaServicio(Contratacion contrato) {
        // si, llamar metodo de personafisica
        this.personaFisica.ultimaFactura().darBajaServicio(contrato);
        //si queda sin contrataciones pasar al estado sin contrataciones
        if(personaFisica.getContrataciones().isEmpty())
            personaFisica.setEstado(new SinContratacionState(this.personaFisica));        
    }

    @Override
    public void actualizarEstado() {
        //chequea si se pago 2 veces consecutivas y cambia o no a moroso
        //tirar excepcion?
        //if(personaFisica.getFacturas().size() > 2 && !personaFisica.getFacturas().get(personaFisica.getFacturas().size()-2).isPagado())
         //   personaFisica.setEstado(new Moroso(this.personaFisica));
    }
    public String toString(){
        return "Con Contrataciones";
    }
}
