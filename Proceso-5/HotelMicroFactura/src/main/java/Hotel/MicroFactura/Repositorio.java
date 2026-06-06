package Hotel.MicroFactura;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Repositorio extends JpaRepository<Factura, Long> {
    @Query("SELECT COALESCE(MAX(f.id), 0) FROM Factura f")
    Long findMaxId();
}