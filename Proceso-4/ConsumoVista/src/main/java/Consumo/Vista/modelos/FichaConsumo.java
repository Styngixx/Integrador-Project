package Consumo.Vista.modelos;

import java.util.ArrayList;
import java.util.List;

public class FichaConsumo {
    private Long id;
    private double importeTotal;
    
    // Instanciamos para evitar nulos
    private Empleado empleado = new Empleado();
    private Alojamiento alojamiento = new Alojamiento();
    private Carrito carrito = new Carrito();
    private List<ServicioAdquirido> servicios = new ArrayList<>();

    public FichaConsumo() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public double getImporteTotal() { return importeTotal; }
    public void setImporteTotal(double importeTotal) { this.importeTotal = importeTotal; }
    public Empleado getEmpleado() { return empleado; }
    public void setEmpleado(Empleado empleado) { this.empleado = empleado; }
    public Alojamiento getAlojamiento() { return alojamiento; }
    public void setAlojamiento(Alojamiento alojamiento) { this.alojamiento = alojamiento; }
    public Carrito getCarrito() { return carrito; }
    public void setCarrito(Carrito carrito) { this.carrito = carrito; }
    public List<ServicioAdquirido> getServicios() { return servicios; }
    public void setServicios(List<ServicioAdquirido> servicios) { this.servicios = servicios; }
}