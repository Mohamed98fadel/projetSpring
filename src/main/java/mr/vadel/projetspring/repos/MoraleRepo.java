package mr.vadel.projetspring.repos;

import mr.vadel.projetspring.models.Morale;
import mr.vadel.projetspring.models.Physique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoraleRepo extends JpaRepository<Morale, Long> {
}
