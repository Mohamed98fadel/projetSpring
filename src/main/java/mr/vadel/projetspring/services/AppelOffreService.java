package mr.vadel.projetspring.services;




import mr.vadel.projetspring.models.AppelOffre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mr.vadel.projetspring.repos.AppelOffreRepo;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AppelOffreService {

    @Autowired
    private AppelOffreRepo appelOffreRepo;


    public AppelOffre addAppelOffre(AppelOffre appelOffre) {
        appelOffre.setAppelCode(UUID.randomUUID().toString());
        return appelOffreRepo.save(appelOffre);
    }

    public List<AppelOffre> findAllAppelOffres() {
        return appelOffreRepo.findAll();
    }


    public void deleteAppelOffre(Long id) {
        appelOffreRepo.deleteById(id);
    }

    public AppelOffre findAppelOffreById(Long id) {
        return appelOffreRepo.findById(id).get();
    }


    public List<AppelOffre> AppelEnCours() {
        List<AppelOffre> All = findAllAppelOffres();
        List<AppelOffre> list = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();

            for(AppelOffre Ao: All){
               if(Ao.getDateFin().isAfter(now)){
                   list.add(Ao);
               }
            }

           return list;
    }

}


