package com.tpappweb.app.entites;

public class Titre {
    private String nom;
    private long id;
    private String titreAlbum;
    private String url;
    private String urlImage;
    private int artisteId;

    public int getArtisteId() {
        return artisteId;
    }

    public void setArtisteId(int artisteId) {
        this.artisteId = artisteId;
    }

    private Artiste artiste;

    public String getTitreAlbum() {
        return titreAlbum;
    }

    public void setTitreAlbum(String titreAlbum) {
        this.titreAlbum = titreAlbum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Artiste getArtiste() {
        return artiste;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setArtiste(Artiste artiste) {
        this.artiste = artiste;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }



}
