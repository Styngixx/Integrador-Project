package Iglesia.MicroParroco;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author FRANCIS
 */
@Service
public class Servicio {
    @Autowired
    private Repositorio rep;
    
    public void grabar(Parroco p){
        rep.save(p);
    }
    
    public List<Parroco> listar(){
        return rep.findAll();
    }
    
    public Parroco buscar (Long id){
        return rep.findById(id).orElse(null);
    }
    
    public void eliminar (Long id){
        rep.deleteById(id);
    }
}
