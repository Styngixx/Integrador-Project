package Proceso.FichoConsumo;

import jakarta.persistence.Embeddable;

@Embeddable
public class ItemServicio {
    
    private String nombre; // Ej: Teléfono, Desayuno, Lavandería
    private Double precio;
    private Integer cantidad;

    public ItemServicio() {}

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }
    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
}