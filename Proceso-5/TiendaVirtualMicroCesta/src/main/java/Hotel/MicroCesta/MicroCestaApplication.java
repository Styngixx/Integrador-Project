package Hotel.MicroCesta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroCestaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroCestaApplication.class, args);
	}

}