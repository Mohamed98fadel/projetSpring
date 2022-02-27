package services;


import exceptions.ObjectNotFoundException;
import models.Physique;
import models.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repos.Personne;

import java.util.List;
import java.util.UUID;

@Service
public class PhysiqueService {
    private final Personne<Physique> physiqueRepo;

    @Autowired
    public PhysiqueService(Personne<Physique> physiqueRepo) {
        this.physiqueRepo = physiqueRepo;
    }

    public List<Physique> findAllPhysiques() {
        return physiqueRepo.findAll();
    }

    public Physique addPhysique(Physique physique) {
        physique.setPhysiqueCode(UUID.randomUUID().toString());
        return physiqueRepo.save(physique);
    }

    public Physique findPhysiqueById(Long id) {
        return physiqueRepo.findPhysiqueById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Personne Physique by id  " + id + "was not found..."));
    }

    public Physique updatePhysique(Physique physique) {
        return physiqueRepo.save(physique);
    }

    public void deletePhysique(Long id) {
        physiqueRepo.deletePhysiqueById(id);
    }
}
