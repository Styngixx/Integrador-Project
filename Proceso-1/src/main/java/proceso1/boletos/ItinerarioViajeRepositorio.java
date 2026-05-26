package proceso1.boletos;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ItinerarioViajeRepositorio extends JpaRepository<ItinerarioViaje, Long> {

    List<ItinerarioViaje> findAllByOrderByIdAsc();

    List<ItinerarioViaje> findByCiudadOrigenAndCiudadDestinoAndFechaViaje(
            String ciudadOrigen,
            String ciudadDestino,
            LocalDate fechaViaje
    );
}

