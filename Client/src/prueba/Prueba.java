package prueba;

import java.time.LocalTime;

import java.util.ArrayList;

import java.util.Date;

import java.util.GregorianCalendar;

import negocio.*; //importa todas las clases del paquete

import negocio.Dorada;
import negocio.Efectivo;
import negocio.Factura;
import negocio.IFactura;
import negocio.Persona;
import negocio.Platino;
import negocio.Promocion;
import negocio.SistemaSeguridad;

public class Prueba {
    public Prueba() {
        super();
    }

    public static void main(String[] args) {
        SistemaSeguridad sistema = SistemaSeguridad.getSistema();

        Promocion dorada = new Dorada();
        Promocion platino = new Platino();

        Persona personaFisica = new PersonaFisica("Juan", "42415305");
        Persona personaJuridica = new PersonaJuridica("Luis", "25416352");

        Contratacion contratacionAuxiliar;
        ArrayList<Contratacion> contratos = new ArrayList<Contratacion>();


        personaFisica.agregarDomicilio(new Domicilio("Corrientes", "3215", "7600")); //2 domicilios
        personaFisica.agregarDomicilio(new Domicilio("Moreno", "1215", "7600"));

        personaJuridica.agregarDomicilio(new Domicilio("Entre Rios", "1215", "7600")); //1 domicilio

        //la persona debe tener al menos un domicilio, ingresar assert?
        sistema.agregarCliente(personaFisica);
        sistema.agregarCliente(personaJuridica);

        contratacionAuxiliar =
            new MonitoreoComercio(personaFisica.getDomicilios().get(0)); //contratacion 1 persona fisica
        //precocndicion la cantidad debe ser mayor que 0
        contratacionAuxiliar.agregarServicioAdicional(new Camara(2));
        contratacionAuxiliar.agregarServicioAdicional(new BotonAntiPanico(1));
        contratacionAuxiliar.agregarServicioAdicional(new MovilDeAcompaniamiento(LocalTime.of(10, 30),
                                                                                 LocalTime.of(14, 30)));
        sistema.generarFactura(new Date(122, 2, 3), personaFisica, contratacionAuxiliar);

        contratacionAuxiliar = new MonitoreoVivienda(personaFisica.getDomicilios().get(1)); //sin adicionales

        sistema.getFacturas()
               .get(0)
               .agregarContrato(contratacionAuxiliar);

        //persona juridica
        personaJuridica.agregarDomicilio(new Domicilio("Corrientes", "1542", "7602"));
        personaJuridica.agregarDomicilio(new Domicilio("Formosa", "1682", "7602"));
        personaJuridica.agregarDomicilio(new Domicilio("Misiones", "942", "7602"));
        personaJuridica.agregarDomicilio(new Domicilio("Rawson", "9652", "7602")); //con descuento

        contratacionAuxiliar = new MonitoreoComercio(personaJuridica.getDomicilios().get(0));
        contratacionAuxiliar.agregarServicioAdicional(new Camara(3));

        contratos.add(contratacionAuxiliar);

        contratacionAuxiliar = new MonitoreoVivienda(personaJuridica.getDomicilios().get(1));
        contratacionAuxiliar.agregarServicioAdicional(new MovilDeAcompaniamiento(LocalTime.of(9, 30),
                                                                                 LocalTime.of(13, 0)));
        contratacionAuxiliar.agregarServicioAdicional(new BotonAntiPanico(3));
        
        contratacionAuxiliar.setPromocion(platino);

        contratos.add(contratacionAuxiliar);//promo platino

        contratacionAuxiliar = new MonitoreoComercio(personaJuridica.getDomicilios().get(2));
        contratacionAuxiliar.agregarServicioAdicional(new BotonAntiPanico(1));

        contratos.add(contratacionAuxiliar);

        contratacionAuxiliar = new MonitoreoVivienda(personaJuridica.getDomicilios().get(3));
        contratacionAuxiliar.agregarServicioAdicional(new BotonAntiPanico(3));
        contratacionAuxiliar.agregarServicioAdicional(new Camara(1));
        contratacionAuxiliar.setPromocion(dorada);
        
        contratos.add(contratacionAuxiliar);

        sistema.generarFactura(new Date(), personaJuridica, contratos);
        
        

        System.out.print(sistema.generarReporte());
    }
}
