package mr.vadel.projetspring.models;

import org.springframework.beans.factory.annotation.Autowired;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class AppelOffre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String objet;
    private double montant;
    private LocalDateTime datePub;
    private LocalDateTime dateFin;
    private LocalDateTime dateAttrib;
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

    public AppelOffre(String objet, double montant, LocalDateTime datePub, LocalDateTime dateFin, LocalDateTime dateAttrib, double delaiReatisat, Morale gagnant, String appelCode) {
        this.objet = objet;
        this.montant = montant;
        this.datePub = datePub;
        this.dateFin = dateFin;
        this.dateAttrib = dateAttrib;
        this.delaiReatisat = delaiReatisat;
        this.gagnant = gagnant;
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

    public LocalDateTime getDatePub() {
        return datePub;
    }

    public void setDatePub(LocalDateTime datePub) {
        this.datePub = datePub;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public LocalDateTime getDateAttrib() {
        return dateAttrib;
    }

    public void setDateAttrib(LocalDateTime dateAttrib) {
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
