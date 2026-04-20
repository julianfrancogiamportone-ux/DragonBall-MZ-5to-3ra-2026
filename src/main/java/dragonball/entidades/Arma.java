package dragonball.entidades;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Arma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int bonificadorDanio;
	private float peso;

	@ManyToMany(mappedBy = "estudiantesColaboradores")
	private ArrayList<Peleador> peleadores;
    
	public Arma() {
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
	public int getBonificador() {
		return bonificadorDanio;
	}
	public void setgetBonificador(int bonificadorDanio) {
		this.bonificadorDanio = bonificadorDanio;
	}
	public float getPeso() {
		return peso;
	}
	public void setgetPeso(float peso) {
		this.peso = peso;
	}
}

