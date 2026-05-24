package Iglesia.MicroParroco;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parroco")
public class Control {

    @Autowired
    private Servicio ser;

    @PostMapping("/grabar")
    public void grabar(@RequestBody Parroco p) {
        ser.grabar(p);
    }
    
    @GetMapping("/Listar")
    public List<Parroco>Listar(){
        return ser.listar();
    }
    
   @GetMapping("/buscar/ {id}")
   public Parroco buscar (@PathVariable Long id){
       return ser.buscar(id);
   }
   
   @DeleteMapping("/eliminar/{id}")
   public void eliminar(@PathVariable Long id){
       ser.eliminar(id);
   }
    
}
