package services;


import exceptions.ObjectNotFoundException;


import models.Soumission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repos.SoumissionRepo;

import java.util.List;
import java.util.UUID;

@Service
public class SoumissionService {
    private final SoumissionRepo soumissionRepo;

    @Autowired
    public SoumissionService(SoumissionRepo soumissionRepo) {
        this.soumissionRepo = soumissionRepo;
    }


    public Soumission addSoumission(Soumission soumission) {
        soumission.setSmsCode(UUID.randomUUID().toString());
        return soumissionRepo.save(soumission);
    }

    public List<Soumission> findAllSoumissions() {
        return soumissionRepo.findAll();
    }

    public Soumission findSoumissionById(Long id) {
        return soumissionRepo.findSoumissionById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Soumission by id  " + id + "was not found..."));
    }

    public Soumission updateSoumission(Soumission sms) {
        return soumissionRepo.save(sms);
    }

    public void deleteSoumission(Long id) {
        soumissionRepo.deleteSoumissionById(id);
    }
}
