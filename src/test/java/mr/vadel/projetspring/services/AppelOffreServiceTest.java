package mr.vadel.projetspring.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import mr.vadel.projetspring.models.AppelOffre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
class AppelOffreServiceTest {

    @Autowired
    private  AppelOffreService appelOffreService;


    ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }



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
    void deleteAppelOffre() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete("/appel/delete/65")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);


    }

    @Test
    void addAppelOffre() throws Exception {

        AppelOffre testAppel = new AppelOffre();
        testAppel.setObjet("TestAjoutAppel");
        testAppel.setMontant(55000.0);
        testAppel.setDatePub(LocalDateTime.now());
        testAppel.setDateFin(LocalDateTime.now());
        testAppel.setDateAttrib(LocalDateTime.now());
        testAppel.setDelaiReatisat(90.0);
        testAppel.setGagnant(null);

        ObjectMapper mapper = objectMapper();
        //Converting the Object to JSONString
        String jsonString = mapper.writeValueAsString(testAppel);


        String uri = "/appel/add";

        mvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON)
                        .content(jsonString))
                .andExpect(status().isOk());

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
    void findAppelOffreById() throws Exception {

        String uri = "/appel/find/24";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

}