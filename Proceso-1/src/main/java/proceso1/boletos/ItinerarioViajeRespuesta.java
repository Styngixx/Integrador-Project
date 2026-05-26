package proceso1.boletos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;

@JsonPropertyOrder({
        "id",
        "ciudadOrigen",
        "ciudadDestino",
        "fechaViaje",
        "capacidadTotal"
})
public class ItinerarioViajeRespuesta {

    private Long id;
    private String ciudadOrigen;
    private String ciudadDestino;
    private LocalDate fechaViaje;
    private Integer capacidadTotal;

    public static ItinerarioViajeRespuesta de(ItinerarioViaje itinerario) {
        ItinerarioViajeRespuesta respuesta = new ItinerarioViajeRespuesta();
        respuesta.id = itinerario.getId();
        respuesta.ciudadOrigen = itinerario.getCiudadOrigen();
        respuesta.ciudadDestino = itinerario.getCiudadDestino();
        respuesta.fechaViaje = itinerario.getFechaViaje();
        respuesta.capacidadTotal = itinerario.getCapacidadTotal();
        return respuesta;
    }

    public Long getId() {
        return id;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public LocalDate getFechaViaje() {
        return fechaViaje;
    }

    public Integer getCapacidadTotal() {
        return capacidadTotal;
    }
}
