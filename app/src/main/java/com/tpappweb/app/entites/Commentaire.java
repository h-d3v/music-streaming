package com.tpappweb.app.entites;

import java.util.Date;

public class Commentaire {
    private Utilistateur utilistateur;
    private Titre titre;
    private Date date;
    private String texteDuCommentaire;
    private long id;

    public Utilistateur getUtilistateur() {
        return utilistateur;
    }

    public void setUtilistateur(Utilistateur utilistateur) {
        this.utilistateur = utilistateur;
    }

    public Titre getTitre() {
        return titre;
    }

    public void setTitre(Titre titre) {
        this.titre = titre;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTexteDuCommentaire() {
        return texteDuCommentaire;
    }

    public void setTexteDuCommentaire(String texteDuCommentaire) {
        this.texteDuCommentaire = texteDuCommentaire;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
