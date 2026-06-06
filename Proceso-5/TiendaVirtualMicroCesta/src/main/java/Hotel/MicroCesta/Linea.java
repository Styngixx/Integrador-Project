package Hotel.MicroCesta;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Linea {
    @Id
    @GeneratedValue
    private Long idLin;
    private String nom;
    private double pre;
    private int can;
    
    public double importe(){
        return pre * can;
    }

    public Linea() {
    }

    public Linea(Long idLin, String nom, double pre, int can) {
        this.idLin = idLin;
        this.nom = nom;
        this.pre = pre;
        this.can = can;
    }

    public Linea(String nom, double pre, int can) {
        this.nom = nom;
        this.pre = pre;
        this.can = can;
    }

    public Long getIdLin() { return idLin; }
    public void setIdLin(Long idLin) { this.idLin = idLin; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public double getPre() { return pre; }
    public void setPre(double pre) { this.pre = pre; }
    public int getCan() { return can; }
    public void setCan(int can) { this.can = can; }
}