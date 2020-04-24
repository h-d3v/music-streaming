package com.tpappweb.app.service.interfaces;

import com.tpappweb.app.entites.Utilistateur;

import java.util.List;

public interface IUtilisateurService {
    boolean ajouterUtilisateur(Utilistateur utilistateur);
    boolean modifierMotPasse(Utilistateur utilistateur, String motPasse);
    boolean supprimerUtilisateur(Utilistateur utilistateur);
    boolean ajouterAbonne(Utilistateur utilistateur, Utilistateur utilistateurAAjouter);
    boolean supprimmerAbonne(Utilistateur utilistateur, Utilistateur utilistateurASupprimer);
    Utilistateur getUtilisateur(String pseudo);
    List<Utilistateur> trouverTous();

}
