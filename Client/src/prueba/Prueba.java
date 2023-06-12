package prueba;

import datos.PersistenciaXML;

import datos.SistemaSeguridadDTO;

import datos.UtilSerializacionSistema;

import java.beans.XMLEncoder;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.util.ArrayList;

import java.util.Date;

import java.util.GregorianCalendar;

import javax.rmi.CORBA.Util;

import negocio.*; //importa todas las clases del paquete

import negocio.Dorada;
import negocio.Efectivo;
import negocio.Factura;
import negocio.IFactura;
import negocio.Persona;
import negocio.Platino;
import negocio.Promocion;
import negocio.SistemaSeguridad;

import negocio.excepciones.SaldoInsuficienteExeception;

public class Prueba {
    public Prueba() {
        super();
    }

    public static <Usuario> void main(String[] args) {
        SistemaSeguridad sistema = SistemaSeguridad.getSistema();

        Promocion dorada = new Dorada();
        Promocion platino = new Platino();



        Persona personaFisica = new PersonaFisica("Juan", "42415305");
        sistema.nuevoUsuario("prueba", "prueba",personaFisica);
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
        contratacionAuxiliar.agregarServicioAdicional(new MovilDeAcompaniamiento(new GregorianCalendar(1990,01,01,10,30),
                                                                                 new GregorianCalendar(1990,01,01,14,30)));
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
        contratacionAuxiliar.agregarServicioAdicional(new MovilDeAcompaniamiento(new GregorianCalendar(1990,01,01,9,30),
                                                                                 new GregorianCalendar(1990,01,01,13,00)));
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
        contratacionAuxiliar.agregarServicioAdicional(new MovilDeAcompaniamiento(new GregorianCalendar(1990,01,01,17,20),
                                                                                 new GregorianCalendar(1990,01,01,20,48))); 
        personaFisica.agregarContrato(contratacionAuxiliar);

        //pago de facturas
        MedioDePagoFactory mpf = new MedioDePagoFactory();

        IFactura facturaAPagar = mpf.getMedioDePago("Efectivo", sistema.getClientes().get(2).ultimaFactura());

        System.out.print("Factura a pagar :" + facturaAPagar.detalle());

        try {
            facturaAPagar.pagarFactura(10000);
            System.out.print(" Factura Pagada");
        } catch (SaldoInsuficienteExeception e) {
            System.out.print(" No se pudo pagar la factura, faltan : " + (e.getValor() - e.getImporte()));
        }
        

        facturaAPagar = mpf.getMedioDePago("Tarjeta", sistema.getClientes().get(1).ultimaFactura()); //apareceran 2 facturas, una pagada y otra no

        System.out.print("\n\nFactura a pagar :" + facturaAPagar.detalle());

        try {
            facturaAPagar.pagarFactura(100000);
            System.out.print(" Factura Pagada");
        } catch (SaldoInsuficienteExeception e) {
            System.out.print(" No se pudo pagar la factura, faltan : " + (e.getValor() - e.getImporte()));
        }


        //clonacion de factura
        System.out.print("\n\n\nClonacion de Facturas: ");


        try { 
            Factura f = (Factura) sistema.getClientes().get(1).ultimaFactura().clone();
            System.out.print("\n\tClonacion Exitosa");

        } catch (CloneNotSupportedException e) {
            System.out.print("\n" + e.getMessage());
            
        }
        try {
            Factura f = (Factura) sistema.getClientes().get(0).ultimaFactura().clone();
            System.out.print("\n\nClonacion Exitosa");
            System.out.print("\n\nPago de Factura clonada(en el reporte habran 2 facturas una de ellas pagada)");
            facturaAPagar = mpf.getMedioDePago("Cheque", f); //apareceran 2 facturas, una pagada y otra no

            System.out.print("\n\tFactura a pagar :" + facturaAPagar.detalle());
            
        } catch (CloneNotSupportedException e) {
            System.out.print("\n" + e.getMessage());

        }

        System.out.print("\n\n\nReporte de Facturas: \n");
        System.out.print(sistema.generarReporte());
        
        
        

        
        PersistenciaXML idao = new PersistenciaXML();
        try
        {
            idao.abrirOutput("sistemaSeguridad.xml");
            SistemaSeguridadDTO sistemadto = UtilSerializacionSistema.SistemaDTOFromSistema();
            idao.escribir(sistemadto);
            idao.cerrarOutput();
        } catch (Exception e)
        {
            System.out.println("Exception " + e.getMessage());
        }
        
        
        try
        {
            idao.abrirInput("sistemaSeguridad.xml");
            SistemaSeguridadDTO sistemaSeguridadDTO = (SistemaSeguridadDTO) idao.leer();
            UtilSerializacionSistema.sistemaFromSistemaSeguridadDTO(sistemaSeguridadDTO);
            idao.cerrarInput();
            System.out.println("Sistema Recuperado?: ");
            System.out.print(SistemaSeguridad.getSistema().generarReporte());   
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            System.out.println("Exception " + e.getMessage());
        }
        
        
        
    }


}



