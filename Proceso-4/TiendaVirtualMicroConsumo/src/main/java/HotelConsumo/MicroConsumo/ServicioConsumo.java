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

        double total = 0;
        if (ficha.getServicios() != null) {
            for (ServicioAdquirido s : ficha.getServicios()) {
                total += s.getPrecio();
            }
        }
        ficha.setImporteTotal(total);
        return r.save(ficha);
    }

    public List<FichaConsumo> listar() { 
        return r.findAll(); 
    }

    public FichaConsumo buscarPorId(Long id) {
        // Asegúrate de que esto sea r.findById y no un throw exception
        return r.findById(id).orElse(null);
    }
}