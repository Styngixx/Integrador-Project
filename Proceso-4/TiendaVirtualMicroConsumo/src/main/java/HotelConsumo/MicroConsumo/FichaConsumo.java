package HotelConsumo.MicroConsumo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class FichaConsumo {
    @Id
    private Long id;
    private String numeroHabitacion;
    private String nombreServicio;
    private double precio;
    private LocalDateTime fechaHora;

    public FichaConsumo() {}
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNumeroHabitacion() { return numeroHabitacion; }
    public void setNumeroHabitacion(String numeroHabitacion) { this.numeroHabitacion = numeroHabitacion; }
    public String getNombreServicio() { return nombreServicio; }
    public void setNombreServicio(String nombreServicio) { this.nombreServicio = nombreServicio; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }
}