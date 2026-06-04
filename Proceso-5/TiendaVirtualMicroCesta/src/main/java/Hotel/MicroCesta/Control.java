package Hotel.MicroCesta;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cesta")
public class Control {
    
    @Autowired
    private Repositorio r;
    
    // Para vaciar el carrito
    @DeleteMapping("/nueva")
    public void nueva(){
        r.deleteAll();
    }
    
    // Para agregar algo al carrito
    @PostMapping("/agregar")
    public void agregar(@RequestBody Entrada e){
        // Simulamos que buscamos un servicio que cuesta 50.0 soles
        Articulo a = new Articulo(e.getIdArt(), "Servicio de Habitación " + e.getIdArt(), 50.0);
        
        Linea lin = new Linea(a.getNom(), a.getPre(), e.getCan());
        r.save(lin);
    }

    // Para ver qué hay en el carrito (Opcional, pero te servirá para probar)
    @GetMapping("/listar")
    public List<Linea> listar(){
        return r.findAll();
    }
}