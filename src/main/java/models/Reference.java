package models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

public class Reference implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String objet;

    @ManyToOne
    @Autowired
    private Morale entite;

    private Date Date;

    private double montant;

    @Column(nullable = false, updatable = false)
    private String refCode;


    public Reference() {
    }

    public Reference(String objet, Morale entite, java.util.Date date, double montant, String refCode) {
        this.objet = objet;
        this.entite = entite;
        Date = date;
        this.montant = montant;
        this.refCode = refCode;
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

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getRefCode() {
        return refCode;
    }

    public void setRefCode(String refCode) {
        this.refCode = refCode;
    }

    public Morale getEntite() {
        return entite;
    }

    public void setEntite(Morale entite) {
        this.entite = entite;
    }
}
