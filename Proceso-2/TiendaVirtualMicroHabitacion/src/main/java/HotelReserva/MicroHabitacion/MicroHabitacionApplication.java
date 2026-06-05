package HotelReserva.MicroHabitacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroHabitacionApplication {
	public static void main(String[] args) {
		SpringApplication.run(MicroHabitacionApplication.class, args);
	}
}