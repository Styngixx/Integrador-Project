package HotelReserva.MicroReserva;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reserva")
public class Control {

    @Autowired
    private Servicio ser;

    @PostMapping("/crear")
    public Reserva crear(@RequestBody Reserva reserva) {
        return ser.crearReserva(reserva);
    }

    @PutMapping("/anular/{id}")
    public Reserva anular(@PathVariable Long id) {
        return ser.anularReserva(id);
    }

    @PutMapping("/retraso/{id}")
    public Reserva avisarRetraso(@PathVariable Long id) {
        return ser.avisarRetraso(id);
    }

    @GetMapping("/listar")
    public List<Reserva> listar() {
        return ser.listar();
    }
}