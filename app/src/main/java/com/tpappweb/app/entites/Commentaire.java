package com.tpappweb.app.entites;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Commentaire {
    private Utilistateur utilistateur;
    private Titre titre;
    private Date date;
    private String commentaire;
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

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Commentaire{" +
                "utilistateur=" + utilistateur +
                ", titre=" + titre +
                ", date=" + date +
                ", commentaire='" + commentaire + '\'' +
                ", id=" + id +
                '}';
    }
}
