package Agencia.MicroBoleto;

import jakarta.persistence.Embeddable;

@Embeddable
public class DetalleBoleto {
    private String tipo;
    private int numeroAsiento;

    public DetalleBoleto() {}

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public int getNumeroAsiento() { return numeroAsiento; }
    public void setNumeroAsiento(int numeroAsiento) { this.numeroAsiento = numeroAsiento; }
}