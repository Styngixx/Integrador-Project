package Hotel.MicroFactura;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articulo")
public class Control {
    
    @Autowired
    private Repositorio r;

    @PostMapping("/grabar")
    public void grabar(@RequestBody Articulo a){
       r.save(a);
    }
    
    @GetMapping("/listar")
    public List<Articulo> listar(){
        return r.findAll();
    }
    
    @GetMapping("/buscar/{id}")
    public Articulo buscar(@PathVariable Long id){
        return r.findById(id).orElse(null);
    }
}