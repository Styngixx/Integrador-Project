package HotelReserva.MicroReserva;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
@JsonPropertyOrder({
    "id", "dniCliente", "nombreCliente", "direccionCliente", 
    "numeroHabitacion", "precioPorNoche", "fechaInicio", 
    "fechaFin", "montoPenalidad", "estado"
})
public class Reserva {
    @Id
    private Long id;
    private String dniCliente;
    private String nombreCliente;
    private String direccionCliente;
    private String numeroHabitacion;
    private double precioPorNoche;
    
    // Usamos LocalDateTime para poder calcular las 12 horas exactas
    private LocalDateTime fechaInicio; 
    private LocalDateTime fechaFin;
    
    private double montoPenalidad; 
    private String estado; // ACTIVA, ANULADA, RETRASO_AVISADO

    public Reserva() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDniCliente() { return dniCliente; }
    public void setDniCliente(String dniCliente) { this.dniCliente = dniCliente; }
    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }
    public String getDireccionCliente() { return direccionCliente; }
    public void setDireccionCliente(String direccionCliente) { this.direccionCliente = direccionCliente; }
    public String getNumeroHabitacion() { return numeroHabitacion; }
    public void setNumeroHabitacion(String numeroHabitacion) { this.numeroHabitacion = numeroHabitacion; }
    public double getPrecioPorNoche() { return precioPorNoche; }
    public void setPrecioPorNoche(double precioPorNoche) { this.precioPorNoche = precioPorNoche; }
    public LocalDateTime getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDateTime fechaInicio) { this.fechaInicio = fechaInicio; }
    public LocalDateTime getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDateTime fechaFin) { this.fechaFin = fechaFin; }
    public double getMontoPenalidad() { return montoPenalidad; }
    public void setMontoPenalidad(double montoPenalidad) { this.montoPenalidad = montoPenalidad; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}