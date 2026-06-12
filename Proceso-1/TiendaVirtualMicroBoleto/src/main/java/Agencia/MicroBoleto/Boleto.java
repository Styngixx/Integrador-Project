package Agencia.MicroBoleto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@JsonPropertyOrder({ "id", "cliente", "empleado", "boleto", "itinerario", "montoTotal", "montoPenalidad", "estado", "fechaCompra" })
public class Boleto {
    
    @Id 
    private Long id;

    @Embedded private Cliente cliente;
    @Embedded private Empleado empleado;
    @Embedded private DetalleBoleto boleto; 
    @Embedded private ItinerarioAdquirido itinerario;

    private double montoTotal;
    private double montoPenalidad;
    private String estado;
    private LocalDateTime fechaCompra;

    public Boleto() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    
    public Empleado getEmpleado() { return empleado; }
    public void setEmpleado(Empleado empleado) { this.empleado = empleado; }
    
    public DetalleBoleto getBoleto() { return boleto; }
    public void setBoleto(DetalleBoleto boleto) { this.boleto = boleto; }
    
    public ItinerarioAdquirido getItinerario() { return itinerario; }
    public void setItinerario(ItinerarioAdquirido itinerario) { this.itinerario = itinerario; }
    
    public double getMontoTotal() { return montoTotal; }
    public void setMontoTotal(double montoTotal) { this.montoTotal = montoTotal; }
    
    public double getMontoPenalidad() { return montoPenalidad; }
    public void setMontoPenalidad(double montoPenalidad) { this.montoPenalidad = montoPenalidad; }
    
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    
    public LocalDateTime getFechaCompra() { return fechaCompra; }
    public void setFechaCompra(LocalDateTime fechaCompra) { this.fechaCompra = fechaCompra; }
}