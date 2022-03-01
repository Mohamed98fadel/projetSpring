package mr.vadel.projetspring.controllers;

import mr.vadel.projetspring.models.Soumission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import mr.vadel.projetspring.services.SoumissionService;
import java.util.List;

@RestController
@RequestMapping("/soumission")
public class SoumissionController {
    @Autowired
    private  SoumissionService soumissionService;



    @GetMapping("/all")
    public ResponseEntity<List<Soumission>> getAllSoumissions() {
        List<Soumission> sms = soumissionService.findAllSoumissions();
        return new ResponseEntity<>(sms, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Soumission> getSoumissionById(@PathVariable("id") Long id) {
        Soumission sms = soumissionService.findSoumissionById(id);
        return new ResponseEntity<>(sms, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Soumission> addSoumission(@RequestBody Soumission soum) {
        Soumission sms = soumissionService.addSoumission(soum);
        return new ResponseEntity<>(sms, HttpStatus.OK);
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSoumission(@PathVariable("id") Long id) {
        soumissionService.deleteSoumission(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
