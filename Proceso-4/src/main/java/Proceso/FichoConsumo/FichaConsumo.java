package Proceso.FichoConsumo;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class FichaConsumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String numeroHabitacion;
    private LocalDateTime fechaHora;
    private Double totalCalculado;

    // Permite guardar múltiples servicios elegidos por el cliente
    @ElementCollection
    @CollectionTable(name = "servicios_consumidos", joinColumns = @JoinColumn(name = "ficha_id"))
    private List<ItemServicio> servicios;

    public FichaConsumo() {}

    // Genera la fecha y hora automáticamente antes de guardar en la BD
    @PrePersist
    public void asignarFecha() {
        this.fechaHora = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNumeroHabitacion() { return numeroHabitacion; }
    public void setNumeroHabitacion(String numeroHabitacion) { this.numeroHabitacion = numeroHabitacion; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }
    public Double getTotalCalculado() { return totalCalculado; }
    public void setTotalCalculado(Double totalCalculado) { this.totalCalculado = totalCalculado; }
    public List<ItemServicio> getServicios() { return servicios; }
    public void setServicios(List<ItemServicio> servicios) { this.servicios = servicios; }
}