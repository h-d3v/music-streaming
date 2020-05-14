package com.tpappweb.app.service.interfaces;

import com.tpappweb.app.entites.LikeOuDislike;
import com.tpappweb.app.entites.Titre;
import com.tpappweb.app.entites.Utilistateur;

import java.util.List;

public interface ILikeOuDislikeService {
     LikeOuDislike modifierLikeOuDislike(LikeOuDislike likeOuDislike);
     LikeOuDislike supprimerLikeOuDislike(LikeOuDislike likeOuDislike);
     List<LikeOuDislike> chercherLikeOuDislikesParUtilisateur(Utilistateur utilistateur);
     List<LikeOuDislike> chercherLikeOuDislikesParTitre(Titre titre);
    int nbrLikeParTitre(Titre titre);
    int nbrDislikeParTitre(Titre titre);

    /***
     *
     * @param titre
     * @return int[] position 0 est le nombre de likes, position [1] nombre de dislikes
     */
    int[] nbrLikeDislikesParTitre(Titre titre);




}
