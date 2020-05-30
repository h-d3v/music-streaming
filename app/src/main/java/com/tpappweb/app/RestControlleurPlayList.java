package com.tpappweb.app;

import com.tpappweb.app.entites.PlayList;
import com.tpappweb.app.entites.Titre;
import com.tpappweb.app.entites.Utilistateur;
import com.tpappweb.app.service.interfaces.IPlayListServices;
import com.tpappweb.app.service.interfaces.IUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestControlleurPlayList {
    @Autowired
    private IPlayListServices iPlayListServices;
    @Autowired
     private IUtilisateurService iUtilisateurService;



    @GetMapping("utilisateurs/{pseudo}/playlists")
    public ResponseEntity<List<PlayList>> getUtilisateur(@PathVariable("pseudo") String pseudo) {
        Utilistateur utilistateur = iUtilisateurService.getUtilisateur(pseudo);
        List<PlayList> playLists = iPlayListServices.chercherPlayListsParUtilisateur(utilistateur);
        return new ResponseEntity<>(playLists, HttpStatus.OK);
    }

    @GetMapping("utilisateurs/{pseudo}/addPlayList")
    public ResponseEntity<PlayList> ajouterPlayList(@PathVariable("pseudo") String pseudo, @RequestParam("nom") String nom){
        Utilistateur utilistateur = iUtilisateurService.getUtilisateur(pseudo);
        PlayList playList = new PlayList();
        playList.setNom(nom);
        playList.setUtilistateur(utilistateur);
        iPlayListServices.ajouterPlaylist(playList);
        return new ResponseEntity<>(playList, HttpStatus.OK);
    }

    @GetMapping("utilisateurs/{pseudo}/supprimerPlayList/{id}")
        public ResponseEntity<Boolean> supprimerPlayList(@PathVariable("pseudo") String pseudo, @PathVariable("id") int id){
        //TODO Verifier si utilisateur dans la session
        PlayList playList = new PlayList() ;
        playList.setId(id);
        Boolean boo  = iPlayListServices.supprimerPlayList(playList);
       return new ResponseEntity<>(boo, HttpStatus.OK);
    }

    @GetMapping("utilisateurs/{pseudo}/playlist/{id}/ajouterTitre")
        public ResponseEntity<Boolean> ajouterTitre(@PathVariable("id") int id, @RequestParam("titreId") int titreId ){
        //TODO Exceptions
        PlayList playList = new PlayList();
        Titre titre = new Titre();
        playList.setId(id);
        titre.setId(titreId);
        Boolean b   = iPlayListServices.ajouterTitreALaPlaylist(playList, titre);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
    @GetMapping("utilisateurs/{pseudo}/playlist/{id}/supprimerTitre")
    public ResponseEntity<Boolean> supprimerTitreTitre(@PathVariable("id") int id, @RequestParam("titreId") int titreId ){
        //TODO Exceptions
        PlayList playList = new PlayList();
        Titre titre = new Titre();
        playList.setId(id);
        titre.setId(titreId);
        Boolean b   = iPlayListServices.supprimerTitreDeLaPlayList(playList, titre);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }

    @GetMapping("utilisateurs/{pseudo}/playlist/{id}")
    public ResponseEntity<PlayList> lirePlayList(@PathVariable ("id") int id){
       PlayList playList= iPlayListServices.chercherPlayListParID(id);
       return  new ResponseEntity<>(playList,HttpStatus.OK);
    }
    @GetMapping("/ajax/playlist/{genre}")
        public ResponseEntity<PlayList> lirePlayListParGenre(@PathVariable("genre") String genre){
        PlayList playList = iPlayListServices.creerPlaylistParGenre(genre);
        return new ResponseEntity<>(playList, HttpStatus.OK);
    }

}
