package services;


import exceptions.AppelOffrerNotFoundException;
import exceptions.ReferenceNotFoundException;
import models.AppelOffre;
import models.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repos.AppelOffreRepo;
import repos.ReferenceRepo;

import java.util.List;
import java.util.UUID;

@Service
public class ReferenceService {
    private final ReferenceRepo referenceRepo;

    @Autowired
    public ReferenceService(ReferenceRepo referenceRepo) {
        this.referenceRepo = referenceRepo;
    }



    public Reference addReference(Reference reference) {
        reference.setRefCode(UUID.randomUUID().toString());
        return referenceRepo.save(reference);
    }

    public List<Reference> findAllReferences() {
        return referenceRepo.findAll();
    }

    public Reference findReferenceById(Long id) {
        return referenceRepo.findReferenceById(id)
                .orElseThrow(() -> new ReferenceNotFoundException("Reference by id  " + id + "was not found..."));
    }

    public Reference updateReference(Reference ref) {
        return referenceRepo.save(ref);
    }

    public void deleteReference(Long id) {
        referenceRepo.deleteReferenceById(id);
    }
}
