package repos;

import models.AppelOffre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppelOffreRepo extends JpaRepository<AppelOffre,Long>{

    Optional<AppelOffre> findAppelOffreById(Long id);

    void deleteAppelOffreById(Long id);

}
