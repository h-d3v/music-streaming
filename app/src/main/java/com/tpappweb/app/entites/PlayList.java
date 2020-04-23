package com.tpappweb.app.entites;


import java.util.List;

public class PlayList {
    private Utilistateur utilistateur;
    private String nom;
    private long id;
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

    public List<Titre> getListeTitres() {
        return listeTitres;
    }

    public void setListeTitres(List<Titre> listeTitres) {
        this.listeTitres = listeTitres;
    }


}
