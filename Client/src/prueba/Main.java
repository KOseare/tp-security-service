package prueba;

import java.time.LocalTime;

import negocio.BotonAntiPanico;
import negocio.Camara;
import negocio.Contratacion;
import negocio.Domicilio;
import negocio.Dorada;
import negocio.MonitoreoComercio;
import negocio.MonitoreoVivienda;
import negocio.MovilDeAcompaniamiento;
import negocio.Persona;
import negocio.PersonaFisica;
import negocio.PersonaJuridica;
import negocio.Platino;
import negocio.Promocion;
import negocio.SistemaSeguridad;
import presentacion.MainControlador;
import presentacion.VistaLogin;
import presentacion.VistaSistema;

public class Main {

	public static void main(String[] args) {
		VistaSistema vista = new VistaSistema();
        SistemaSeguridad sistema = SistemaSeguridad.getSistema();
        VistaLogin login = new VistaLogin();
    MainControlador controlador = new MainControlador(vista,login);

    initTestData(sistema);
    
    vista.setControlador(controlador);
    vista.arranca();    
    
    vista.updateListaAbonados(sistema.getClientes()); // Es un test, las actualizaciones se deben hacer en el controlador
	}
	
	public static void initTestData (SistemaSeguridad sistema) {
		Promocion dorada = new Dorada();
    Promocion platino = new Platino();

    Persona personaFisica = new PersonaFisica("Juan", "42415305");
    Persona personaJuridica = new PersonaJuridica("Sancho", "25416352");

    Contratacion contratacionAuxiliar;

    //creacion de facturas

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
    personaFisica.agregarContrato(contratacionAuxiliar);

    contratacionAuxiliar = new MonitoreoVivienda(personaFisica.getDomicilios().get(1)); //sin adicionales
    personaFisica.agregarContrato(contratacionAuxiliar);

    //persona juridica
    personaJuridica.agregarDomicilio(new Domicilio("Almirante Brown", "1542", "7602"));
    personaJuridica.agregarDomicilio(new Domicilio("Primera Junta", "1682", "7602"));
    personaJuridica.agregarDomicilio(new Domicilio("Rawson", "942", "7602"));
    personaJuridica.agregarDomicilio(new Domicilio("Ortis", "9652", "7602")); //con descuento

    contratacionAuxiliar = new MonitoreoComercio(personaJuridica.getDomicilios().get(0));
    contratacionAuxiliar.agregarServicioAdicional(new Camara(3));
    contratacionAuxiliar.setPromocion(platino);
    
    personaJuridica.agregarContrato(contratacionAuxiliar);

    contratacionAuxiliar = new MonitoreoVivienda(personaJuridica.getDomicilios().get(1));
    contratacionAuxiliar.agregarServicioAdicional(new MovilDeAcompaniamiento(LocalTime.of(9, 30),
                                                                             LocalTime.of(13, 0)));
    contratacionAuxiliar.agregarServicioAdicional(new BotonAntiPanico(3));

    contratacionAuxiliar.setPromocion(platino);

    personaJuridica.agregarContrato(contratacionAuxiliar); //promo platino

    contratacionAuxiliar = new MonitoreoComercio(personaJuridica.getDomicilios().get(2));
    contratacionAuxiliar.agregarServicioAdicional(new BotonAntiPanico(1));
    contratacionAuxiliar.setPromocion(dorada);

    personaJuridica.agregarContrato(contratacionAuxiliar);

    contratacionAuxiliar = new MonitoreoVivienda(personaJuridica.getDomicilios().get(3));
    contratacionAuxiliar.agregarServicioAdicional(new BotonAntiPanico(3));
    contratacionAuxiliar.agregarServicioAdicional(new Camara(1));
    contratacionAuxiliar.setPromocion(dorada);

    personaJuridica.agregarContrato(contratacionAuxiliar);
    
    // -------------

    personaFisica = new PersonaFisica("Pepito", "35214256");
    sistema.agregarCliente(personaFisica);
    personaFisica.agregarDomicilio(new Domicilio("Belgrano", "1512", "7602"));
    personaFisica.agregarDomicilio(new Domicilio("Almirante Brown", "1432", "7602"));
    personaFisica.agregarDomicilio(new Domicilio("Moreno", "8612", "7602"));
    personaFisica.agregarDomicilio(new Domicilio("Entre Rios", "8453", "7602"));


    contratacionAuxiliar = new MonitoreoComercio(personaFisica.getDomicilios().get(0));
    contratacionAuxiliar.setPromocion(platino);
    personaFisica.agregarContrato(contratacionAuxiliar);


    contratacionAuxiliar = new MonitoreoVivienda(personaFisica.getDomicilios().get(1));
    contratacionAuxiliar.setPromocion(platino);
    contratacionAuxiliar.agregarServicioAdicional(new Camara(3));
    personaFisica.agregarContrato(contratacionAuxiliar);

    contratacionAuxiliar = new MonitoreoVivienda(personaFisica.getDomicilios().get(2));
    contratacionAuxiliar.setPromocion(dorada);
    contratacionAuxiliar.agregarServicioAdicional(new Camara(1));
    contratacionAuxiliar.agregarServicioAdicional(new BotonAntiPanico(1));
    personaFisica.agregarContrato(contratacionAuxiliar);

    contratacionAuxiliar = new MonitoreoComercio(personaFisica.getDomicilios().get(3));
    contratacionAuxiliar.setPromocion(dorada);
    contratacionAuxiliar.agregarServicioAdicional(new Camara(1));
    contratacionAuxiliar.agregarServicioAdicional(new BotonAntiPanico(6));
    contratacionAuxiliar.agregarServicioAdicional(new MovilDeAcompaniamiento(LocalTime.of(9, 30),
                                                                             LocalTime.of(13, 0)));
    personaFisica.agregarContrato(contratacionAuxiliar);
	}

}
