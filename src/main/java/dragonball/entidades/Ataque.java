package dragonball.entidades;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "ataques")
public class Ataque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int costoEnergia;
	private int danioBase;
	private String nombre;
	@ManyToMany(mappedBy = "listaAtaques")
	private List<Peleador> peleadores;
	public Ataque() {
	}
	
	public Ataque(String nombre, int danioBase) {
		this.danioBase = danioBase;
		this.nombre = nombre;
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
	
	public int getcostoEnergia() {
		return costoEnergia;
	}
	public void setcostoEnergia(int costoEnergia) {
		this.costoEnergia = costoEnergia;
	}

	public int getdanioBase() {
		return danioBase;
	}
	public void setdanioBase(int danioBase) {
		this.danioBase = danioBase;
	}
}