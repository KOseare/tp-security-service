package negocio;

import diagrama.Domicilio;

import java.util.ArrayList;


public abstract class Persona {
    /**
     * @aggregation shared
     */
    private String nombre,dni;
    /**
     * @aggregation shared
     */
    private Contratacion contrato;
    /**
     * @aggregation shared
     */
    private Factura factura;

    /**
     * @aggregation composite
     */
    private ArrayList<Domicilio> domicilios;
}
