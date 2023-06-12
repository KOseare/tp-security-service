package negocio;

import negocio.excepciones.SaldoInsuficienteExeception;

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
    public void pagarFactura(Factura factura, double importe) throws SaldoInsuficienteExeception {
        // recargo del 30% 
        personaFisica.pagarFactura(factura, importe * 1.3);//+30% crear nuevo recargo(con clase recargo)?
        //actualizarEstado();
    }

    @Override
    public void agregarContrato(Contratacion contrato) {
        // no puede
    }

    @Override
    public void darBajaServicio(Contratacion contrato) {
        // no puede
    }

    @Override
    public void actualizarEstado() {
        int cont=0;
            while(getPersonaFisica().getFacturas().descendingIterator().hasNext() && cont < 2)
                cont += getPersonaFisica().getFacturas().descendingIterator().next().isPagado()?0:1;    
            if(cont >= 2)
                personaFisica.setEstado(new ConContratacionesState(this.personaFisica));
            
        //chequea si se pago la factura, pasa a con contratacion
        //if(personaFisica.getFacturas().size() > 2 && personaFisica.getFacturas().get(personaFisica.getFacturas().size()-2).isPagado())
        //    personaFisica.setEstado(new ConContratacionesState(this.personaFisica));
    }
    public String toString(){
        return "Moroso";
    }
}
