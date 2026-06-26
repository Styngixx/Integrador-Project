package Consumo.Vista;

import Consumo.Vista.modelos.FichaConsumo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Control {
    
    @Autowired
    private Servicio servicio;
    
    @GetMapping("/form")
    public String form(Model m){
       m.addAttribute("ficha", new FichaConsumo());
       return "GrabarConsumo"; 
    }
    
    @PostMapping("/grabar")
    public String grabar(@ModelAttribute FichaConsumo f){
        servicio.registrarFicha(f);
        return "redirect:/form?success";
    }
}