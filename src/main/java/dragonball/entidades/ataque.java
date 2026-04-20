package dragonball.entidades;
import jakarta.persistence.*;
@Entity
public class ataque {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
 private int costoEnergia;
 private int danioBase;
 private String nombre;

    public ataque() {
	}
	
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}

	public String getnombre() {
		return nombre;
	}
	public void setnombre(String nombre) {
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