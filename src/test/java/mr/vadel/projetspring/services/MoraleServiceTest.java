package mr.vadel.projetspring.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import mr.vadel.projetspring.models.AppelOffre;
import mr.vadel.projetspring.models.Morale;
import mr.vadel.projetspring.models.Physique;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class MoraleServiceTest {
    protected MockMvc mvc;


    ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }

    @Autowired
    WebApplicationContext webApplicationContext;

    @Test
    void contextLoads() {
    }

    @BeforeEach
    protected void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Autowired
    private MoraleService moraleService;

    @Test
    void deleteMorale() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete("/morale/delete/56")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    void findAllMorales() throws Exception {
        String uri = "/morale/all";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    void addMorale() throws Exception {

        Morale testMorale = new Morale();
        Physique testPhysique = new Physique();
        testPhysique.setId(1L);
        testPhysique.setNom("Mohamed");
        testPhysique.setPrenom("Fadel");
        testPhysique.setAdresse("TJN b 118");
        testPhysique.setTel("38240034");


        testMorale.setDenomination("TestAjoutMorale");
        testMorale.setNumImmatricul("AU00013");
        testMorale.setRepLegal(testPhysique);

        ObjectMapper mapper = objectMapper();
        //Converting the Object to JSONString
        String jsonString = mapper.writeValueAsString(testMorale);


        String uri = "/morale/add";

        mvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON)
                        .content(jsonString))
                .andExpect(status().isOk());
    }

    @Test
    void findMoraleById() throws Exception {
        String uri = "/morale/find/11";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }


}