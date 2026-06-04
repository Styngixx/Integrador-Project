package HotelReserva.MicroHabitacion;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Habitacion {
    @Id
    @GeneratedValue
    private Long id;
    private String numeroHabitacion;
    private String tipo; // "Simple", "Doble", "Matrimonial"
    private double precioPorNoche;

    public Habitacion() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNumeroHabitacion() { return numeroHabitacion; }
    public void setNumeroHabitacion(String numeroHabitacion) { this.numeroHabitacion = numeroHabitacion; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public double getPrecioPorNoche() { return precioPorNoche; }
    public void setPrecioPorNoche(double precioPorNoche) { this.precioPorNoche = precioPorNoche; }
}