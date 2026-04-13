package dragonball.entidades;
import jakarta.persistence.*;
import java.util.List;
@Entity 
public class peleador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY);
    private int id;
    private String nombre;
    private int puntosVida;
    private int energia;
    private float defensaBase;
    private Arma armaEquipada;
    private List inventario;
    private List habilidades;

    public peleador() {
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

    public int getPuntosVida() {
        return puntosvida;
    }

    public void getPuntosVida() {
        this.puntosVida = vida;
    }

    public int getEnergia() {
        return energia;
    }

    public void getEnergia() {
        this.energia = energia;
    }

    public float getDefensaBase() {
        return defensaBase;
    }

    public void getDefensaBase() {
        this.defensabase = defensabase;
    }

    public Arma getArmaEquipada() {
        return armaEquipada;
    }

    public void getArmaEquipada() {
        this.armaequipada = armaequipada;
    }

    public List getInventario() {
        return getinventario;
    }
     
    public void getInventario() {
        this.inventario = inventario;
    }

    public List getHabilidades() {
        return gethabilidades;
    }

    public void getHabilidades() {
        this.habilidades = habilidades;
    }
   }   
		
