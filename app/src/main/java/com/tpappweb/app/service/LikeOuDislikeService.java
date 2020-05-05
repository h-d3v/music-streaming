package com.tpappweb.app.service;

import com.tpappweb.app.dao.LikeOuDislikeSQLDAO;
import com.tpappweb.app.entites.LikeOuDislike;
import com.tpappweb.app.entites.Titre;
import com.tpappweb.app.entites.Utilistateur;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LikeOuDislikeService {
    @Autowired
    private LikeOuDislikeSQLDAO likeOuDislikeSQLDAO;

    public List<LikeOuDislike> chercherLikeOuDislikesParUtilisateur(Utilistateur utilistateur){
        return likeOuDislikeSQLDAO.findByObject(utilistateur);
    }
    public List<LikeOuDislike> chercherLikeOuDislikesParTitre(Titre titre){
        return likeOuDislikeSQLDAO.findByObject(titre);
    }

    public int nbrLikeParTitre(Titre titre){
        int compteur=0;
        List<LikeOuDislike> likeOuDislikes= chercherLikeOuDislikesParTitre(titre);
        for(LikeOuDislike likeOuDislike : likeOuDislikes){
            //likeOuDislike>0, donc like
            if(likeOuDislike.getLikeOuDislike()>0){
                compteur++;
            }
        }
        return compteur;
    }
    public int nbrDislikeParTitre(Titre titre){
        int compteur=0;
        List<LikeOuDislike> likeOuDislikes= chercherLikeOuDislikesParTitre(titre);
        for(LikeOuDislike likeOuDislike : likeOuDislikes){
            //likeOuDislike=false, donc dislike
            if(likeOuDislike.getLikeOuDislike()<0){
                compteur++;
            }
        }
        return compteur;
    }

    /***
     *
     * @param titre
     * @return int[] position 0 est le nombre de likes, position [1] nombre de dislikes
     */
    public int[] nbrLikeDislikesParTitre(Titre titre){

        int cptLike=0;
        int cptDisLike=0;
        List<LikeOuDislike> likeOuDislikes= chercherLikeOuDislikesParTitre(titre);
        for(LikeOuDislike likeOuDislike : likeOuDislikes){
            //likeOuDislike=0, donc like
            if(likeOuDislike.getLikeOuDislike()>0){
                cptLike++;
            }
            //likeOuDislike=1, donc dislike
            else if (likeOuDislike.getLikeOuDislike()<0){
                cptDisLike++;
            }
        }
        return new int[] {cptLike, cptDisLike};


    }
}
