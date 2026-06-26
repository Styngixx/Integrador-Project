package Consumo.Vista.modelos;

public class Alojamiento {
    private Long idAlojamiento;
    private String numeroHabitacion;
    private String tipoHabitacion;

    public Alojamiento() {}

    public Long getIdAlojamiento() { return idAlojamiento; }
    public void setIdAlojamiento(Long idAlojamiento) { this.idAlojamiento = idAlojamiento; }
    public String getNumeroHabitacion() { return numeroHabitacion; }
    public void setNumeroHabitacion(String numeroHabitacion) { this.numeroHabitacion = numeroHabitacion; }
    public String getTipoHabitacion() { return tipoHabitacion; }
    public void setTipoHabitacion(String tipoHabitacion) { this.tipoHabitacion = tipoHabitacion; }
}