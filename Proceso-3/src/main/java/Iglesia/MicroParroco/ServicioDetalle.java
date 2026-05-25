package Iglesia.MicroParroco;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.time.LocalDateTime;

@Entity
public class ServicioDetalle {
    @Id
    @GeneratedValue
    private Long id;
    private String tipoServicio;
    private String descripcion;
    private LocalDateTime fechaHora;
    private String referencia;

    @ManyToOne
    @JoinColumn(name = "alojamiento_id")
    @JsonBackReference
    private Alojamiento alojamiento;

    public ServicioDetalle() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Alojamiento getAlojamiento() {
        return alojamiento;
    }

    public void setAlojamiento(Alojamiento alojamiento) {
        this.alojamiento = alojamiento;
    }

    @PrePersist
    @PreUpdate
    public void generarReferencia() {
        if (alojamiento != null && fechaHora != null && alojamiento.getNumeroHabitacion() != null) {
            this.referencia = alojamiento.getNumeroHabitacion() + "-" + fechaHora.toString();
        }
    }
}
