package Hotel.MicroFactura;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repositorio extends JpaRepository<Articulo, Long> {
    
}