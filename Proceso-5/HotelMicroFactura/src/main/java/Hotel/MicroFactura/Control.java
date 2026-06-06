package Hotel.MicroFactura;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/factura")
public class Control {

    @Autowired
    private Servicio ser;

    @PostMapping("/grabar")
    public FacturaResponse grabarPost(@RequestBody Factura factura) {
        // Se guarda normal usando tu Servicio y luego se empaqueta en el Response
        Factura f = ser.elaborarFactura(factura);
        return new FacturaResponse(f);
    }

    @GetMapping("/listar")
    public List<FacturaResponse> listarTodas() {
        // Convertimos la lista de Facturas planas a la nueva lista estructurada
        return ser.listar().stream()
                .map(FacturaResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/buscar/{id}")
    public FacturaResponse buscar(@PathVariable Long id) {
        Factura f = ser.buscar(id);
        return f != null ? new FacturaResponse(f) : null;
    }
}