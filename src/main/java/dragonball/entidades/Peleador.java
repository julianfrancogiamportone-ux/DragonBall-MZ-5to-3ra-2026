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
    private String imagenUrl;

    @ManyToMany
    @JoinTable(name = "peleador_arma", joinColumns = @JoinColumn(name = "peleador_id"), inverseJoinColumns = @JoinColumn(name = "arma_id"))
    private List<Arma> listaArmas;

    @ManyToMany
    @JoinTable(name = "peleador_ataque", joinColumns = @JoinColumn(name = "peleador_id"), inverseJoinColumns = @JoinColumn(name = "ataque_id"))

    private List<Ataque> listaAtaques;

    public Peleador() {
    }

    public Peleador(String nombre, int puntosVida) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
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

    public List<Arma> getListaArmas() {
        return listaArmas;
    }

    public void setListaArmas(List<Arma> listaArmas) {
        this.listaArmas = listaArmas;
    }
    public List<Ataque> getListaAtaques() {
        return listaAtaques;
    }

    public void setListaAtaques(List<Ataque> listaAtaques) {
        this.listaAtaques = listaAtaques;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }
 
    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

}