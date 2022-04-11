package mr.vadel.projetspring.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class PhysiqueServiceTest {
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
    private  PhysiqueService physiqueService;

    @Test
    void deletePhysique() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete("/physique/delete/64")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    void findAllPhysiques() throws Exception {
        String uri = "/physique/all";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    void addPhysique() throws Exception {
        Physique PrsnPhys = new Physique();
        PrsnPhys.setNom("Test");
        PrsnPhys.setPrenom("Test");
        PrsnPhys.setAdresse("Adress Test");
        PrsnPhys.setMail("test.test@gmail.com");
        PrsnPhys.setTel("26165114");

        ObjectMapper mapper = objectMapper();
        //Converting the Object to JSONString
        String jsonString = mapper.writeValueAsString(PrsnPhys);


        String uri = "/physique/add";

        mvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON)
                        .content(jsonString))
                .andExpect(status().isOk());
    }

    @Test
    void findPhysiqueById() throws Exception {
        String uri = "/physique/find/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }


}