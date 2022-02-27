package models;

import javax.persistence.*;


@Entity
public class Soumission {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

   @ManyToOne
   private Morale soumissionaire;


    @ManyToOne
    private AppelOffre appel;

    private String dossierCandidature;
    private String typeDoc;
    @Lob
    private byte[] data;

    @Column(nullable = false, updatable = false)
    private String SmsCode;

    public Soumission() {
    }

    public Soumission(Morale soumissionaire, AppelOffre appel, String dossierCandidature, String typeDoc, byte[] data, String smsCode) {
        this.soumissionaire = soumissionaire;
        this.appel = appel;
        this.dossierCandidature = dossierCandidature;
        this.typeDoc = typeDoc;
        this.data = data;
        SmsCode = smsCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
