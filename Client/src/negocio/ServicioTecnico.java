package negocio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

import presentacion.MainControlador;

public class ServicioTecnico {

    private ArrayList<Tecnico> tecnicos = new ArrayList<Tecnico>();

    public ServicioTecnico() {
    }

    public ServicioTecnico(ArrayList<Tecnico> tecnicos) {
        this.tecnicos = tecnicos;
    }

    public synchronized Tecnico solicitarTecnico(MainControlador observer) throws InterruptedException {
        Tecnico tecnico;

        while (tecnicos.isEmpty()) {
            observer.comunicarConsolaTecnico("No hay tecnicos disponibles, se solicitara automaticamente cuando se tenga disponibilidad");
            wait();
        }


        tecnico = tecnicos.get(0);
        tecnicos.remove(0);
        notifyAll();

        return tecnico;
    }

    public synchronized void agregarTecnico(Tecnico T) {
        tecnicos.add(T);
        notifyAll();
    }

    public void setTecnicos(ArrayList<Tecnico> tecnicos) {
        this.tecnicos = tecnicos;
    }

    public ArrayList<Tecnico> getTecnicos() {
        return tecnicos;
    }

}
