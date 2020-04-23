package com.tpappweb.app.entites;


public class LikeOrDislike {
    Utilistateur utilistateur;
    Titre titre;
    boolean like;

    public Titre getTitre() {
        return titre;
    }

    public void setTitre(Titre titre) {
        this.titre = titre;
    }

    public Utilistateur getUtilistateur() {
        return utilistateur;
    }

    public void setUtilistateur(Utilistateur utilistateur) {
        this.utilistateur = utilistateur;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like)  {
        if(this.like==like || titre!=null || utilistateur!=null);
        this.like = like;
    }
}
