package Hotel.MicroFactura;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/factura")
public class Control {

    @Autowired
    private Servicio ser;

    @PostMapping("/grabar")
    public Factura grabarPost(@RequestBody Factura factura) {
        return ser.elaborarFactura(factura);
    }

    @GetMapping("/listar")
    public List<Factura> listarTodas() {
        return ser.listar();
    }

    @GetMapping("/buscar/{id}")
    public Factura buscar(@PathVariable Long id) {
        return ser.buscar(id);
    }
}