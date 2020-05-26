package com.tpappweb.app.service;

import com.tpappweb.app.dao.PlayListTitreSQLDAO;
import com.tpappweb.app.dao.PlaylistSqlDao;
import com.tpappweb.app.dao.TitreSqlDao;
import com.tpappweb.app.entites.PlayList;
import com.tpappweb.app.entites.Titre;
import com.tpappweb.app.entites.Utilistateur;
import com.tpappweb.app.service.interfaces.IPlayListServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PlayListService implements IPlayListServices {
    @Autowired
    private PlayListTitreSQLDAO playListTitreSQLDAO;
    @Autowired
    private PlaylistSqlDao playlistSqlDao;
    @Autowired
    private TitreSqlDao titreSqlDao;


    @Override
    public boolean ajouterPlaylist(PlayList playList) {
        return  playlistSqlDao.create(playList);
    }

    @Override
    public PlayList chercherPlayListParID(int id) {
        PlayList playList= playlistSqlDao.findById(id);
        playList.setListeTitres(playListTitreSQLDAO.charger(playList));
        return playList;
    }

    @Override
    public boolean supprimerPlayList(PlayList playList) {
        playListTitreSQLDAO.supprimerTous(playList);
        return playlistSqlDao.delete(playList);
    }

    @Override
    public boolean supprimerTitreDeLaPlayList(PlayList playList, Titre titre) {
        return playListTitreSQLDAO.supprimerUn(playList,titre);
    }

    @Override
    public boolean ajouterTitreALaPlaylist(PlayList playList, Titre titre) {
        return playListTitreSQLDAO.ajouterUn(playList, titre);
    }

    @Override
    public List<PlayList> chercherPlayListsParUtilisateur(Utilistateur utilistateur) {
        return playlistSqlDao.findByObject(utilistateur);
    }
    @Override
    public PlayList creerPlaylistParGenre(String genre){
        PlayList playList= new PlayList();
        List<Titre> titres= titreSqlDao.trouverTitreParGenre(genre);
        if(titres.size()==0){return null;}
        playList.setListeTitres(titres);
        playList.setNom(genre);
        return playList;
    }

}
