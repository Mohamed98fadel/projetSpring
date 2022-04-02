package mr.vadel.projetspring.services;


import mr.vadel.projetspring.models.Morale;
import mr.vadel.projetspring.repos.MoraleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MoraleService {

    @Autowired
    private MoraleRepo moraleRepo;





    public List<Morale> findAllMorales() {
        return moraleRepo.findAll();
    }


    public Morale addMorale(Morale moral) {
        moral.setMoraleCode(UUID.randomUUID().toString());
        return moraleRepo.save(moral);
    }

    public Morale findMoraleById(Long id) {
        return moraleRepo.findById(id).get();
    }



    public void deleteMorale(Long id) {
        moraleRepo.deleteById(id);
    }


}
