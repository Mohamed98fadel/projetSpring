package mr.vadel.projetspring.controllers;


import mr.vadel.projetspring.services.AppelOffreService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;



@SpringBootTest
class MainControllerTest {

    @Autowired
    private AppelOffreService appelOffreService;




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

        String uri = "/soumet/14";
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
    void getSoumissions() {
    }

    @Test
    void downloadFile() throws Exception {

        String uri = "/soumission/tel/17";
        mvc.perform(MockMvcRequestBuilders.get(uri))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}