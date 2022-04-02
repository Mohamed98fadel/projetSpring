package mr.vadel.projetspring.controllers;


import mr.vadel.projetspring.models.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import mr.vadel.projetspring.services.ReferenceService;

import java.util.List;

@RestController
@RequestMapping("/reference")
public class ReferenceController {
    @Autowired
    private ReferenceService referenceService;





    @GetMapping("/all")
    public ResponseEntity<List<Reference>> getAllReferences() {
        List<Reference> refs = referenceService.findAllReferences();
        return new ResponseEntity<>(refs, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Reference> getReferenceById(@PathVariable("id") Long id) {
        Reference ref = referenceService.findReferenceById(id);
        return new ResponseEntity<>(ref, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Reference> addReference(@RequestBody Reference ref) {
        Reference reference = referenceService.addReference(ref);
        return new ResponseEntity<>(reference, HttpStatus.OK);
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteReference(@PathVariable("id") Long id) {
        referenceService.deleteReference(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
