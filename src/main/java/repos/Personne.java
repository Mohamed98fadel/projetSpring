package repos;



import org.springframework.data.jpa.repository.JpaRepository;


public interface Personne<T> extends JpaRepository<T, Long> {
}
