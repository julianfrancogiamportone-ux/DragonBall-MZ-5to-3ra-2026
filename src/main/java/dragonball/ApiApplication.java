package dragonball;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import dragonball.entidades.Peleador;
import dragonball.entidades.Arma;
import dragonball.entidades.Ataque;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	
		Peleador p1 = new Peleador("Vegeta", 900);
		Peleador p2 = new Peleador("Gohan", 400);

		System.out.println(p1.getNombre() + " tiene " + p1.getPuntosVida() + " puntos de vida.");
		System.out.println(p2.getNombre() + " tiene " + p2.getPuntosVida() + " puntos de vida.");

		Ataque at1 = new Ataque("Kamehameha", 100);
		Ataque at2 = new Ataque("Masenko", 80);
		Ataque at3 = new Ataque("Destructo Disk", 90);

		System.out.println(at1.getNombre() + " daño: " + at1.getdanioBase());
		System.out.println(at2.getNombre() + " daño: " + at2.getdanioBase());
		System.out.println(at3.getNombre() + " daño: " + at3.getdanioBase());

        Arma a1 = new Arma("Espada de Vegeta", 50);
		Arma a2 = new Arma("Llave de Gohan", 30);
		Arma a3 = new Arma("Bastón de Piccolo", 40);
		Arma a4 = new Arma("Guantes de Krillin", 20);
		Arma a5 = new Arma("Capa de Goku", 60);

		System.out.println(a1.getNombre() + " bonificador: " + a1.getBonificador());
		System.out.println(a2.getNombre() + " bonificador: " + a2.getBonificador());
		System.out.println(a3.getNombre() + " bonificador: " + a3.getBonificador());
		System.out.println(a4.getNombre() + " bonificador: " + a4.getBonificador());
		System.out.println(a5.getNombre() + " bonificador: " + a5.getBonificador());

		p1.setListaArmas(List.of(a1, a2));
		p2.setListaArmas(List.of(a1, a2));

		if (p1.getListaArmas().get(0).getBonificador() > p2.getListaArmas().get(0).getBonificador()) {
            System.out.println(p1.getNombre() + " tiene un arma más poderosa que " + p2.getNombre());
        } else if (p1.getListaArmas().get(0).getBonificador() < p2.getListaArmas().get(0).getBonificador()) {
            System.out.println(p2.getNombre() + " tiene un arma más poderosa que " + p1.getNombre());
        } else {
            System.out.println(p1.getNombre() + " y " + p2.getNombre() + " tienen armas igualmente poderosas");
        }

		p1.setListaAtaques(List.of(at1, at2, at3));
		p2.setListaAtaques(List.of(at2, at3));

		Arma [] armas = {a1, a2, a3, a4, a5};
        java.util.List<Arma> inventario = new java.util.ArrayList<>();
		for (int i = 0; i < armas.length; i++) {
			inventario.add(armas[i]);
		}

		p1.setListaArmas(inventario);
		Ataque [] ataques = {at1, at2, at3};
		Ataque ataqueMasFuerte = ataques[0];
		for (int i = 1; i < ataques.length; i++) {
			if (ataques[i].getdanioBase() > ataqueMasFuerte.getdanioBase()) {
				ataqueMasFuerte = ataques[i];
			}
		}
		System.out.println("El ataque más fuerte es: " + ataqueMasFuerte.getNombre() + " con daño base de " + ataqueMasFuerte.getdanioBase());
		int sumaEnergia = 0;
		for (int i = 0; i < ataques.length; i++) {
			sumaEnergia += ataques[i].getcostoEnergia();
		}
		int promedio = sumaEnergia / ataques.length;
		System.out.println("El promedio  de costo de energia es: " + promedio);

		if (promedio > 50) {
			System.out.println("El promedio de costo de energía es alto.");
		} else {
			System.out.println("El promedio de costo de energía es normal/bajo.");
		}

	    primerGolpe (p1, p2, at1);
		descansoEstatico(p1);

		for (Ataque ataque : p1.getListaAtaques()) {
			System.out.println("Ataque: " + ataque.getNombre() + ", Daño Base: " + ataque.getdanioBase());
			if(ataque.getcostoEnergia() <= p1.getEnergia()) {
				System.out.println("El ataque " + ataque.getNombre() + " es posible de realizar.");
			} else {
				System.out.println("El ataque " + ataque.getNombre() + " no es posible de realizar.");
			}
        
		}
	}
	public static void primerGolpe(Peleador atacante, Peleador defensor, Ataque ataque) {
		if (atacante.getEnergia() >= ataque.getcostoEnergia()) {
			Arma arma = atacante.getListaArmas().get(0);
			int danioTotal = ataque.getdanioBase() + arma.getBonificador();
			defensor.setPuntosVida(defensor.getPuntosVida() - danioTotal);
			atacante.setEnergia(atacante.getEnergia() - ataque.getcostoEnergia());
			System.out.println(atacante.getNombre() + " ataca a " + defensor.getNombre() + " con " + ataque.getNombre() + " causando " + danioTotal + " puntos de daño. " + defensor.getNombre() + " tiene ahora " + defensor.getPuntosVida() + " puntos de vida.");
		} else {
			System.out.println(atacante.getNombre() + " no tiene suficiente energía para realizar el ataque " + ataque.getNombre());
		}
		
	}
	public static void descansoEstatico(Peleador peleador) {
		if (peleador.getPuntosVida() < 200) {
			peleador.setPuntosVida(peleador.getPuntosVida() + 500);
			peleador.setEnergia(0);

			System.out.println(peleador.getNombre() + " se ha recuperado y ahora tiene " + peleador.getPuntosVida() + " puntos de vida.");
		} else {
			peleador.setEnergia(peleador.getEnergia() + 100);
			System.out.println(peleador.getNombre() + " no necesita descansar, tiene suficiente vida.");
		}
	}
}