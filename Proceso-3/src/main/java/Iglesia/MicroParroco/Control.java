package Iglesia.MicroParroco;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parroco")
public class Control {

    @Autowired
    private Servicio ser;

    @PostMapping("/reservas")
    public Reserva crearReserva(@RequestBody Reserva reserva) {
        return ser.grabarReserva(reserva);
    }

    @GetMapping("/reservas")
    public List<Reserva> listarReservas() {
        return ser.listarReservas();
    }

    @GetMapping("/reservas/{id}")
    public ResponseEntity<Reserva> buscarReserva(@PathVariable Long id) {
        Reserva reserva = ser.buscarReserva(id);
        return reserva == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(reserva);
    }

    @PostMapping("/alojamientos/abrir-ficha/{reservaId}")
    public ResponseEntity<Alojamiento> abrirFicha(@PathVariable Long reservaId) {
        Alojamiento ficha = ser.abrirFichaDesdeReserva(reservaId);
        return ficha == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(ficha);
    }

    @PostMapping("/alojamientos")
    public Alojamiento grabarAlojamiento(@RequestBody Alojamiento alojamiento) {
        return ser.grabarAlojamiento(alojamiento);
    }

    @GetMapping("/alojamientos")
    public List<Alojamiento> listarAlojamientos() {
        return ser.listarAlojamientos();
    }

    @GetMapping("/alojamientos/{id}")
    public ResponseEntity<Alojamiento> buscarAlojamiento(@PathVariable Long id) {
        Alojamiento alojamiento = ser.buscarAlojamiento(id);
        return alojamiento == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(alojamiento);
    }

    @PostMapping("/alojamientos/{id}/servicios")
    public ResponseEntity<ServicioDetalle> agregarServicio(
            @PathVariable Long id,
            @RequestBody ServicioDetalle servicio) {
        ServicioDetalle creado = ser.agregarServicio(id, servicio);
        return creado == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(creado);
    }

    @GetMapping("/alojamientos/{id}/servicios")
    public ResponseEntity<List<ServicioDetalle>> listarServicios(@PathVariable Long id) {
        Alojamiento alojamiento = ser.buscarAlojamiento(id);
        if (alojamiento == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ser.listarServiciosPorAlojamiento(id));
    }
}
