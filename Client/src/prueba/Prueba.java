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

import negocio.excepciones.SaldoInsuficienteExeception;

public class Prueba {
    public Prueba() {
        super();
    }

    public static void main(String[] args) {
        SistemaSeguridad sistema = SistemaSeguridad.getSistema();

        Promocion dorada = new Dorada();
        Promocion platino = new Platino();

        Persona personaFisica = new PersonaFisica("Juan", "42415305");
        Persona personaJuridica = new PersonaJuridica("Sancho", "25416352");

        Contratacion contratacionAuxiliar;
        ArrayList<Contratacion> contratos = new ArrayList<Contratacion>();

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
        sistema.generarFactura(new Date(122, 2, 3), personaFisica, contratacionAuxiliar);

        contratacionAuxiliar = new MonitoreoVivienda(personaFisica.getDomicilios().get(1)); //sin adicionales

        sistema.getFacturas()
               .get(0)
               .agregarContrato(contratacionAuxiliar);

        //persona juridica
        personaJuridica.agregarDomicilio(new Domicilio("Almirante Brown", "1542", "7602"));
        personaJuridica.agregarDomicilio(new Domicilio("Primera Junta", "1682", "7602"));
        personaJuridica.agregarDomicilio(new Domicilio("Rawson", "942", "7602"));
        personaJuridica.agregarDomicilio(new Domicilio("Ortis", "9652", "7602")); //con descuento

        contratacionAuxiliar = new MonitoreoComercio(personaJuridica.getDomicilios().get(0));
        contratacionAuxiliar.agregarServicioAdicional(new Camara(3));
        contratacionAuxiliar.setPromocion(platino);

        contratos.add(contratacionAuxiliar);

        contratacionAuxiliar = new MonitoreoVivienda(personaJuridica.getDomicilios().get(1));
        contratacionAuxiliar.agregarServicioAdicional(new MovilDeAcompaniamiento(LocalTime.of(9, 30),
                                                                                 LocalTime.of(13, 0)));
        contratacionAuxiliar.agregarServicioAdicional(new BotonAntiPanico(3));

        contratacionAuxiliar.setPromocion(platino);

        contratos.add(contratacionAuxiliar); //promo platino

        contratacionAuxiliar = new MonitoreoComercio(personaJuridica.getDomicilios().get(2));
        contratacionAuxiliar.agregarServicioAdicional(new BotonAntiPanico(1));
        contratacionAuxiliar.setPromocion(dorada);

        contratos.add(contratacionAuxiliar);

        contratacionAuxiliar = new MonitoreoVivienda(personaJuridica.getDomicilios().get(3));
        contratacionAuxiliar.agregarServicioAdicional(new BotonAntiPanico(3));
        contratacionAuxiliar.agregarServicioAdicional(new Camara(1));
        contratacionAuxiliar.setPromocion(dorada);

        contratos.add(contratacionAuxiliar);

        sistema.generarFactura(new Date(), personaJuridica, contratos);


        contratos.clear();

        personaFisica = new PersonaFisica("Pepito", "35214256");
        sistema.agregarCliente(personaFisica);
        personaFisica.agregarDomicilio(new Domicilio("Belgrano", "1512", "7602"));
        personaFisica.agregarDomicilio(new Domicilio("Almirante Brown", "1432", "7602"));
        personaFisica.agregarDomicilio(new Domicilio("Moreno", "8612", "7602"));
        personaFisica.agregarDomicilio(new Domicilio("Entre Rios", "8453", "7602"));


        contratacionAuxiliar = new MonitoreoComercio(personaFisica.getDomicilios().get(0));
        contratacionAuxiliar.setPromocion(platino);
        contratos.add(contratacionAuxiliar);


        contratacionAuxiliar = new MonitoreoVivienda(personaFisica.getDomicilios().get(1));
        contratacionAuxiliar.setPromocion(platino);
        contratacionAuxiliar.agregarServicioAdicional(new Camara(3));
        contratos.add(contratacionAuxiliar);

        contratacionAuxiliar = new MonitoreoVivienda(personaFisica.getDomicilios().get(2));
        contratacionAuxiliar.setPromocion(dorada);
        contratacionAuxiliar.agregarServicioAdicional(new Camara(1));
        contratacionAuxiliar.agregarServicioAdicional(new BotonAntiPanico(1));
        contratos.add(contratacionAuxiliar);

        contratacionAuxiliar = new MonitoreoComercio(personaFisica.getDomicilios().get(3));
        contratacionAuxiliar.setPromocion(dorada);
        contratacionAuxiliar.agregarServicioAdicional(new Camara(1));
        contratacionAuxiliar.agregarServicioAdicional(new BotonAntiPanico(6));
        contratacionAuxiliar.agregarServicioAdicional(new MovilDeAcompaniamiento(LocalTime.of(9, 30),
                                                                                 LocalTime.of(13, 0)));
        contratos.add(contratacionAuxiliar);


        sistema.generarFactura(new Date(), personaFisica, contratos);

        //pago de facturas
        MedioDePagoFactory mpf = new MedioDePagoFactory();

        IFactura facturaAPagar = mpf.getMedioDePago("Efectivo", sistema.getFacturas().get(2));

        System.out.print("Factura a pagar :" + facturaAPagar.detalle());

        try {
            facturaAPagar.pagarFactura(10000);
            System.out.print(" Factura Pagada");
        } catch (SaldoInsuficienteExeception e) {
            System.out.print(" No se pudo pagar la factura, faltan : " + (e.getValor() - e.getImporte()));
        }


        //clonacion de factura
        System.out.print("\n\n\nClonacion de Facturas: ");
        
        
        try { //no deberia poder clonarse por ser persona juridica?
            Factura f = (Factura) sistema.getFacturas()
                                         .get(1)
                                         .clone();
            System.out.print("\n\tClonacion Exitosa");
            
            facturaAPagar = mpf.getMedioDePago("Cheque", f); //apareceran 2 facturas, una pagada y otra no

            System.out.print("\n\tFactura a pagar :" + facturaAPagar.detalle());

            try {
                facturaAPagar.pagarFactura(100000);
                System.out.print(" Factura Pagada");
            } catch (SaldoInsuficienteExeception e) {
                System.out.print(" No se pudo pagar la factura, faltan : " + (e.getValor() - e.getImporte()));
            }

            sistema.agregarFactura(f);
        } catch (CloneNotSupportedException e) {
            System.out.print("No pudo clonarse");
        }
        try {
            Factura f = (Factura) sistema.getFacturas()
                                         .get(0)
                                         .clone();
            System.out.print("\nClonacion Exitosa");
            
            facturaAPagar = mpf.getMedioDePago("Tarjeta", f); //apareceran 2 facturas, una pagada y otra no

            System.out.print("\n\tFactura a pagar :" + facturaAPagar.detalle());

            try {
                facturaAPagar.pagarFactura(1000);
                System.out.print(" Factura Pagada");
            } catch (SaldoInsuficienteExeception e) {
                System.out.print(" No se pudo pagar la factura, faltan : " + (e.getValor() - e.getImporte()));
            }

            sistema.agregarFactura(f);
        } catch (CloneNotSupportedException e) {
            System.out.print("No pudo clonarse");
        }

        System.out.print("\n\n\nReporte de Facturas: \n");
        System.out.print(sistema.generarReporte());
    }


}


