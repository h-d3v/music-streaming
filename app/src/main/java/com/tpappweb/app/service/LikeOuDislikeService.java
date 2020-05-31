package com.tpappweb.app.service;

import com.tpappweb.app.dao.LikeOuDislikeSQLDAO;
import com.tpappweb.app.entites.LikeOuDislike;
import com.tpappweb.app.entites.Titre;
import com.tpappweb.app.entites.Utilistateur;
import com.tpappweb.app.service.interfaces.ILikeOuDislikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
public class LikeOuDislikeService implements ILikeOuDislikeService {
    @Autowired
    private LikeOuDislikeSQLDAO likeOuDislikeSQLDAO;
    @Override
    public LikeOuDislike modifierLikeOuDislike(LikeOuDislike likeOuDislike){
            //L'id est bien present dans l'objet entre en param et dans la bd
       if (likeOuDislike.getId()!=0 && likeOuDislikeSQLDAO.findById(likeOuDislike.getId()).getId()==likeOuDislike.getId()){
            likeOuDislikeSQLDAO.update(likeOuDislike);
            return likeOuDislikeSQLDAO.findById(likeOuDislike.getId()) ;
        }
            //L'id n'est pas present dans l'objet en param mais l'utilisateur et le titre corrsepondent a
            //une entree unique LikeOuDislike dans la bd trouvee avec le nom d'utilisateur et le titre
        else if (likeOuDislikeSQLDAO.findByObject(likeOuDislike).size()==1){
            return likeOuDislikeSQLDAO.modifier(likeOuDislike);
        }
        else return null;
    }
    @Override
    public LikeOuDislike supprimerLikeOuDislike(LikeOuDislike likeOuDislike){
        if(likeOuDislikeSQLDAO.deleteById(likeOuDislike.getId())){
            return null;
        }
        else if(likeOuDislikeSQLDAO.delete(likeOuDislike)){
            return null;
        }
        else return likeOuDislike;
    }
    @Override
    public List<LikeOuDislike> chercherLikeOuDislikesParUtilisateur(Utilistateur utilistateur){
        return likeOuDislikeSQLDAO.findByObject(utilistateur);
    }
    @Override
    public List<LikeOuDislike> chercherLikeOuDislikesParTitre(Titre titre){
        return likeOuDislikeSQLDAO.findByObject(titre);
    }
    @Override
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
    @Override
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

    @Override
    public LikeOuDislike chercherParLikeOuDislie(LikeOuDislike likeOuDislike) {
        return likeOuDislikeSQLDAO.findByObject(likeOuDislike).get(0);
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

    @Override
    public void ajouterLikeOuDislike(LikeOuDislike likeOuDislike) {
        if(likeOuDislike.getTitreId().getId()!=0 && likeOuDislike.getUtilistateurPseudo().getPseudo()!=null){
            try {
                likeOuDislikeSQLDAO.create(likeOuDislike);
            }catch (DataIntegrityViolationException e){// Le like existe deja,donc on le modifie
                likeOuDislikeSQLDAO.update(likeOuDislike);
            }

        }
    }
}
