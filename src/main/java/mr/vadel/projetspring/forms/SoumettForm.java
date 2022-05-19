package mr.vadel.projetspring.forms;

import mr.vadel.projetspring.models.AppelOffre;
import mr.vadel.projetspring.models.Morale;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class SoumettForm {

    private Long id;
    private LocalDateTime Date;

    private Long appelId;

    private Long soumissionaire;

    private MultipartFile file;



    public SoumettForm() {
    }

    public SoumettForm(Long id, LocalDateTime date, Long appelId, Long soumissionaire) {
        this.id = id;
        Date = date;
        this.appelId = appelId;
        this.soumissionaire = soumissionaire;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return Date;
    }

    public void setDate(LocalDateTime date) {
        Date = date;
    }

    public Long getAppelId() {
        return appelId;
    }

    public void setAppelId(Long appelId) {
        this.appelId = appelId;
    }

    public Long getSoumissionaire() {
        return soumissionaire;
    }

    public void setSoumissionaire(Long soumissionaire) {
        this.soumissionaire = soumissionaire;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
