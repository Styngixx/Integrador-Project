package HotelConsumo.MicroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/servicio")
public class Control {
    @Autowired private Repositorio r;
    @PostMapping("/agregar")
    public void agregar(@RequestBody ServicioHotel s) { r.save(s); }
    @GetMapping("/listar")
    public List<ServicioHotel> listar() { return r.findAll(); }
    
}