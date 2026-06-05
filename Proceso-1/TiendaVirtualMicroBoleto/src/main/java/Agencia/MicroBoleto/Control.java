package Agencia.MicroBoleto;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boleto")
public class Control {

    @Autowired
    private Servicio ser;

    @PostMapping("/comprar")
    public Boleto comprar(@RequestBody Boleto boleto) {
        return ser.comprarBoleto(boleto);
    }

    @PutMapping("/anular/{id}")
public Boleto anular(@PathVariable Long id, @RequestBody Boleto boletoModificado) {
    return ser.anularBoleto(id, boletoModificado);
}

    @GetMapping("/listar")
    public List<Boleto> listar() {
        return ser.listar();
    }

    @DeleteMapping("/limpiar")
    public void limpiar() {
        ser.limpiarBaseDatos();
    }
}