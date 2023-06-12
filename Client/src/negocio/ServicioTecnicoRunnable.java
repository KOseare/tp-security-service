package negocio;

import java.util.Random;

import presentacion.MainControlador;

public class ServicioTecnicoRunnable implements Runnable {

    private Random rand = new Random();
    private ServicioTecnico servicioTecnico;
    private MainControlador observer;
    //Observable controladorDeLaVista
    
    
    
    public ServicioTecnicoRunnable(ServicioTecnico servicioTecnico, MainControlador observer) {
        this.servicioTecnico = servicioTecnico;
        this.setObserver(observer);
    }

    public void setObserver(MainControlador observer) {
        this.observer = observer;
    }

    public void run() {

        try {
            Tecnico tecnico;
            tecnico =
                this.servicioTecnico.solicitarTecnico(this.observer); //en caso de no haber tecnicos se queda esperando

            observer.comunicarConsolaTecnico("Se solicito al Tecnico: " + tecnico.getNombre());
            Thread.sleep(rand.nextInt(5000));
            observer.comunicarConsolaTecnico("El tecnico " + tecnico.getNombre() +
                                             " llego a la casa, tecnico reparando...");
            Thread.sleep(rand.nextInt(5000));
            observer.comunicarConsolaTecnico("trabajo hecho,tecnico " + tecnico.getNombre() + " regresando ");
            Thread.sleep(rand.nextInt(5000));
            this.servicioTecnico.agregarTecnico(tecnico);
            observer.comunicarConsolaTecnico("Tecnico " + tecnico.getNombre() + " regresado");

        } catch (InterruptedException ie) {
            
            observer.comunicarConsolaTecnico("Se interrumpio el Proceso");
            
        }

    }


}
