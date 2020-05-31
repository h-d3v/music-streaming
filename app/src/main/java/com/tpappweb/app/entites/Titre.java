package com.tpappweb.app.entites;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Titre {
    private String nom;
    private long id;
    private String titreAlbum;
    private String url;
    private String urlImage;
    private String  nomArtiste;
    private int duree;
    private String genre;
    private String dateSortie;
    private int[] nbrlikeOuDislike;

    public int[] getNbrlikeOuDislike() {
        return nbrlikeOuDislike;
    }

    public void setNbrlikeOuDislike(int[] likeOuDislike) {
        this.nbrlikeOuDislike = likeOuDislike;
    }

    public String getNomArtiste() {
        return nomArtiste;
    }

    public void setNomArtiste(String nomArtiste) {
        this.nomArtiste = nomArtiste;
    }

    public String getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(String dateSortie) {
        this.dateSortie = dateSortie;
    }

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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
