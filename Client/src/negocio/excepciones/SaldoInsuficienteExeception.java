package negocio.excepciones;


public class SaldoInsuficienteExeception extends Throwable {
    
    private double valor;
    private double importe;

    public SaldoInsuficienteExeception(double valor,double importe){
        this.valor = valor;
        this.importe = importe;
    }

    public double getValor() {
        return valor;
    }

    public double getImporte() {
        return importe;
    }
}
