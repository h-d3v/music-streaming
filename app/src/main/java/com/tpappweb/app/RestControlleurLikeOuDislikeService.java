package com.tpappweb.app;


import com.fasterxml.jackson.databind.util.JSONPObject;
import com.tpappweb.app.entites.LikeOuDislike;
import com.tpappweb.app.entites.Titre;
import com.tpappweb.app.entites.Utilistateur;
import com.tpappweb.app.service.interfaces.ILikeOuDislikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

@RestController
public class RestControlleurLikeOuDislikeService {
    @Autowired
    private ILikeOuDislikeService iLikeOuDislikeService;

    @GetMapping("/like")
    public LikeOuDislike ajouterLike(@RequestParam("utilisateurPseudo") String utilisateurPseudo,
                                              @RequestParam("titreId") int titreId,
                                              @RequestParam("action") String action){
        Utilistateur utilistateur = new Utilistateur();
        utilistateur.setPseudo(utilisateurPseudo);
        Titre titre = new Titre();
        titre.setId(titreId);

        LikeOuDislike likeOuDislikeAcreer= new LikeOuDislike();
        likeOuDislikeAcreer.setUtilistateurPseudo(utilistateur);
        likeOuDislikeAcreer.setTitreId(titre);

        //TODO checker utilisateur connecte dans la session

         if ("like".equals(action)){
            likeOuDislikeAcreer.setLikeOuDislike(true);
            iLikeOuDislikeService.ajouterLikeOuDislike(likeOuDislikeAcreer);
        }
        else if ("dislike".equals(action)){
            likeOuDislikeAcreer.setLikeOuDislike(false);
            iLikeOuDislikeService.ajouterLikeOuDislike(likeOuDislikeAcreer);
        }


        return iLikeOuDislikeService.chercherParLikeOuDislie(likeOuDislikeAcreer);
    }
    @GetMapping("/titre/{id}/likes")
        public String getnbrlikesOuDislikes(@PathVariable("id") int titreid){
            Titre titre = new Titre();
            titre.setId(titreid);
            int[] likesouDislikes = iLikeOuDislikeService.nbrLikeDislikesParTitre(titre);
            return likesouDislikes[0] +":"+likesouDislikes[1];
    }




}
