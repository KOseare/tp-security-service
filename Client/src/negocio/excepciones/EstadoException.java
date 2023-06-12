package negocio.excepciones;

public class EstadoException extends Throwable{
    private String mensaje;
    public EstadoException(String string) {
        this.mensaje = string;
    }
    @Override
    public String getMessage(){
        return mensaje;
    }
}
