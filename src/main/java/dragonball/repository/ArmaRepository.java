package dragonball.repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArmaRepository extends JpaRepository<Arma, Long> {
}
class Arma {
	private Long id;

	public Arma() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}

