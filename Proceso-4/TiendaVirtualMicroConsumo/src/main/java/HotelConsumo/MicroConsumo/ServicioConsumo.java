package HotelConsumo.MicroConsumo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServicioConsumo {
    @Autowired private Repositorio r;

    public FichaConsumo registrarConsumo(FichaConsumo ficha) {
        ficha.setFechaHora(LocalDateTime.now());
        ficha.setId(r.findMaxId() + 1);
        return r.save(ficha);
    }
    public List<FichaConsumo> listar() { return r.findAll(); }
}