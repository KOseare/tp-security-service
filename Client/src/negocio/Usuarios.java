package negocio;

public class Usuarios {
    private String usuario;
    private String clave;
    private Persona persona;

    public Usuarios(String usuario, String clave, Persona persona) {
        this.usuario = usuario;
        this.clave = clave;
        this.persona = persona;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public String getClave() {
        return this.clave;
    }

    public Persona getPersona() {
        return this.persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
