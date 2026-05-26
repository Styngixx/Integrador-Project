package proceso1.boletos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoletoViajeRepositorio extends JpaRepository<BoletoViaje, Long> {

    @Query("SELECT b FROM BoletoViaje b LEFT JOIN FETCH b.itinerario ORDER BY b.id ASC")
    List<BoletoViaje> findAllConItinerarioOrdenados();

    List<BoletoViaje> findByItinerarioIdAndEstado(Long itinerarioId, String estado);
}

