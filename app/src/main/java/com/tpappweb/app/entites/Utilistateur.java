package com.tpappweb.app.entites;

import java.util.List;

public class Utilistateur {
    private String pseudo;
    private String courriel;
    private String motPasse;
    private List<Utilistateur> abonnes;
    private List<PlayList> playLists;
    private List<Commentaire> commentaires;
    private boolean estAdmin;

    public boolean isEstAdmin() {
        return estAdmin;
    }

    public void setEstAdmin(boolean estAdmin) {
        this.estAdmin = estAdmin;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }



    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    public List<Utilistateur> getAbonnes() {
        return abonnes;
    }

    public void setAbonnes(List<Utilistateur> abonnes) {
        this.abonnes = abonnes;
    }

    public List<PlayList> getPlayLists() {
        return playLists;
    }

    public void setPlayLists(List<PlayList> playLists) {
        this.playLists = playLists;
    }
}
