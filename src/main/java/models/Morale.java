package models;

import repos.Personne;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Morale implements Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String denomination;
    private String NumImmatricul;
    @ManyToOne
    @JoinColumn(name = "rep_legal_id")
    private Physique repLegal;


    @Column(nullable = false, updatable = false)
    private String moraleCode;


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
