package mr.vadel.projetspring.services;

import mr.vadel.projetspring.controllers.AppelOffreController;
import mr.vadel.projetspring.models.AppelOffre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.net.http.HttpRequest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AppelOffreServiceTest {

    @Autowired
    private  AppelOffreService appelOffreService;




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
    void addAppelOffre() {
    }

    @Test
    void findAllAppelOffres() throws Exception {

        String uri = "/appel/all";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    void appelEnCours() {
        appelOffreService.AppelEnCours();

    }

    @Test
    void findAppelOffreById() {
    }

    @Test
    void updateAppelOffre() {
    }

    @Test
    void deleteAppelOffre() {
    }

    @Test
    void attribuerUnAppel() {
    }
}