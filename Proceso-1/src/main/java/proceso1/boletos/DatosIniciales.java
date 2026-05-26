package proceso1.boletos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DatosIniciales implements CommandLineRunner {

    private final ItinerarioViajeRepositorio itinerarioRepositorio;

    public DatosIniciales(ItinerarioViajeRepositorio itinerarioRepositorio) {
        this.itinerarioRepositorio = itinerarioRepositorio;
    }

    @Override
    public void run(String... args) {
        if (itinerarioRepositorio.count() == 0) {
            ItinerarioViaje itinerario = new ItinerarioViaje(
                    "Lima",
                    "Cusco",
                    LocalDate.now().plusDays(2),
                    40
            );
            itinerarioRepositorio.save(itinerario);
        }
    }
}
