
package ProcesoAlojamiento.MicroAlojamiento;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Alojamiento {
  @Id
  @GeneratedValue

   private Long numeroAlojamiento;
    private String fecha;
    private Long idEmpleado;
    private Long idReserva;
    private double total;

    public Alojamiento() {
    }

    public Alojamiento(Long numeroAlojamiento, String fecha, Long idEmpleado, Long idReserva, double total) {
        this.numeroAlojamiento = numeroAlojamiento;
        this.fecha = fecha;
        this.idEmpleado = idEmpleado;
        this.idReserva = idReserva;
        this.total = total;
    }

    public Long getNumeroAlojamiento() {
        return numeroAlojamiento;
    }

    public void setNumeroAlojamiento(Long numeroAlojamiento) {
        this.numeroAlojamiento = numeroAlojamiento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}