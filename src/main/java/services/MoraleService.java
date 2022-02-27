package services;


import exceptions.ObjectNotFoundException;
import models.Morale;
import models.Physique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repos.Personne;

import java.util.List;
import java.util.UUID;

@Service
public class MoraleService {
    private final Personne<Morale> moraleRepo;

    @Autowired
    public MoraleService(Personne<Morale> moraleRepo) {
        this.moraleRepo = moraleRepo;
    }


    public List<Morale> findAllMorales() {
        return moraleRepo.findAll();
    }


    public Morale addMorale(Morale moral) {
        moral.setMoraleCode(UUID.randomUUID().toString());
        return moraleRepo.save(moral);
    }

    public Morale findMoraleById(Long id) {
        return moraleRepo.findMoraleById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Personne Morale by id  " + id + "was not found..."));
    }

    public Morale updateMorale(Morale morale) {
        return moraleRepo.save(morale);
    }

    public void deleteMorale(Long id) {
        moraleRepo.deleteMoraleById(id);
    }
}
