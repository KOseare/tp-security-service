package negocio;

import java.util.Random;

public class ServicioTecnicoRunnable implements Runnable{

    private Random rand = new Random();
    private ServicioTecnico servicioTecnico;
    //Observable controladorDeLaVista

    public ServicioTecnicoRunnable(ServicioTecnico servicioTecnico){
        this.servicioTecnico = servicioTecnico;
    }
    public void run() {
        
        //comunicacion con la interfaz
        //solicitando servicio tecnico
        try{
            Tecnico tecnico;
            tecnico = this.servicioTecnico.solicitarTecnico();//en caso de no haber tecnicos se queda esperando
          
            //usar controlador de la vista para representar los sucesos
            //visita del tecnico
            Thread.sleep(rand.nextInt(10000));
            //tecnico reparando...
            Thread.sleep(rand.nextInt(10000));
            //trabajo hecho regresando tecnico
            Thread.sleep(rand.nextInt(10000));
            this.servicioTecnico.agregarTecnico(tecnico);
            
        }catch(InterruptedException ie){
            //se interrumpio el proceso
        }
        
    }
    
    
    
}
