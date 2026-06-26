package HotelConsumo.MicroConsumo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consumo")
public class Control {

    @Autowired 
    private ServicioConsumo ser;

    @PostMapping("/registrar")
    public FichaConsumo registrar(@RequestBody FichaConsumo f) {
        return ser.registrarConsumo(f);
    }

    @GetMapping("/listar")
    public List<FichaConsumo> listar() {
        return ser.listar();
    }
    
    // Si este método te da el error, asegúrate de que esté bien implementado en el servicio
    @GetMapping("/buscar/{id}")
    public FichaConsumo buscar(@PathVariable Long id) {
        return ser.buscarPorId(id);
    }
}