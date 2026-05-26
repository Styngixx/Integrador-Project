package Proceso.FichoConsumo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Servicio {
    
    @Autowired
    private Repositorio rep;
    
    public void grabar(FichaConsumo f){
        double total = 0.0;
        
        // Cálculo respectivo sumando (precio * cantidad) de cada servicio
        if (f.getServicios() != null) {
            for (ItemServicio item : f.getServicios()) {
                if(item.getPrecio() != null && item.getCantidad() != null) {
                    total += (item.getPrecio() * item.getCantidad());
                }
            }
        }
        
        f.setTotalCalculado(total);
        rep.save(f);
    }
    
    public List<FichaConsumo> listar(){
        return rep.findAll();
    }
    
    public FichaConsumo buscar (Long id){
        return rep.findById(id).orElse(null);
    }
    
    public void eliminar (Long id){
        rep.deleteById(id);
    }
}
