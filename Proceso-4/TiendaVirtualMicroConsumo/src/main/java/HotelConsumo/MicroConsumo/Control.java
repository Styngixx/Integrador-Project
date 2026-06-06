package HotelConsumo.MicroConsumo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consumo")
public class Control {
    @Autowired private ServicioConsumo ser;
    @PostMapping("/registrar")
    public FichaConsumo registrar(@RequestBody FichaConsumo f) { return ser.registrarConsumo(f); }
    @GetMapping("/listar")
    public java.util.List<FichaConsumo> listar() { return ser.listar(); }
}