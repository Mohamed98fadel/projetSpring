package services;


import exceptions.ObjectNotFoundException;
import models.AppelOffre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repos.AppelOffreRepo;

import java.util.List;
import java.util.UUID;

@Service
public class AppelOffreService {
    private final AppelOffreRepo appelOffreRepo;

    @Autowired
    public AppelOffreService(AppelOffreRepo appelOffreRepo) {
        this.appelOffreRepo = appelOffreRepo;
    }


    public AppelOffre addAppelOffre(AppelOffre appelOffre) {
        appelOffre.setAppelCode(UUID.randomUUID().toString());
        return appelOffreRepo.save(appelOffre);
    }

    public List<AppelOffre> findAllAppelOffres() {
        return appelOffreRepo.findAll();
    }

    public AppelOffre findAppelOffreById(Long id) {
        return appelOffreRepo.findAppelOffreById(id)
                .orElseThrow(() -> new ObjectNotFoundException("AppelOffre by id  " + id + "was not found..."));
    }

    public AppelOffre updateAppelOffre(AppelOffre appel) {
        return appelOffreRepo.save(appel);
    }

    public void deleteAppelOffre(Long id) {
        appelOffreRepo.deleteAppelOffreById(id);
    }

}
