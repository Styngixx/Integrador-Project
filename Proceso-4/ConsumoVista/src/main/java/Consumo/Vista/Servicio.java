package Consumo.Vista;

import Consumo.Vista.modelos.FichaConsumo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Servicio {
    
    @Autowired
    private RestTemplate rt;
    
    public void registrarFicha(FichaConsumo f) {
        // Apunta al MicroConsumo en el puerto 8082
        String url = "http://localhost:8082/consumo/registrar";
        rt.postForObject(url, f, Void.class);
    }
}