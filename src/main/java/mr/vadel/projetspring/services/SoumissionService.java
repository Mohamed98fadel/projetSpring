package mr.vadel.projetspring.services;


import mr.vadel.projetspring.models.AppelOffre;
import mr.vadel.projetspring.models.Soumission;
import mr.vadel.projetspring.repos.SoumissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.UUID;

@Service
public class SoumissionService {
    @Autowired
    private SoumissionRepo soumissionRepo;


    public Soumission addSoumission(Soumission soumission) {
        soumission.setSmsCode(UUID.randomUUID().toString());
        return soumissionRepo.save(soumission);
    }

    public List<Soumission> findAllSoumissions() {
        return soumissionRepo.findAll();
    }

    public Soumission findSoumissionById(Long id) {
        return soumissionRepo.findById(id).get();
    }

    public void deleteSoumission(Long id) {
        soumissionRepo.deleteById(id);
    }


    public List<Soumission> findByAppel(AppelOffre appel) {
        return soumissionRepo.findByAppel(appel);
    }

}
