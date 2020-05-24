package com.tpappweb.app.service;

import com.tpappweb.app.dao.LikeOuDislikeSQLDAO;
import com.tpappweb.app.entites.LikeOuDislike;
import com.tpappweb.app.entites.Titre;
import com.tpappweb.app.entites.Utilistateur;
import com.tpappweb.app.service.interfaces.ILikeOuDislikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeOuDislikeService implements ILikeOuDislikeService {
    @Autowired
    private LikeOuDislikeSQLDAO likeOuDislikeSQLDAO;

    public boolean modifierLikeOuDislike(LikeOuDislike likeOuDislike){
        //Le like ou dislike n'existe pas
        if(likeOuDislikeSQLDAO.findById(likeOuDislike.getId())==null){
            return likeOuDislikeSQLDAO.create(likeOuDislike);
            //L'id est bien present dans l'objet entre en param et dans la bd
        }else
           return likeOuDislikeSQLDAO.update(likeOuDislike);

    }

    public LikeOuDislike supprimerLikeOuDislike(LikeOuDislike likeOuDislike){
        if(likeOuDislikeSQLDAO.deleteById(likeOuDislike.getId())){
            return null;
        }
        else if(likeOuDislikeSQLDAO.delete(likeOuDislike)){
            return null;
        }
        else return likeOuDislike;
    }

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
            //likeOuDislike true, donc like
            if(likeOuDislike.getLikeOuDislike()){
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
            if(!likeOuDislike.getLikeOuDislike()){
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
            //likeOuDislike=true, donc like
            if(likeOuDislike.getLikeOuDislike()){
                cptLike++;
            }
            //likeOuDislike=1, donc dislike
            else if (!likeOuDislike.getLikeOuDislike()){
                cptDisLike++;
            }
        }
        return new int[] {cptLike, cptDisLike};


    }
}
