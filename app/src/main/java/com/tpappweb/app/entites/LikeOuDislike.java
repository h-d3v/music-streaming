package com.tpappweb.app.entites;


public class LikeOuDislike {
    int id;
    Utilistateur utilistateurPseudo;
    Titre titreId;
    int likeOuDislike;

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

    public int getLikeOuDislike() {
        return likeOuDislike;
    }

    public void setLikeOuDislike(int likeOuDislike) {
        this.likeOuDislike = likeOuDislike;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
