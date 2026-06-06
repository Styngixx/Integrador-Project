package Hotel.MicroFactura;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@JsonPropertyOrder({"descripcion", "importe", "id"})
public class Consumo {

    @Id
    @GeneratedValue
    private Long id;
    private String descripcion;
    private BigDecimal importe;

    @ManyToOne
    @JoinColumn(name = "factura_id")
    @JsonIgnore
    private Factura factura;

    public Consumo() {}

    public Consumo(String descripcion, BigDecimal importe) {
        this.descripcion = descripcion;
        this.importe = importe;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public BigDecimal getImporte() { return importe; }
    public void setImporte(BigDecimal importe) { this.importe = importe; }
    public Factura getFactura() { return factura; }
    public void setFactura(Factura factura) { this.factura = factura; }
}