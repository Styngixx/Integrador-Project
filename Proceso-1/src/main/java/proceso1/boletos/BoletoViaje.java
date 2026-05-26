package proceso1.boletos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class BoletoViaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCliente;
    private String tipo; // "IDA" o "IDA_VUELTA"
    private Integer numeroAsiento;
    private LocalDate fechaViaje;
    private LocalDateTime fechaCompra;

    private BigDecimal montoTotal;
    private BigDecimal montoPenalidad;
    private String estado; // "ACTIVO" o "ANULADO"

    @ManyToOne
    private ItinerarioViaje itinerario;

    public BoletoViaje() {
    }

    public Long getId() {
        return id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(Integer numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public LocalDate getFechaViaje() {
        return fechaViaje;
    }

    public void setFechaViaje(LocalDate fechaViaje) {
        this.fechaViaje = fechaViaje;
    }

    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }

    public BigDecimal getMontoPenalidad() {
        return montoPenalidad;
    }

    public void setMontoPenalidad(BigDecimal montoPenalidad) {
        this.montoPenalidad = montoPenalidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ItinerarioViaje getItinerario() {
        return itinerario;
    }

    public void setItinerario(ItinerarioViaje itinerario) {
        this.itinerario = itinerario;
    }
}

