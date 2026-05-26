package proceso1.boletos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VistaBoletosController {

    private final ServicioVentaBoletos servicioVentaBoletos;

    public VistaBoletosController(ServicioVentaBoletos servicioVentaBoletos) {
        this.servicioVentaBoletos = servicioVentaBoletos;
    }

    @GetMapping("/")
    public List<BoletoViajeRespuesta> verBoletos() {
        return servicioVentaBoletos.listarBoletos();
    }
}
