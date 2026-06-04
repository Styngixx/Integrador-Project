package Hotel.MicroCesta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // <- Añadida para que sea un servicio web
@RequestMapping("/cesta")
public class Control {
    
    @Autowired
    private Repositorio r;
    
    @DeleteMapping("/nueva")
    public void nueva(){
        r.deleteAll();
    }
    
    @PostMapping("/agregar") // <- Añadida para el POST
    public void agregar(@RequestBody Entrada e){
        Articulo a = new Articulo(); // Aquí deberías llamar a MicroArticulo
        Linea lin = new Linea(a.getNom(), a.getPre(), e.getCan());
        r.save(lin);
    }
}