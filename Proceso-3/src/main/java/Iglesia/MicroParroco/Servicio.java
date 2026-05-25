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
    
    public void grabar(Alojamiento p){
        rep.save(p);
    }
    
    public List<Alojamiento> listar(){
        return rep.findAll();
    }
    
    public Alojamiento buscar (Long id){
        return rep.findById(id).orElse(null);
    }
    
    public void eliminar (Long id){
        rep.deleteById(id);
    }
}
