package Agencia.MicroItinerario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Itinerario {
    @Id
    @GeneratedValue
    private Long id;
    private String ciudadOrigen;
    private String ciudadDestino;
    private LocalDate fechaViaje;
    private int asientosDisponibles;
    private double precioBase;

    public Itinerario() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCiudadOrigen() { return ciudadOrigen; }
    public void setCiudadOrigen(String ciudadOrigen) { this.ciudadOrigen = ciudadOrigen; }
    public String getCiudadDestino() { return ciudadDestino; }
    public void setCiudadDestino(String ciudadDestino) { this.ciudadDestino = ciudadDestino; }
    public LocalDate getFechaViaje() { return fechaViaje; }
    public void setFechaViaje(LocalDate fechaViaje) { this.fechaViaje = fechaViaje; }
    public int getAsientosDisponibles() { return asientosDisponibles; }
    public void setAsientosDisponibles(int asientosDisponibles) { this.asientosDisponibles = asientosDisponibles; }
    public double getPrecioBase() { return precioBase; }
    public void setPrecioBase(double precioBase) { this.precioBase = precioBase; }
}