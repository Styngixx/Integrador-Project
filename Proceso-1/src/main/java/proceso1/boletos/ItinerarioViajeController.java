package proceso1.boletos;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/itinerarios")
public class ItinerarioViajeController {

    private final ItinerarioViajeRepositorio itinerarioRepositorio;
    private final BoletoViajeRepositorio boletoRepositorio;

    public ItinerarioViajeController(ItinerarioViajeRepositorio itinerarioRepositorio,
                                     BoletoViajeRepositorio boletoRepositorio) {
        this.itinerarioRepositorio = itinerarioRepositorio;
        this.boletoRepositorio = boletoRepositorio;
    }

    @PostMapping
    public ItinerarioViajeRespuesta crear(@RequestBody ItinerarioViaje itinerario) {
        return ItinerarioViajeRespuesta.de(itinerarioRepositorio.save(itinerario));
    }

    @GetMapping
    public List<ItinerarioViajeRespuesta> listar() {
        return itinerarioRepositorio.findAllByOrderByIdAsc().stream()
                .map(ItinerarioViajeRespuesta::de)
                .toList();
    }

    @GetMapping("/buscar")
    public List<Map<String, Object>> buscar(
            @RequestParam String origen,
            @RequestParam String destino,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha
    ) {
        List<ItinerarioViaje> itinerarios = itinerarioRepositorio
                .findByCiudadOrigenAndCiudadDestinoAndFechaViaje(origen, destino, fecha);

        return itinerarios.stream().map(it -> {
            long ocupados = boletoRepositorio
                    .findByItinerarioIdAndEstado(it.getId(), "ACTIVO")
                    .size();

            int disponibles = it.getCapacidadTotal() - (int) ocupados;

            Map<String, Object> dto = new LinkedHashMap<>();
            dto.put("id", it.getId());
            dto.put("origen", it.getCiudadOrigen());
            dto.put("destino", it.getCiudadDestino());
            dto.put("fechaViaje", it.getFechaViaje());
            dto.put("capacidadTotal", it.getCapacidadTotal());
            dto.put("asientosDisponibles", disponibles);
            return dto;
        }).toList();
    }
}
