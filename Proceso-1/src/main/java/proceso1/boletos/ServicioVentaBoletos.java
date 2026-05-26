package proceso1.boletos;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServicioVentaBoletos {

    private final BoletoViajeRepositorio boletoRepositorio;
    private final ItinerarioViajeRepositorio itinerarioRepositorio;

    public ServicioVentaBoletos(BoletoViajeRepositorio boletoRepositorio,
                                  ItinerarioViajeRepositorio itinerarioRepositorio) {
        this.boletoRepositorio = boletoRepositorio;
        this.itinerarioRepositorio = itinerarioRepositorio;
    }

    public List<ItinerarioViaje> buscarItinerarios(String origen, String destino, LocalDate fechaViaje) {
        return itinerarioRepositorio.findByCiudadOrigenAndCiudadDestinoAndFechaViaje(origen, destino, fechaViaje);
    }

    @Transactional(readOnly = true)
    public List<BoletoViajeRespuesta> listarBoletos() {
        return boletoRepositorio.findAllConItinerarioOrdenados().stream()
                .map(BoletoViajeRespuesta::de)
                .toList();
    }

    @Transactional
    public BoletoViajeRespuesta crearBoleto(String nombreCliente,
                                            Long itinerarioId,
                                            String tipo,
                                            Integer numeroAsiento,
                                            BigDecimal montoTotal) {

        ItinerarioViaje itinerario = itinerarioRepositorio.findById(itinerarioId)
                .orElseThrow(() -> new IllegalArgumentException("Itinerario no encontrado"));

        LocalDate hoy = LocalDate.now();
        LocalDate fechaViaje = itinerario.getFechaViaje();

        // Compra hasta 1 día antes del viaje
        LocalDate ultimoDiaCompra = fechaViaje.minusDays(1);
        if (hoy.isAfter(ultimoDiaCompra)) {
            throw new IllegalStateException("Los boletos solo pueden comprarse hasta 1 día antes del viaje");
        }

        if (numeroAsiento == null
                || numeroAsiento < 1
                || numeroAsiento > itinerario.getCapacidadTotal()) {
            throw new IllegalArgumentException("Número de asiento inválido para este itinerario");
        }

        boolean asientoOcupado = boletoRepositorio.findByItinerarioIdAndEstado(itinerarioId, "ACTIVO").stream()
                .anyMatch(b -> numeroAsiento.equals(b.getNumeroAsiento()));

        if (asientoOcupado) {
            throw new IllegalStateException("El asiento ya está ocupado para este itinerario");
        }

        BoletoViaje boleto = new BoletoViaje();
        boleto.setNombreCliente(nombreCliente);
        boleto.setItinerario(itinerario);
        boleto.setTipo(tipo);
        boleto.setNumeroAsiento(numeroAsiento);
        boleto.setFechaViaje(fechaViaje);
        boleto.setFechaCompra(LocalDateTime.now());
        boleto.setMontoTotal(montoTotal);
        boleto.setMontoPenalidad(BigDecimal.ZERO);
        boleto.setEstado("ACTIVO");

        return BoletoViajeRespuesta.de(boletoRepositorio.save(boleto));
    }

    @Transactional
    public BoletoViajeRespuesta anularBoleto(Long id) {
        BoletoViaje boleto = boletoRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Boleto no encontrado"));

        LocalDate hoy = LocalDate.now();
        LocalDate fechaViaje = boleto.getFechaViaje();

        // Anulación hasta 1 día antes del viaje
        LocalDate ultimoDiaAnulacion = fechaViaje.minusDays(1);
        if (hoy.isAfter(ultimoDiaAnulacion)) {
            throw new IllegalStateException("Solo se puede anular hasta 1 día antes del viaje");
        }

        if ("ANULADO".equalsIgnoreCase(boleto.getEstado())) {
            return BoletoViajeRespuesta.de(boleto);
        }

        // Penalidad 6% de la operación
        BigDecimal penalidad = boleto.getMontoTotal()
                .multiply(new BigDecimal("0.06"))
                .setScale(2, RoundingMode.HALF_UP);

        boleto.setMontoPenalidad(penalidad);
        boleto.setEstado("ANULADO");

        return BoletoViajeRespuesta.de(boletoRepositorio.save(boleto));
    }
}

