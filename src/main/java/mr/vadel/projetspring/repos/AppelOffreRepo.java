package mr.vadel.projetspring.repos;

import mr.vadel.projetspring.models.AppelOffre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppelOffreRepo extends JpaRepository<AppelOffre,Long>{


}
