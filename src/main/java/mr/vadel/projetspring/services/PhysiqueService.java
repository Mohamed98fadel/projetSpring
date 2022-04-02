package mr.vadel.projetspring.services;


import mr.vadel.projetspring.models.Physique;
import mr.vadel.projetspring.repos.PhysiqueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PhysiqueService {

    @Autowired
    private PhysiqueRepo physiqueRepo;




    public List<Physique> findAllPhysiques() {
        return physiqueRepo.findAll();
    }

    public Physique addPhysique(Physique physique) {
        physique.setPhysiqueCode(UUID.randomUUID().toString());
        return physiqueRepo.save(physique);
    }

    public Physique findPhysiqueById(Long id) {
        return physiqueRepo.findById(id).get();
    }



    public void deletePhysique(Long id) {
        physiqueRepo.deleteById(id);
    }
}
