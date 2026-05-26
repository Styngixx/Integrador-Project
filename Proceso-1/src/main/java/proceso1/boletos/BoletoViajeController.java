package proceso1.boletos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/boletos")
public class BoletoViajeController {

    private final ServicioVentaBoletos servicioVentaBoletos;

    public BoletoViajeController(ServicioVentaBoletos servicioVentaBoletos) {
        this.servicioVentaBoletos = servicioVentaBoletos;
    }

    @GetMapping
    public List<BoletoViajeRespuesta> listar() {
        return servicioVentaBoletos.listarBoletos();
    }

    @PostMapping
    public BoletoViajeRespuesta crear(@RequestBody Map<String, Object> request) {
        String nombreCliente = (String) request.get("nombreCliente");
        String tipo = (String) request.get("tipo");
        Integer numeroAsiento = toInteger(request.get("numeroAsiento"));
        Number monto = (Number) request.get("montoTotal");
        Long itinerarioId = toLong(request.get("itinerarioId"));

        BigDecimal montoTotal = monto != null
                ? BigDecimal.valueOf(monto.doubleValue())
                : BigDecimal.ZERO;

        return servicioVentaBoletos.crearBoleto(
                nombreCliente,
                itinerarioId,
                tipo,
                numeroAsiento,
                montoTotal
        );
    }

    @PostMapping("/{id}/anular")
    public BoletoViajeRespuesta anular(@PathVariable Long id) {
        return servicioVentaBoletos.anularBoleto(id);
    }

    private Integer toInteger(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Number number) {
            return number.intValue();
        }
        return Integer.parseInt(value.toString());
    }

    private Long toLong(Object value) {
        if (value == null) {
            throw new IllegalArgumentException("itinerarioId es obligatorio");
        }
        if (value instanceof Number number) {
            return number.longValue();
        }
        return Long.parseLong(value.toString());
    }
}
