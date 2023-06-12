package negocio;

import java.util.Iterator;

import negocio.excepciones.EstadoException;
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
    public void pagarFactura(IFactura factura, double importe) throws SaldoInsuficienteExeception, EstadoException {
        factura.pagarFactura(importe);
        actualizarEstado();
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
        Factura recargable;
        Iterator<Factura> it = personaFisica.getFacturas().descendingIterator();
        it.next();
            recargable = it.next();
            if (!recargable.isPagado()) {
                recargable.setRecargo(new Recargo(30));
                personaFisica.setEstado(new Moroso(this.personaFisica));
            }
            else
                    personaFisica.setEstado(new ConContratacionesState(this.personaFisica));

    }
    public String toString(){
        return "Moroso";
    }
}
