package Agencia.MicroBoleto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Repositorio extends JpaRepository<Boleto, Long> {
    @Query("SELECT COALESCE(MAX(b.id), 0) FROM Boleto b")
    Long findMaxId();
}