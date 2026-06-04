package Hotel.MicroFactura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // Esto es vital para que Eureka lo reconozca
public class MicroFacturaApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroFacturaApplication.class, args);
    }
}