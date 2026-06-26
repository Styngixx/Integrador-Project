package HotelConsumo.MicroConsumo;
import jakarta.persistence.Embeddable;

@Embeddable
public class Empleado {
    private Long idEmpleado;
    private String nombres;
    private String apellidos;
    private String cargo; // Nuevo campo

    public Empleado() {}

    public Long getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(Long idEmpleado) { this.idEmpleado = idEmpleado; }
    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public String getCargo() { return cargo; } // Nuevo getter
    public void setCargo(String cargo) { this.cargo = cargo; } // Nuevo setter
}