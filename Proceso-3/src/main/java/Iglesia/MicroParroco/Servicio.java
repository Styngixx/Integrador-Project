package Iglesia.MicroParroco;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Servicio {

    @Autowired
    private Repositorio alojamientoRepo;

    @Autowired
    private ReservaRepositorio reservaRepo;

    @Autowired
    private ServicioDetalleRepositorio servicioRepo;

    public Reserva grabarReserva(Reserva reserva) {
        return reservaRepo.save(reserva);
    }

    public List<Reserva> listarReservas() {
        return reservaRepo.findAll();
    }

    public Reserva buscarReserva(Long id) {
        return reservaRepo.findById(id).orElse(null);
    }

    public Alojamiento abrirFichaDesdeReserva(Long reservaId) {
        Reserva reserva = buscarReserva(reservaId);
        if (reserva == null) {
            return null;
        }
        Alojamiento ficha = new Alojamiento();
        ficha.setNumeroHabitacion(reserva.getNumeroHabitacion());
        ficha.setFechaEntrada(reserva.getFechaEntrada());
        ficha.setFechaSalida(reserva.getFechaSalida());
        ficha.setClienteNombre(reserva.getClienteNombre());
        ficha.setTelf(reserva.getTelf());
        ficha.setDireccion(reserva.getDireccion());
        ficha.setReserva(reserva);
        reserva.setEstado("EN_USO");
        reservaRepo.save(reserva);
        return alojamientoRepo.save(ficha);
    }

    public Alojamiento grabarAlojamiento(Alojamiento alojamiento) {
        return alojamientoRepo.save(alojamiento);
    }

    public List<Alojamiento> listarAlojamientos() {
        return alojamientoRepo.findAll();
    }

    public Alojamiento buscarAlojamiento(Long id) {
        return alojamientoRepo.findById(id).orElse(null);
    }

    public void eliminarAlojamiento(Long id) {
        alojamientoRepo.deleteById(id);
    }

    public ServicioDetalle agregarServicio(Long alojamientoId, ServicioDetalle servicio) {
        Alojamiento alojamiento = buscarAlojamiento(alojamientoId);
        if (alojamiento == null) {
            return null;
        }
        if (servicio.getFechaHora() == null) {
            servicio.setFechaHora(java.time.LocalDateTime.now());
        }
        servicio.setAlojamiento(alojamiento);
        alojamiento.agregarServicio(servicio);
        alojamientoRepo.save(alojamiento);
        return servicioRepo.save(servicio);
    }

    public List<ServicioDetalle> listarServiciosPorAlojamiento(Long alojamientoId) {
        return servicioRepo.findByAlojamientoId(alojamientoId);
    }
}
