package mr.vadel.projetspring.forms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class SoumettFormTest {

    @Autowired
    private  AttribForm attribForm;

    AttribForm form = new AttribForm(1L,3L);
    SoumisForm soumisForm = new SoumisForm(4L,5L);
    SoumettForm SoumForm = new SoumettForm(2L, LocalDateTime.now(),22L, 26L);

    @Test
    void getId() {
        assertEquals(1L,form.getId());


    }

    @Test
    void setId() {

    }

    @Test
    void getDate() {
        assertEquals(4L,soumisForm.getId());
    }

    @Test
    void setDate() {
        assertEquals(5L,soumisForm.getAppelId());
    }

    @Test
    void getAppelId() {
        assertEquals(22L,SoumForm.getAppelId());
    }

    @Test
    void setAppelId() {
    }

    @Test
    void getSoumissionaire() {
        assertEquals(26L,SoumForm.getSoumissionaire());
    }

    @Test
    void setSoumissionaire() {
    }

    @Test
    void getFile() {
        assertEquals(2L,SoumForm.getId());
    }

    @Test
    void setFile() {
    }
}