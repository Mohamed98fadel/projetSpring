package mr.vadel.projetspring.forms;

public class AttribForm {
    private Long id;

    private Long soumId;

    public AttribForm() {
    }

    public AttribForm(Long id, Long soumId) {
        this.id = id;
        this.soumId = soumId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSoumId() {
        return soumId;
    }

    public void setSoumId(Long soumId) {
        this.soumId = soumId;
    }
}
