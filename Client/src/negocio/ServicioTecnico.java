package negocio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class ServicioTecnico {

    private ArrayList<Tecnico> tecnicos = new ArrayList<>();

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

        return tecnico;
    }

    public void agregarTecnico(Tecnico T) throws InterruptedException {
        tecnicos.add(T);
        notify();
    }

    public void setTecnicos(ArrayList<Tecnico> tecnicos) {
        this.tecnicos = tecnicos;
    }

    public ArrayList<Tecnico> getTecnicos() {
        return tecnicos;
    }

}
