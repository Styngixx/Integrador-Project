package Hotel.MicroFactura;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonPropertyOrder({
    "id",
    "numeroFactura",
    "fechaFactura",
    "nombreCliente",
    "direccionCliente",
    "dniCliente",
    "fechaInicioAlojamiento",
    "fechaFinAlojamiento",
    "precioHabitacionDia",
    "totalAlojamiento",
    "consumos",
    "importeTotalGeneral"
})
public class Factura {

    @Id
    private Long id;

    private String numeroFactura;
    private LocalDate fechaFactura;

    private String nombreCliente;
    private String direccionCliente;
    private String dniCliente;

    private LocalDate fechaInicioAlojamiento;
    private LocalDate fechaFinAlojamiento;
    private BigDecimal precioHabitacionDia;
    private BigDecimal totalAlojamiento;

    private BigDecimal importeTotalGeneral;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consumo> consumos = new ArrayList<>();

    public Factura() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public LocalDate getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(LocalDate fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public LocalDate getFechaInicioAlojamiento() {
        return fechaInicioAlojamiento;
    }

    public void setFechaInicioAlojamiento(LocalDate fechaInicioAlojamiento) {
        this.fechaInicioAlojamiento = fechaInicioAlojamiento;
    }

    public LocalDate getFechaFinAlojamiento() {
        return fechaFinAlojamiento;
    }

    public void setFechaFinAlojamiento(LocalDate fechaFinAlojamiento) {
        this.fechaFinAlojamiento = fechaFinAlojamiento;
    }

    public BigDecimal getPrecioHabitacionDia() {
        return precioHabitacionDia;
    }

    public void setPrecioHabitacionDia(BigDecimal precioHabitacionDia) {
        this.precioHabitacionDia = precioHabitacionDia;
    }

    public BigDecimal getTotalAlojamiento() {
        return totalAlojamiento;
    }

    public void setTotalAlojamiento(BigDecimal totalAlojamiento) {
        this.totalAlojamiento = totalAlojamiento;
    }

    public BigDecimal getImporteTotalGeneral() {
        return importeTotalGeneral;
    }

    public void setImporteTotalGeneral(BigDecimal importeTotalGeneral) {
        this.importeTotalGeneral = importeTotalGeneral;
    }

    public List<Consumo> getConsumos() {
        return consumos;
    }

    public void setConsumos(List<Consumo> consumos) {
        this.consumos = consumos;
    }
}
