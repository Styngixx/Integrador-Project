package Agencia.MicroBoleto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@JsonPropertyOrder({
    "id", "nombreCliente", "tipo", "ciudadOrigen", "ciudadDestino", 
    "fechaViaje", "numeroAsiento", "montoTotal", "montoPenalidad", 
    "estado", "fechaCompra"
})
public class Boleto {
    @Id
    private Long id;
    private String nombreCliente;
    private String tipo; // Puede ser "IDA" o "IDA_VUELTA"
    private String ciudadOrigen;
    private String ciudadDestino;
    private LocalDate fechaViaje;
    private int numeroAsiento;
    
    private double montoTotal; 
    private double montoPenalidad; 
    private String estado; 
    private LocalDateTime fechaCompra;

    public Boleto() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getCiudadOrigen() { return ciudadOrigen; }
    public void setCiudadOrigen(String ciudadOrigen) { this.ciudadOrigen = ciudadOrigen; }
    public String getCiudadDestino() { return ciudadDestino; }
    public void setCiudadDestino(String ciudadDestino) { this.ciudadDestino = ciudadDestino; }
    public LocalDate getFechaViaje() { return fechaViaje; }
    public void setFechaViaje(LocalDate fechaViaje) { this.fechaViaje = fechaViaje; }
    public int getNumeroAsiento() { return numeroAsiento; }
    public void setNumeroAsiento(int numeroAsiento) { this.numeroAsiento = numeroAsiento; }
    public double getMontoTotal() { return montoTotal; }
    public void setMontoTotal(double montoTotal) { this.montoTotal = montoTotal; }
    public double getMontoPenalidad() { return montoPenalidad; }
    public void setMontoPenalidad(double montoPenalidad) { this.montoPenalidad = montoPenalidad; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public LocalDateTime getFechaCompra() { return fechaCompra; }
    public void setFechaCompra(LocalDateTime fechaCompra) { this.fechaCompra = fechaCompra; }
}