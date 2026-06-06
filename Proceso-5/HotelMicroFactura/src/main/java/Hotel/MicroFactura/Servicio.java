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

        // 1. Calcula la cantidad de días dinámicamente
        long diasAlojamiento = ChronoUnit.DAYS.between(
                factura.getFechaInicioAlojamiento(),
                factura.getFechaFinAlojamiento());

        if (diasAlojamiento <= 0) {
            diasAlojamiento = 1;
        }

        BigDecimal precioDia = factura.getPrecioHabitacionDia() != null
                ? factura.getPrecioHabitacionDia()
                : BigDecimal.ZERO;

        // 2. Multiplica los días por el precio ingresado en el JSON
        BigDecimal totalAlojamiento = precioDia.multiply(BigDecimal.valueOf(diasAlojamiento));
        factura.setTotalAlojamiento(totalAlojamiento);

        // 3. Suma el total de todos los consumos que envíes
        BigDecimal totalConsumos = factura.getConsumos().stream()
                .map(Consumo::getImporte)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // 4. Calcula el Importe Total General
        factura.setImporteTotalGeneral(totalAlojamiento.add(totalConsumos));

        // 5. Genera el ID automáticamente sumando 1 al máximo actual
        Long siguienteId = rep.findMaxId() + 1;
        factura.setId(siguienteId);

        // 6. Vincula los consumos a la factura para la base de datos
        for (Consumo consumo : factura.getConsumos()) {
            consumo.setFactura(factura);
        }

        return rep.save(factura);
    }

    public List<Factura> listar() { return rep.findAll(); }
    public Factura buscar(Long id) { return rep.findById(id).orElse(null); }
    public void eliminar(Long id) { rep.deleteById(id); }
    public void eliminarTodas() { rep.deleteAll(); }
}