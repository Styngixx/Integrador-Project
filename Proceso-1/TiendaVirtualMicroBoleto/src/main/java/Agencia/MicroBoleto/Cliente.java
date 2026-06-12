package Agencia.MicroBoleto;

import jakarta.persistence.Embeddable;

@Embeddable
public class Cliente {
    private String nombreCliente;

    public Cliente() {}

    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }
}