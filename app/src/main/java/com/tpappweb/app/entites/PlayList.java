package com.tpappweb.app.entites;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayList {
    private Utilistateur utilistateur;
    private String nom;
    private long id;
    private LocalDate dateEdition;
    private List<Titre> listeTitres;

    public Utilistateur getUtilistateur() {
        return utilistateur;
    }

    public void setUtilistateur(Utilistateur utilistateur) {
        this.utilistateur = utilistateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDateEdition() {
        return dateEdition;
    }

    public void setDateEdition(LocalDate dateEdition) {
        this.dateEdition = dateEdition;
    }

    public List<Titre> getListeTitres() {
        return listeTitres;
    }

    public void setListeTitres(List<Titre> listeTitres) {
        this.listeTitres = listeTitres;
    }


}
