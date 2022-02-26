package repos;



import models.Morale;
import models.Physique;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface Personne<T> extends JpaRepository<T, Long> {
    Optional<Morale> findMoraleById(Long id);

    void deleteMoraleById(Long id);

    Optional<Physique> findPhysiqueById(Long id);

    void deletePhysiqueById(Long id);
}
