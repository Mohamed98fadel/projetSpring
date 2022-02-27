package controllers;

import models.Morale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.MoraleService;


import java.util.List;

@RestController
@RequestMapping("/morale")
public class MoraleController {
    private final MoraleService moraleService;

    @Autowired
    public MoraleController(MoraleService moraleService) {
        this.moraleService = moraleService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Morale>> getAllMorales() {
        List<Morale> morals = moraleService.findAllMorales();
        return new ResponseEntity<>(morals, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Morale> getMoraleById(@PathVariable("id") Long id) {
        Morale moral = moraleService.findMoraleById(id);
        return new ResponseEntity<>(moral, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Morale> addMorale(@RequestBody Morale moral) {
        Morale morale = moraleService.addMorale(moral);
        return new ResponseEntity<>(morale, HttpStatus.OK);
    }


    @PutMapping("/update")
    public ResponseEntity<Morale> updateMorale(@RequestBody Morale moral) {
        Morale updMor = moraleService.updateMorale(moral);
        return new ResponseEntity<>(updMor, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMorale(@PathVariable("id") Long id) {
        moraleService.deleteMorale(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
