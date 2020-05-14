package com.tpappweb.app.service.interfaces;

import com.tpappweb.app.entites.Commentaire;
import com.tpappweb.app.entites.Titre;
import com.tpappweb.app.entites.Utilistateur;

import java.util.List;

public interface ICommentaireService {
    boolean ajouterCommentaire(Commentaire commentaire);
    boolean supprimmerCommentaire(Commentaire commentaire);
    boolean modifierCommentaire(Commentaire commentaire);
    List<Commentaire> chercherCommentairesParUtilisateur(Utilistateur utilistateur);
    List<Commentaire> chercherCommentairesParTitre(Titre titre) ;
    boolean supprimmerCommentairesParUtilisateur(Utilistateur utilistateur);
    boolean supprimerCommentairesParTitre(Titre titre);
}
