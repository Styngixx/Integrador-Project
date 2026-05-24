package Iglesia.MicroParroco;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 *
 * @author FRANCIS
 */
@Entity
public class Parroco {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String telf;

    public Parroco() {
    }

    public Parroco(Long id, String nombre, String telf) {
        this.id = id;
        this.nombre = nombre;
        this.telf = telf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelf() {
        return telf;
    }

    public void setTelf(String telf) {
        this.telf = telf;
    }
    
    
    
}
