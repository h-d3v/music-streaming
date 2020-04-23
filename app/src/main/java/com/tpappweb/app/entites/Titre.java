package com.tpappweb.app.entites;

public class Titre {
    private long id;
    private Auteur auteur;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
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

    private String url;
    private String urlImage;

}
