package negocio;

public class PersonaJuridicaCloneException extends CloneNotSupportedException {
    String nombre;

    public PersonaJuridicaCloneException(String msg, String nombre) {
        super(msg);
        this.nombre = nombre;
    }

    public PersonaJuridicaCloneException(String nombre) {
        super();
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    @Override
    public String getMessage(){
        return "La factura contiene a la persona juridica " + this.nombre + ", no puede ser clonada";
    }
}
