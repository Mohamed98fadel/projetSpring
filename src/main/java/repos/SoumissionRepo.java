package repos;


import models.Soumission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SoumissionRepo extends JpaRepository<Soumission, Long> {
    Optional<Soumission> findSoumissionById(Long id);

    void deleteSoumissionById(Long id);
}
