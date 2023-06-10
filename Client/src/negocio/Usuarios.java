package negocio;

public class Usuarios {
    private String usuario;
    private String clave;

    public Usuarios(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public String getClave() {
        return this.clave;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
