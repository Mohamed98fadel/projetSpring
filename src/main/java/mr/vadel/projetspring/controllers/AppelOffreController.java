package mr.vadel.projetspring.controllers;


import exceptions.ObjetNotFoundException;
import mr.vadel.projetspring.models.AppelOffre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import mr.vadel.projetspring.services.AppelOffreService;

import java.util.List;

@RestController
@RequestMapping("/appel")
public class AppelOffreController {

    @Autowired
    private  AppelOffreService appelOffreService;


    @GetMapping("/all")
    public ResponseEntity<List<AppelOffre>> getAllAppels() {
        List<AppelOffre> appels = appelOffreService.findAllAppelOffres();
        return new ResponseEntity<>(appels, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<AppelOffre> getAppelOffreById(@PathVariable("id") Long id) {
            AppelOffre appelOffre = appelOffreService.findAppelOffreById(id);
            return new ResponseEntity<>(appelOffre, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<AppelOffre> addAppelOffre(@RequestBody AppelOffre appel) {
        AppelOffre appelOffre = appelOffreService.addAppelOffre(appel);
        return new ResponseEntity<>(appelOffre, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAppelOffre(@PathVariable("id") Long id) {
        appelOffreService.deleteAppelOffre(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
