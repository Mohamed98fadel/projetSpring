package repos;

import models.Reference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReferenceRepo extends JpaRepository<Reference, Long> {
    Optional<Reference> findReferenceById(Long id);

    void deleteReferenceById(Long id);
}
