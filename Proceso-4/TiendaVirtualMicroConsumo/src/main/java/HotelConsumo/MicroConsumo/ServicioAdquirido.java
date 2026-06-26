package HotelConsumo.MicroConsumo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class ServicioAdquirido {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore private Long idInterno;
    private Long id;
    private String nombre;
    private double precio;
    public ServicioAdquirido() {}
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
}