package Hotel.MicroFactura;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Articulo {
    @Id
    @GeneratedValue
    private Long idArt;
    private String nom;
    private double pre;

    public Articulo() {
    }

    public Articulo(Long idArt, String nom, double pre) {
        this.idArt = idArt;
        this.nom = nom;
        this.pre = pre;
    }

    public Long getIdArt() {
        return idArt;
    }

    public void setIdArt(Long idArt) {
        this.idArt = idArt;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPre() {
        return pre;
    }

    public void setPre(double pre) {
        this.pre = pre;
    }
}