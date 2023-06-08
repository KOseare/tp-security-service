package datos;

import java.util.ArrayList;

import negocio.*;


public class SistemaSeguridadDTO {
    private ArrayList<Persona> clientes = new ArrayList<Persona>();
    private ServicioTecnico serviciotecnico;


    public SistemaSeguridadDTO() {

    }

    public SistemaSeguridadDTO(ArrayList<Persona> clientes, ServicioTecnico serviciotecnico) {
        this.clientes = clientes;
        this.serviciotecnico = serviciotecnico;
    }


    public void setClientes(ArrayList<Persona> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Persona> getClientes() {
        return clientes;
    }

    public void setServiciotecnico(ServicioTecnico serviciotecnico) {
        this.serviciotecnico = serviciotecnico;
    }

    public ServicioTecnico getServiciotecnico() {
        return serviciotecnico;
    }
}
