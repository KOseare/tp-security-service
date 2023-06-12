package negocio;

public class Recargo {
    private int porcentaje;
    public Recargo(int i) {
        this.porcentaje = i;
    }
    public String toString(){
        return "\nRecargo de " + porcentaje + "%";
    }

    double getPorcentaje() {
        return porcentaje * 0.01;
    }
}
