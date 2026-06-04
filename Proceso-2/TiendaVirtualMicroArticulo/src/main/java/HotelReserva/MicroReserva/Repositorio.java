package HotelReserva.MicroReserva;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Repositorio extends JpaRepository<Reserva, Long> {
    @Query("SELECT COALESCE(MAX(r.id), 0) FROM Reserva r")
    Long findMaxId();
}