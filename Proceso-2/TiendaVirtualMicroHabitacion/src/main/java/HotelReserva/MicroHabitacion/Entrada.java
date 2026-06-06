
package HotelReserva.MicroHabitacion;

public class Entrada {
    private Long idArt;
    private int can;

    public Entrada() {
    }

    public Entrada(Long idArt, int can) {
        this.idArt = idArt;
        this.can = can;
    }

    public Long getIdArt() {
        return idArt;
    }

    public void setIdArt(Long idArt) {
        this.idArt = idArt;
    }

    public int getCan() {
        return can;
    }

    public void setCan(int can) {
        this.can = can;
    }
    
}
