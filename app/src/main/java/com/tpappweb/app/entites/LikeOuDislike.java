package com.tpappweb.app.entites;


public class LikeOuDislike {
    int id;
    Utilistateur utilistateurPseudo;
    Titre titreId;
    boolean likeOuDislike;

    public Utilistateur getUtilistateurPseudo() {
        return utilistateurPseudo;
    }

    public void setUtilistateurPseudo(Utilistateur utilistateurPseudo) {
        this.utilistateurPseudo = utilistateurPseudo;
    }

    public Titre getTitreId() {
        return titreId;
    }

    public void setTitreId(Titre titreId) {
        this.titreId = titreId;
    }

    public boolean getLikeOuDislike() {
        return likeOuDislike;
    }

    public void setLikeOuDislike(boolean likeOuDislike) {
        this.likeOuDislike = likeOuDislike;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
