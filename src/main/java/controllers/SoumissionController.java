package controllers;

import models.Soumission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.SoumissionService;
import java.util.List;

@RestController
@RequestMapping("/soumission")
public class SoumissionController {

    private final SoumissionService soumissionService;

    @Autowired
    public SoumissionController(SoumissionService soumissionService) {
        this.soumissionService = soumissionService;
    }



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


    @PutMapping("/update")
    public ResponseEntity<Soumission> updateSoumission(@RequestBody Soumission soum) {
        Soumission updSms = soumissionService.updateSoumission(soum);
        return new ResponseEntity<>(updSms, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSoumission(@PathVariable("id") Long id) {
        soumissionService.deleteSoumission(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
