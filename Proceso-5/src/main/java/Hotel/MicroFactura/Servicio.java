package Hotel.MicroFactura;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Servicio {

    @Autowired
    private Repositorio rep;

    public Factura elaborarFactura(Factura factura) {
        if (factura.getConsumos() == null) {
            factura.setConsumos(List.of());
        }

        long diasAlojamiento = ChronoUnit.DAYS.between(
                factura.getFechaInicioAlojamiento(),
                factura.getFechaFinAlojamiento());

        if (diasAlojamiento <= 0) {
            diasAlojamiento = 1;
        }

        BigDecimal precioDia = factura.getPrecioHabitacionDia() != null
                ? factura.getPrecioHabitacionDia()
                : BigDecimal.ZERO;

        BigDecimal totalAlojamiento = precioDia.multiply(BigDecimal.valueOf(diasAlojamiento));
        factura.setTotalAlojamiento(totalAlojamiento);

        BigDecimal totalConsumos = factura.getConsumos().stream()
                .map(Consumo::getImporte)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        factura.setImporteTotalGeneral(totalAlojamiento.add(totalConsumos));

        Long siguienteId = rep.findMaxId() + 1;
        factura.setId(siguienteId);

        for (Consumo consumo : factura.getConsumos()) {
            consumo.setFactura(factura);
        }

        return rep.save(factura);
    }

    public List<Factura> listar() {
        return rep.findAll();
    }

    public Factura buscar(Long id) {
        return rep.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        rep.deleteById(id);
    }

    public void eliminarTodas() {
        rep.deleteAll();
    }
}
