package mr.vadel.projetspring.repos;

import mr.vadel.projetspring.models.AppelOffre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppelOffreRepo extends JpaRepository<AppelOffre,Long>{


}


//    Optional<AppelOffre> findAppelOffreById(Long id);
//
//    void deleteAppelOffreById(Long id);