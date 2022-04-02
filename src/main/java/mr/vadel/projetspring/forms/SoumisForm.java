package mr.vadel.projetspring.forms;

public class SoumisForm {
    private Long id;

    private Long appelId;


    public SoumisForm() {
    }

    public SoumisForm(Long id, Long appelId) {
        this.id = id;
        this.appelId = appelId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAppelId() {
        return appelId;
    }

    public void setAppelId(Long appelId) {
        this.appelId = appelId;
    }
}
