package com.tpappweb.app.entites;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LikeOuDislike {
    int id;
    Utilistateur utilisateurPseudo;
    Titre titreId;
    boolean likeOuDislike;

    public Utilistateur getUtilisateurPseudo() {
        return utilisateurPseudo;
    }

    public void setUtilisateurPseudo(Utilistateur utilisateurPseudo) {
        this.utilisateurPseudo = utilisateurPseudo;
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
