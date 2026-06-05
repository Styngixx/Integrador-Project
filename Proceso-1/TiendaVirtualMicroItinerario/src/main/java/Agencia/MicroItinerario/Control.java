package Agencia.MicroItinerario;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/itinerario")
public class Control {
    
    @Autowired
    private Repositorio r;
    
    @PostMapping("/agregar")
    public void agregar(@RequestBody Itinerario i) {
        r.save(i);
    }

    @GetMapping("/listar")
    public List<Itinerario> listar() {
        return r.findAll();
    }
}