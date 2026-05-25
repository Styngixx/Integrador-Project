package Hotel.MicroFactura;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/factura")
public class Control {

    @Autowired
    private Servicio ser;

    @GetMapping("/grabar")
    public Factura grabar(@ModelAttribute Factura factura) {
        return ser.elaborarFactura(factura);
    }

    @PostMapping("/grabar")
    public Factura grabarPost(@RequestBody Factura factura) {
        return ser.elaborarFactura(factura);
    }

    @GetMapping("/listar")
    public List<Factura> listar() {
        return ser.listar();
    }

    @GetMapping("/buscar/{id}")
    public Factura buscar(@PathVariable Long id) {
        return ser.buscar(id);
    }

    @GetMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        ser.eliminar(id);
    }

    @GetMapping("/limpiar")
    public void limpiar() {
        ser.eliminarTodas();
    }
}
