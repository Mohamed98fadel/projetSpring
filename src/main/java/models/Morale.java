package models;

import javax.persistence.*;

import java.util.List;


@Entity
public class Morale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String denomination;
    private String NumImmatricul;


    @ManyToOne
    private Physique repLegal;


    @Column(nullable = false, updatable = false)
    private String moraleCode;

    @OneToMany(mappedBy = "entite")
    List<Reference> references;

    @OneToMany(mappedBy = "soumissionaire")
    List<Soumission> soumissions;



    public Morale() {
    }

    public Morale(String denomination, String numImmatricul, Physique repLegal, String moraleCode) {
        this.denomination = denomination;
        NumImmatricul = numImmatricul;
        this.repLegal = repLegal;
        this.moraleCode = moraleCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public String getNumImmatricul() {
        return NumImmatricul;
    }

    public void setNumImmatricul(String numImmatricul) {
        NumImmatricul = numImmatricul;
    }

    public String getMoraleCode() {
        return moraleCode;
    }

    public void setMoraleCode(String moraleCode) {
        this.moraleCode = moraleCode;
    }

    public void setRepLegal(Physique repLegal) {
        this.repLegal = repLegal;
    }

    public Physique getRepLegal() {
        return repLegal;
    }

}
