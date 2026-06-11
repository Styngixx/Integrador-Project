/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProcesoAlojamiento.MicroAlojamiento;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "numeroAlojamiento",
    "fecha",
    "empleado",
    "reserva",
    "total"
})
public class AlojamientoDetalle {
    
    private Long    numeroAlojamiento;
    private String fecha;
    private Empleado empleado;
    private Reserva reserva;
    private double total;

    public AlojamientoDetalle() {
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

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}