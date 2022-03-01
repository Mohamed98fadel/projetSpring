package mr.vadel.projetspring.repos;


import mr.vadel.projetspring.models.AppelOffre;
import mr.vadel.projetspring.models.Soumission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface SoumissionRepo extends JpaRepository<Soumission, Long> {

    List<Soumission> findByAppel(AppelOffre appel);
}
