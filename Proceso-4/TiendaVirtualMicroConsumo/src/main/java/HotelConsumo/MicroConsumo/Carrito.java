package HotelConsumo.MicroConsumo;
import jakarta.persistence.Embeddable;

@Embeddable
public class Carrito {
    private Long idCarrito;
    private String descripcionCarrito;
    public Carrito() {}
    public Long getIdCarrito() { return idCarrito; }
    public void setIdCarrito(Long idCarrito) { this.idCarrito = idCarrito; }
    public String getDescripcionCarrito() { return descripcionCarrito; }
    public void setDescripcionCarrito(String descripcionCarrito) { this.descripcionCarrito = descripcionCarrito; }
}