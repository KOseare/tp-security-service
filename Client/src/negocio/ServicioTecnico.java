package negocio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class ServicioTecnico {

    private ArrayList<Tecnico> tecnicos = new ArrayList<Tecnico>();

    public ServicioTecnico() {
    }

    public ServicioTecnico(ArrayList<Tecnico> tecnicos) {
        this.tecnicos = tecnicos;
    }

    public synchronized Tecnico solicitarTecnico() throws InterruptedException {
        Tecnico tecnico;

        while (tecnicos.isEmpty())
            wait();

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
