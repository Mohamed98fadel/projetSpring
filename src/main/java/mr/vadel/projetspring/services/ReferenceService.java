package mr.vadel.projetspring.services;



import mr.vadel.projetspring.models.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mr.vadel.projetspring.repos.ReferenceRepo;

import java.util.List;
import java.util.UUID;

@Service
public class ReferenceService {
    @Autowired
    private  ReferenceRepo referenceRepo;





    public Reference addReference(Reference reference) {
        reference.setRefCode(UUID.randomUUID().toString());
        return referenceRepo.save(reference);
    }

    public List<Reference> findAllReferences() {
        return referenceRepo.findAll();
    }

    public Reference findReferenceById(Long id) {
        return referenceRepo.findById(id).get();
    }



    public void deleteReference(Long id) {
        referenceRepo.deleteById(id);
    }
}
