package negocio;

import java.util.ArrayList;


public abstract class Contrataciones {
    /**
     * @aggregation composite
     */
    private ArrayList<ServiciosAdicionales> serviciosAdicionales = new ArrayList<ServiciosAdicionales>();
    private Promocion promo;
}
