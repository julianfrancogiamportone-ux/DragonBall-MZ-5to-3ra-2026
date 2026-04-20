package dragonball.entidades;
import jakarta.persistence.*;
import java.util.List;
@Entity 
public class Peleador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int puntosVida;
    private int energia;
    private float defensaBase;

    @ManyToMany 
    private List<Peleador> integrantesColaboradores;

    public Peleador() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public float getDefensaBase() {
        return defensaBase;
    }

    public void setDefensaBase(float defensaBase) {
        this.defensaBase = defensaBase;
    }

}