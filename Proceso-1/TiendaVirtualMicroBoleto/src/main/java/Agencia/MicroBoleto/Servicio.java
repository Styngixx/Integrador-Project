package Agencia.MicroBoleto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Servicio {

    @Autowired
    private Repositorio rep;

    public Boleto comprarBoleto(Boleto boleto) {
        long diasParaViaje = ChronoUnit.DAYS.between(LocalDate.now(), boleto.getFechaViaje());
        if (diasParaViaje < 1) {
            throw new RuntimeException("Error: La compra debe realizarse al menos 1 día antes del viaje.");
        }

        boleto.setFechaCompra(LocalDateTime.now());
        boleto.setEstado("ACTIVO");
        boleto.setMontoPenalidad(0.0);

        Long siguienteId = rep.findMaxId() + 1;
        boleto.setId(siguienteId);

        return rep.save(boleto);
    }

    public Boleto anularBoleto(Long id, Boleto boletoModificado) {
    Boleto boleto = rep.findById(id).orElseThrow(() -> new RuntimeException("Boleto no encontrado"));

    if ("ANULADO".equals(boleto.getEstado())) {
        throw new RuntimeException("El boleto ya se encuentra anulado.");
    }

    // Mantenemos la validación de tiempo
    long diasParaViaje = ChronoUnit.DAYS.between(LocalDate.now(), boleto.getFechaViaje());
    if (diasParaViaje < 1) {
        throw new RuntimeException("Error: La anulación solo se permite hasta 1 día antes del viaje.");
    }
    
    // AQUÍ ESTÁ EL CAMBIO:
    // Si envías un monto distinto a 0, usamos el tuyo. Si no, calculamos el 6% por defecto.
    double penalidadFinal = (boletoModificado.getMontoPenalidad() > 0) 
                            ? boletoModificado.getMontoPenalidad() 
                            : (boleto.getMontoTotal() * 0.06);
    
    boleto.setEstado("ANULADO");
    boleto.setMontoPenalidad(penalidadFinal);

    return rep.save(boleto);
}

    public List<Boleto> listar() {
        return rep.findAll();
    }
    
    public void limpiarBaseDatos() {
        rep.deleteAll();
    }
}