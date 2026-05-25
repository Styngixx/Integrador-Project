package Iglesia.MicroParroco;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicioDetalleRepositorio extends JpaRepository<ServicioDetalle, Long> {
    List<ServicioDetalle> findByAlojamientoId(Long alojamientoId);
}
