package mr.vadel.projetspring.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import mr.vadel.projetspring.forms.AttribForm;
import mr.vadel.projetspring.forms.SoumisForm;
import mr.vadel.projetspring.models.Morale;
import mr.vadel.projetspring.models.Physique;
import mr.vadel.projetspring.services.AppelOffreService;
import mr.vadel.projetspring.services.MoraleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
class MainControllerTest {

    ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }

    @Autowired
    private MoraleService moraleService;




    protected MockMvc mvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Test
    void contextLoads() {
    }

    @BeforeEach
    protected void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void showAppelOffres() throws Exception {

        String uri = "/";
        mvc.perform(MockMvcRequestBuilders.get(uri))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("appelsEnCours"))
                 .andExpect(MockMvcResultMatchers.model().attributeExists("appels"));

    }

    @Test
    void showPersoMorales() throws Exception {

        String uri = "/mrles";
        mvc.perform(MockMvcRequestBuilders.get(uri))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("persoMorales"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("morales"));
    }

    @Test
    void showPersoPhysiques() throws Exception {
        String uri = "/phques";
        mvc.perform(MockMvcRequestBuilders.get(uri))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("persoPhysiques"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("physiques"));
    }

    @Test
    void viewSoumetFormPage() throws Exception {

        String uri = "/soumet/24";
        mvc.perform(MockMvcRequestBuilders.get(uri))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("soumettForm"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("morales","appel","objet","soumettForm"));

    }

    @Test
    void processCreateSoumission() {
    }

    @Test
    void showSoumissions() throws Exception {
        String uri = "/soums";
        mvc.perform(MockMvcRequestBuilders.get(uri))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("SoumisForm"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("soumisForm","appels"));
    }

    @Test
    void getSoumissions() throws Exception {
        Morale soum = moraleService.findMoraleById(20L);

        SoumisForm form = new SoumisForm();
        form.setAppelId(24L);
        form.setId(24L);
        ObjectMapper mapper = objectMapper();
        //Converting the Object to JSONString
        String jsonString = mapper.writeValueAsString(form);
        System.out.println(jsonString+"********");

        String uri = "/soums";

        mvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON)
                        .content(jsonString))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("soumissions"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("soums"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("attribForm"));

    }

    @Test
    void downloadFile() throws Exception {

        String uri = "/soumission/tel/25";
        mvc.perform(MockMvcRequestBuilders.get(uri))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void testProcessCreateSoumission() throws Exception {
        //je vais donner une soumettForm manuellement
        Long id = 24L;
        String uri = "/soumett/"+id;
        mvc.perform(MockMvcRequestBuilders.post(uri))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("persoPhysiques"));

    }

    @Test
    void attribOffre() throws Exception {

        Morale soum = moraleService.findMoraleById(20L);

        AttribForm form = new AttribForm();
        form.setSoumId(soum.getId());
        form.setId(24L);
        ObjectMapper mapper = objectMapper();
        //Converting the Object to JSONString
        String jsonString = mapper.writeValueAsString(form);
        System.out.println(jsonString+"********");

        Long id = 24L;
        String uri = "/attrib/"+id;

        mvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON)
                        .content(jsonString))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("appelsEnCours"));
    }

    @Test
    void afficherReferences() throws Exception {

        Long id = 20L;
        String uri = "/soumission/ref/"+id;
        mvc.perform(MockMvcRequestBuilders.get(uri))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("RefParSoum"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("refs"));
    }

}