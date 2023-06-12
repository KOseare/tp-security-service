package prueba;

import datos.PersistenciaXML;
import datos.SistemaSeguridadDTO;
import datos.UtilSerializacionSistema;


import java.io.IOException;

import java.util.GregorianCalendar;

import javax.swing.WindowConstants;

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
import negocio.Tecnico;

import presentacion.MainControlador;
import presentacion.VistaLogin;
import presentacion.VistaSistema;

public class Main {

    public static void main(String[] args) {


        PersistenciaXML idao = new PersistenciaXML();

        initTestData(SistemaSeguridad.getSistema());
        /*try {
            idao.abrirInput("sistemaSeguridad.xml");
            SistemaSeguridadDTO sistemaSeguridadDTO = (SistemaSeguridadDTO) idao.leer();
            UtilSerializacionSistema.sistemaFromSistemaSeguridadDTO(sistemaSeguridadDTO);
            idao.cerrarInput();
            System.out.println("Sistema Recuperado ");
            //vista.updateListaAbonados(sistema.getClientes());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Exception " + e.getMessage());
            initTestData(SistemaSeguridad.getSistema());
        } catch (ClassNotFoundException e) {
            System.out.println("Exception " + e.getMessage());
        }*/

        VistaSistema vista = new VistaSistema();
        VistaLogin login = new VistaLogin();
        vista.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        MainControlador controlador = new MainControlador(vista, login);

    }


    public static void initTestData(SistemaSeguridad sistema) {
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
        contratacionAuxiliar.agregarServicioAdicional(new MovilDeAcompaniamiento(new GregorianCalendar(1990, 01, 01, 10,
                                                                                                       30),
                                                                                 new GregorianCalendar(1990, 01, 01, 14,
                                                                                                       30)));
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
        contratacionAuxiliar.agregarServicioAdicional(new MovilDeAcompaniamiento(new GregorianCalendar(1990, 01, 01, 9,
                                                                                                       30),
                                                                                 new GregorianCalendar(1990, 01, 01, 13,
                                                                                                       00)));
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
        contratacionAuxiliar.agregarServicioAdicional(new MovilDeAcompaniamiento(new GregorianCalendar(1990, 01, 01, 17,
                                                                                                       20),
                                                                                 new GregorianCalendar(1990, 01, 01, 20,
                                                                                                       48)));
        personaFisica.agregarContrato(contratacionAuxiliar);

        sistema.getServiciotecnico().agregarTecnico(new Tecnico("Jaime"));
        sistema.getServiciotecnico().agregarTecnico(new Tecnico("Franco"));
    }

}
