package mr.vadel.projetspring.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mr.vadel.projetspring.models.Physique;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class PhysiqueServiceTest {
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

    @Autowired
    private  PhysiqueService physiqueService;

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

        ObjectMapper mapper = new ObjectMapper();

//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/physique/add")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(mapper.writeValueAsString(PrsnPhys))
//                .accept(MediaType.APPLICATION_JSON);
    }

    @Test
    void findPhysiqueById() {
    }

    @Test
    void deletePhysique() {
    }
}