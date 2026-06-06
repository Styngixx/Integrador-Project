package Agencia.MicroItinerario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repositorio extends JpaRepository<Itinerario, Long> {
}