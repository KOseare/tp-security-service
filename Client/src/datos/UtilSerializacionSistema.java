package datos;

import negocio.SistemaSeguridad;

public class UtilSerializacionSistema {
    public UtilSerializacionSistema() {
        super();
    }
    
    public static SistemaSeguridadDTO SistemaDTOFromSistema() 
    {
        SistemaSeguridadDTO respuesta = new SistemaSeguridadDTO();
        respuesta.setClientes(SistemaSeguridad.getSistema().getClientes());
        respuesta.setServiciotecnico(SistemaSeguridad.getSistema().getServiciotecnico());
        return respuesta;
    }
    
    public static void sistemaFromSistemaSeguridadDTO(SistemaSeguridadDTO sistemaSeguridadDTO) 
    {
        SistemaSeguridad.getSistema().setClientes(sistemaSeguridadDTO.getClientes());
        SistemaSeguridad.getSistema().setServiciotecnico(sistemaSeguridadDTO.getServiciotecnico());
    }
}
