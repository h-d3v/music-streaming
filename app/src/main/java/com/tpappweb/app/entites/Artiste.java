package com.tpappweb.app.entites;

import java.util.List;

public class Artiste {
    private String nom;
    private String biographie;
    private List<Titre> listeTitres;
    private int id;
    private String urlPhoto;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getBiographie() {
        return biographie;
    }

    public void setBiographie(String biographie) {
        this.biographie = biographie;
    }

    public List<Titre> getListeTitres() {
        return listeTitres;
    }

    public void setListeTitres(List<Titre> listeTitres) {
        this.listeTitres = listeTitres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }
}
