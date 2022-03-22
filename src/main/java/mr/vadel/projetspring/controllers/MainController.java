package mr.vadel.projetspring.controllers;


import mr.vadel.projetspring.forms.SoumettForm;
import mr.vadel.projetspring.models.AppelOffre;
import mr.vadel.projetspring.models.Morale;
import mr.vadel.projetspring.models.Physique;
import mr.vadel.projetspring.models.Soumission;
import mr.vadel.projetspring.services.AppelOffreService;
import mr.vadel.projetspring.services.MoraleService;
import mr.vadel.projetspring.services.PhysiqueService;
import mr.vadel.projetspring.services.SoumissionService;
import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.awt.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Controller
public class MainController {

    @Autowired
    private AppelOffreService appelOffreService;

    @Autowired
    private MoraleService moraleService;

    @Autowired
    private PhysiqueService physiqueService;

    @Autowired
    private SoumissionService soumissionService;

    private Soumission soumission;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showAppelOffres(Model model) {
       List<AppelOffre> list = appelOffreService.AppelEnCours();

        model.addAttribute("appels", list);

        return "appelsEnCours";
    }


    @RequestMapping(value = "/mrles", method = RequestMethod.GET)
    public String showPersoMorales(Model model) {
        List<Morale> list = moraleService.findAllMorales();

        model.addAttribute("morales", list);

        return "persoMorales";
    }

    @RequestMapping(value = "/phques", method = RequestMethod.GET)
    public String showPersoPhysiques(Model model) {
        List<Physique> list = physiqueService.findAllPhysiques();

        model.addAttribute("physiques", list);

        return "persoPhysiques";
    }

    @RequestMapping(value = "/soums", method = RequestMethod.GET)
    public String showSoumissions(Model model) {
        List<Soumission> list = soumissionService.findAllSoumissions();

        model.addAttribute("soums", list);

        return "soumissions";
    }


    @RequestMapping(value = "/soumet/{id}", method = RequestMethod.GET)
    public String viewSoumetFormPage(Model model,@PathVariable("id") Long id) {

        List<Morale> list = moraleService.findAllMorales();
        model.addAttribute("morales", list);

        AppelOffre appel = appelOffreService.findAppelOffreById(id);



        model.addAttribute("appel", appel.getId());
        model.addAttribute("objet", appel.getObjet());

        SoumettForm form = new SoumettForm();
        model.addAttribute("soumettForm", form);

        return "soumettForm";
    }

    @RequestMapping(value = "/soumet/{idAp}", method = RequestMethod.POST)
    public String processCreateSoumission(Model model, SoumettForm soumettForm,@PathVariable("idAp") Long idAp) throws IOException {


        AppelOffre appel = appelOffreService.findAppelOffreById(idAp);

        Morale soumissionaire = moraleService.findMoraleById(soumettForm.getSoumissionaire());


        String uuid = UUID.randomUUID().toString();

        LocalDateTime date = LocalDateTime.now();


        try {
          Soumission soum = new Soumission(date,soumissionaire,appel,
                  soumettForm.getFile().getOriginalFilename(),soumettForm.getFile().getContentType(),
                  soumettForm.getFile().getBytes(),uuid);
          soumissionService.addSoumission(soum);
        } catch (Exception e) {
          System.out.println(e);
            return "/";
        }

        return "soumissions";
    }

}