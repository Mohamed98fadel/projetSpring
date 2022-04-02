package mr.vadel.projetspring.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
public class Physique extends Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String tel;
    private String mail;

    @Column(nullable = false, updatable = false)
    private String physiqueCode;

    @OneToMany(mappedBy = "repLegal")
    List<Morale> morals;


    public Physique() {
    }

    public Physique(String nom, String prenom, String adresse, String tel, String mail, String physiqueCode) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.tel = tel;
        this.mail = mail;
        this.physiqueCode = physiqueCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhysiqueCode() {
        return physiqueCode;
    }

    public void setPhysiqueCode(String physiqueCode) {
        this.physiqueCode = physiqueCode;
    }


}
