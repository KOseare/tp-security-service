package negocio;

public class Moroso implements States {
    private PersonaFisica personaFisica;


    public Moroso() {
    }

    public void setPersonaFisica(PersonaFisica personaFisica) {
        this.personaFisica = personaFisica;
    }

    public PersonaFisica getPersonaFisica() {
        return personaFisica;
    }
    //
    public Moroso(PersonaFisica personaFisica) {
        this.personaFisica = personaFisica;
    }

    @Override
    public void pagarFactura() {
        // recargo del 30% :o
        //actualizador de estado?
        personaFisica.pagarFactura();//+30% crear nuevo recargo(con clase recargo)?
        
    }

    @Override
    public void contratarServicio() {
        // no puede
    }

    @Override
    public void darBajaServicio() {
        // no puede
    }

    @Override
    public void actualizarEstado() {
        //chequea si se pago la factura, pasa a con contratacion
        //if(personaFisica.getFacturas().size() > 2 && personaFisica.getFacturas().get(personaFisica.getFacturas().size()-2).isPagado())
        //    personaFisica.setEstado(new ConContratacionesState(this.personaFisica));
    }
}
