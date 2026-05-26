package proceso1.boletos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@JsonPropertyOrder({
        "id",
        "nombreCliente",
        "tipo",
        "ciudadOrigen",
        "ciudadDestino",
        "fechaViaje",
        "numeroAsiento",
        "montoTotal",
        "montoPenalidad",
        "estado",
        "fechaCompra",
        "itinerarioId"
})
public class BoletoViajeRespuesta {

    private Long id;
    private String nombreCliente;
    private String tipo;
    private String ciudadOrigen;
    private String ciudadDestino;
    private LocalDate fechaViaje;
    private Integer numeroAsiento;
    private BigDecimal montoTotal;
    private BigDecimal montoPenalidad;
    private String estado;
    private LocalDateTime fechaCompra;
    private Long itinerarioId;

    public static BoletoViajeRespuesta de(BoletoViaje boleto) {
        BoletoViajeRespuesta respuesta = new BoletoViajeRespuesta();
        respuesta.id = boleto.getId();
        respuesta.nombreCliente = boleto.getNombreCliente();
        respuesta.tipo = boleto.getTipo();
        respuesta.fechaViaje = boleto.getFechaViaje();
        respuesta.numeroAsiento = boleto.getNumeroAsiento();
        respuesta.montoTotal = boleto.getMontoTotal();
        respuesta.montoPenalidad = boleto.getMontoPenalidad();
        respuesta.estado = boleto.getEstado();
        respuesta.fechaCompra = boleto.getFechaCompra();

        if (boleto.getItinerario() != null) {
            respuesta.ciudadOrigen = boleto.getItinerario().getCiudadOrigen();
            respuesta.ciudadDestino = boleto.getItinerario().getCiudadDestino();
            respuesta.itinerarioId = boleto.getItinerario().getId();
        }

        return respuesta;
    }

    public Long getId() {
        return id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getTipo() {
        return tipo;
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

    public Integer getNumeroAsiento() {
        return numeroAsiento;
    }

    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    public BigDecimal getMontoPenalidad() {
        return montoPenalidad;
    }

    public String getEstado() {
        return estado;
    }

    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }

    public Long getItinerarioId() {
        return itinerarioId;
    }
}
