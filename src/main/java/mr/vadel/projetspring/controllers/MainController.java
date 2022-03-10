package mr.vadel.projetspring.controllers;


import mr.vadel.projetspring.models.AppelOffre;
import mr.vadel.projetspring.services.AppelOffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class MainController {

    @Autowired
    private AppelOffreService appelOffreService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showAppelOffres(Model model) {
       List<AppelOffre> list = appelOffreService.findAllAppelOffres();

        model.addAttribute("appels", list);

        return "appelsEnCours";
    }
}
