package mr.vadel.projetspring.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
public class Soumission implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private LocalDateTime Date;

   @ManyToOne
   private Morale soumissionaire;


    @ManyToOne
    private AppelOffre appel;

    private String dossierCandidature;
    private String typeDoc;

    @Column(columnDefinition = "LONGBLOB")
    private byte[] data;

    @Column(nullable = false, updatable = false)
    private String SmsCode;

    public Soumission() {
    }

    public Soumission(LocalDateTime date, Morale soumissionaire, AppelOffre appel, String dossierCandidature, String typeDoc, byte[] data, String smsCode) {
        Date = date;
        this.soumissionaire = soumissionaire;
        this.appel = appel;
        this.typeDoc = typeDoc;
        this.dossierCandidature = dossierCandidature;
        this.data = data;
        SmsCode = smsCode;
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

    public Morale getSoumissionaire() {
        return soumissionaire;
    }

    public void setSoumissionaire(Morale soumissionaire) {
        this.soumissionaire = soumissionaire;
    }

    public AppelOffre getAppel() {
        return appel;
    }

    public void setAppel(AppelOffre appel) {
        this.appel = appel;
    }

    public String getDossierCandidature() {
        return dossierCandidature;
    }

    public void setDossierCandidature(String dossierCandidature) {
        this.dossierCandidature = dossierCandidature;
    }

    public String getTypeDoc() {
        return typeDoc;
    }

    public void setTypeDoc(String typeDoc) {
        this.typeDoc = typeDoc;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getSmsCode() {
        return SmsCode;
    }

    public void setSmsCode(String smsCode) {
        SmsCode = smsCode;
    }
}
