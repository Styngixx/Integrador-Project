package ProcesoAlojamiento.MicroAlojamiento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/alojamiento")
public class Control {

    @Autowired
    private Repositorio r;

    private RestTemplate rt = new RestTemplate();

    @PostMapping("/grabar/{idEmpleado}/{idReserva}")
    public Alojamiento grabar(
            @PathVariable Long idEmpleado,
            @PathVariable Long idReserva) {

        Reserva reserva = rt.getForObject(
                "http://localhost:8081/reserva/buscar/" + idReserva,
                Reserva.class);

        Alojamiento a = new Alojamiento();

        a.setFecha(LocalDate.now().toString());
        a.setIdEmpleado(idEmpleado);
        a.setIdReserva(idReserva);
        a.setTotal(reserva.getPrecioPorNoche());

        return r.save(a);
    }

    @GetMapping("/buscar/{id}")
    public AlojamientoDetalle buscar(@PathVariable Long id) {

        Alojamiento a = r.findById(id).orElse(null);

        if (a == null) {
            return null;
        }

        Empleado empleado = rt.getForObject(
                "http://localhost:8082/empleado/buscar/" + a.getIdEmpleado(),
                Empleado.class);

        Reserva reserva = rt.getForObject(
                "http://localhost:8081/reserva/buscar/" + a.getIdReserva(),
                Reserva.class);

        AlojamientoDetalle detalle = new AlojamientoDetalle();

        detalle.setNumeroAlojamiento(a.getNumeroAlojamiento());
        detalle.setFecha(a.getFecha());
        detalle.setEmpleado(empleado);
        detalle.setReserva(reserva);
        detalle.setTotal(a.getTotal());

        return detalle;
    }

    @GetMapping("/listar")
    public List<AlojamientoDetalle> listar() {

        List<AlojamientoDetalle> lista = new ArrayList<>();

        for (Alojamiento a : r.findAll()) {

            Empleado empleado = rt.getForObject(
                    "http://localhost:8082/empleado/buscar/" + a.getIdEmpleado(),
                    Empleado.class);

            Reserva reserva = rt.getForObject(
                    "http://localhost:8081/reserva/buscar/" + a.getIdReserva(),
                    Reserva.class);

            AlojamientoDetalle detalle = new AlojamientoDetalle();

            detalle.setNumeroAlojamiento(a.getNumeroAlojamiento());
            detalle.setFecha(a.getFecha());
            detalle.setEmpleado(empleado);
            detalle.setReserva(reserva);
            detalle.setTotal(a.getTotal());

            lista.add(detalle);
        }

        return lista;
    }
}
