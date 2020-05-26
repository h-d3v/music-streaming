package com.tpappweb.app.service.interfaces;

import com.tpappweb.app.entites.PlayList;
import com.tpappweb.app.entites.Titre;
import com.tpappweb.app.entites.Utilistateur;
import java.util.List;



public interface IPlayListServices{
   boolean ajouterPlaylist(PlayList playList);

   PlayList chercherPlayListParID(int id);
   boolean supprimerPlayList(PlayList playList);
   boolean supprimerTitreDeLaPlayList(PlayList playList, Titre titre);
   boolean ajouterTitreALaPlaylist(PlayList playList, Titre titre);
   List<PlayList> chercherPlayListsParUtilisateur(Utilistateur utilistateur);


    PlayList creerPlaylistParGenre(String genre);
}
