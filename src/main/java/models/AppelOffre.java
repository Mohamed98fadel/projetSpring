package models;

import org.springframework.beans.factory.annotation.Autowired;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class AppelOffre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String objet;
    private double montant;
    private Date datePub;
    private Date dateFin;
    private Date dateAttrib;
    private double delaiReatisat;

    @ManyToOne
    @JoinColumn(name = "gagnant_id")
    @Autowired
    private Morale gagnant;

    @Column(nullable = false, updatable = false)
    private String appelCode;

    @OneToMany(mappedBy = "soumissionaire")
    List<Soumission> soumissions;

    public AppelOffre(){}

    public AppelOffre(String objet, double montant, Date datePub, Date dateFin, Date dateAttrib, String appelCode) {
        this.objet = objet;
        this.montant = montant;
        this.datePub = datePub;
        this.dateFin = dateFin;
        this.dateAttrib = dateAttrib;
        this.appelCode = appelCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDatePub() {
        return datePub;
    }

    public void setDatePub(Date datePub) {
        this.datePub = datePub;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Date getDateAttrib() {
        return dateAttrib;
    }

    public void setDateAttrib(Date dateAttrib) {
        this.dateAttrib = dateAttrib;
    }

    public double getDelaiReatisat() {
        return delaiReatisat;
    }

    public void setDelaiReatisat(double delaiReatisat) {
        this.delaiReatisat = delaiReatisat;
    }

    public String getAppelCode() {
        return appelCode;
    }

    public void setAppelCode(String appelCode) {
        this.appelCode = appelCode;
    }

    public Morale getGagnant() {
        return gagnant;
    }

    public void setGagnant(Morale gagnant) {
        this.gagnant = gagnant;
    }
}
