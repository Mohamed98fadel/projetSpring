package mr.vadel.projetspring.controllers;


import mr.vadel.projetspring.forms.AttribForm;
import mr.vadel.projetspring.forms.SoumettForm;
import mr.vadel.projetspring.forms.SoumisForm;
import mr.vadel.projetspring.models.*;
import mr.vadel.projetspring.repos.AppelOffreRepo;
import mr.vadel.projetspring.services.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @Autowired
    private ReferenceService referenceService;

    @Autowired
    private AppelOffreRepo appelOffreRepo;



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

    @RequestMapping(value = "/soumett/{idAp}", method = RequestMethod.POST)
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

        return "persoPhysiques";
    }

    @RequestMapping(value = "/soums", method = RequestMethod.GET)
    public String showSoumissions(Model model) {
        SoumisForm form = new SoumisForm();
        model.addAttribute("soumisForm", form);
        List<AppelOffre> list = appelOffreService.findAllAppelOffres();
        model.addAttribute("appels", list);

        return "SoumisForm";
    }



    @RequestMapping(value = "/soums", method = RequestMethod.POST)
    public String getSoumissions(Model model,SoumisForm form) {

        AppelOffre appel = appelOffreService.findAppelOffreById(form.getAppelId());
        model.addAttribute("appelId", appel.getId());
        List<Soumission> sms = soumissionService.findAllSoumissions();
        List<Soumission> list = new ArrayList<>();


        for(Soumission sm: sms){
            if(sm.getAppel().equals(appel)){
                list.add(sm);
            }
        }

        model.addAttribute("soums", list);
        AttribForm attrbform = new AttribForm();
        model.addAttribute("attribForm", attrbform);


        return "soumissions";
    }


    @RequestMapping(value = "/attrib/{id}", method = RequestMethod.POST)
    public String AttribOffre(Model model,AttribForm form, @PathVariable("id") Long id) {



        AppelOffre appel = appelOffreService.findAppelOffreById(id);

        Morale gagnant = moraleService.findMoraleById(form.getSoumId());
        appel.setGagnant(gagnant);
        appel.setDateAttrib(LocalDateTime.now());
        appelOffreRepo.save(appel);

        //creation de la reference
        Reference ref = new Reference();

        ref.setDate(LocalDateTime.now());
        ref.setEntite(gagnant);
        ref.setObjet(appel.getObjet());
        ref.setMontant(appel.getMontant());

        referenceService.addReference(ref);

        return "appelsEnCours";
    }


    @RequestMapping(value = "/soumission/tel/{id}", method = RequestMethod.GET)
    public ResponseEntity<Resource> downloadFile(Model model, @PathVariable("id") Long id) {

        Soumission sm = soumissionService.findSoumissionById(id);
        System.out.println(sm.getDossierCandidature());

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(sm.getTypeDoc()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + sm.getDossierCandidature() + "\"")
                .body(new ByteArrayResource(sm.getData()));
    }



    @RequestMapping(value = "/soumission/ref/{id}", method = RequestMethod.GET)
    public String AfficherReferences(Model model,@PathVariable("id") Long id) {

        List<Reference> all = referenceService.findAllReferences();
        Morale soum = moraleService.findMoraleById(id);

        List<Reference> refs = new ArrayList<>();

        for(Reference ref: all){
            if(ref.getEntite().equals(soum)){
                refs.add(ref);
            }
        }

        model.addAttribute("refs", refs);

        return "RefParSoum";
    }

}


