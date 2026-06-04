package HotelConsumo.MicroConsumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Repositorio extends JpaRepository<FichaConsumo, Long> {
    @Query("SELECT COALESCE(MAX(f.id), 0) FROM FichaConsumo f")
    Long findMaxId();
}