package Agencia.MicroBoleto;

import jakarta.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class ItinerarioAdquirido {
    private String ciudadOrigen;
    private String ciudadDestino;
    private LocalDate fechaViaje;

    public ItinerarioAdquirido() {}

    public String getCiudadOrigen() { return ciudadOrigen; }
    public void setCiudadOrigen(String ciudadOrigen) { this.ciudadOrigen = ciudadOrigen; }
    public String getCiudadDestino() { return ciudadDestino; }
    public void setCiudadDestino(String ciudadDestino) { this.ciudadDestino = ciudadDestino; }
    public LocalDate getFechaViaje() { return fechaViaje; }
    public void setFechaViaje(LocalDate fechaViaje) { this.fechaViaje = fechaViaje; }
}