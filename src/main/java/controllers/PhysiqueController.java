package controllers;


import models.Physique;
import models.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.PhysiqueService;
import services.ReferenceService;

import java.util.List;

@RestController
@RequestMapping("/physique")
public class PhysiqueController {
    private final PhysiqueService physiqueService;

    @Autowired
    public PhysiqueController(PhysiqueService physiqueService) {
        this.physiqueService = physiqueService;
    }



    @GetMapping("/all")
    public ResponseEntity<List<Physique>> getAllPhysiques() {
        List<Physique> phys = physiqueService.findAllPhysiques();
        return new ResponseEntity<>(phys, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Physique> getPhysiqueById(@PathVariable("id") Long id) {
        Physique phy = physiqueService.findPhysiqueById(id);
        return new ResponseEntity<>(phy, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Physique> addPhysique(@RequestBody Physique phy) {
        Physique physique = physiqueService.addPhysique(phy);
        return new ResponseEntity<>(physique, HttpStatus.OK);
    }


    @PutMapping("/update")
    public ResponseEntity<Physique> updatePhysique(@RequestBody Physique phy) {
        Physique updPhy = physiqueService.updatePhysique(phy);
        return new ResponseEntity<>(updPhy, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePhysique(@PathVariable("id") Long id) {
        physiqueService.deletePhysique(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
