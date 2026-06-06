package HotelReserva.MicroReserva;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Servicio {

    @Autowired
    private Repositorio rep;

    public Reserva crearReserva(Reserva reserva) {
        reserva.setEstado("ACTIVA");
        reserva.setMontoPenalidad(0.0);

        Long siguienteId = rep.findMaxId() + 1;
        reserva.setId(siguienteId);

        return rep.save(reserva);
    }

    public Reserva anularReserva(Long id) {
        Reserva reserva = rep.findById(id).orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        if (!"ACTIVA".equals(reserva.getEstado())) {
            throw new RuntimeException("La reserva ya fue anulada o modificada.");
        }

        // Regla: Solo puede anularse con más de 12 horas de anticipación
        long horasParaCheckIn = ChronoUnit.HOURS.between(LocalDateTime.now(), reserva.getFechaInicio());
        
        if (horasParaCheckIn <= 12) {
            throw new RuntimeException("Error: Las anulaciones solo pueden hacerse 12 horas antes de la fecha prevista.");
        }
        
        reserva.setEstado("ANULADA");
        return rep.save(reserva);
    }

    public Reserva avisarRetraso(Long id) {
        Reserva reserva = rep.findById(id).orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        if (!"ACTIVA".equals(reserva.getEstado())) {
            throw new RuntimeException("Solo se puede avisar retraso en reservas ACTIVAS.");
        }

        // Regla: El cliente avisa que llegará tarde. Para no perder la reserva, se le cobra la 1ra noche.
        reserva.setEstado("RETRASO_AVISADO");
        reserva.setMontoPenalidad(reserva.getPrecioPorNoche()); // Se cobra 1 noche de penalidad

        return rep.save(reserva);
    }

    public List<Reserva> listar() {
        return rep.findAll();
    }
}