package HotelReserva.MicroHabitacion;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/habitacion")
public class Control {
    
    @Autowired
    private Repositorio r;
    
    @PostMapping("/agregar")
    public void agregar(@RequestBody Habitacion h) {
        r.save(h);
    }

    @GetMapping("/listar")
    public List<Habitacion> listar() {
        return r.findAll();
    }
}