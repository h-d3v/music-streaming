package com.tpappweb.app.service;


import com.tpappweb.app.dao.ArtisteSqlDao;
import com.tpappweb.app.dao.TitreSqlDao;
import com.tpappweb.app.entites.Artiste;
import com.tpappweb.app.entites.Titre;
import com.tpappweb.app.service.interfaces.ITitreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitreService implements ITitreService {
    @Autowired
    TitreSqlDao titreSqlDao;
    @Autowired
    private ArtisteSqlDao artisteSqlDao;

    @Override
    public Titre getTitreById(int id){
        return titreSqlDao.findById(id);
    }

    @Override
    public boolean addTitre(Titre titre) {
        //TODO verifier s'il existe deja

        //Verifier si l'artiste existe deja dans la bd
        if(artisteSqlDao.artisteExists(titre.getNomArtiste())){

            return titreSqlDao.create(titre);
        }
        else{
            Artiste artiste=new Artiste();
            artiste.setNom(titre.getNomArtiste());
            artisteSqlDao.create(artiste);
            return titreSqlDao.create(titre);
        }


    }

    @Override
    public boolean updateTitre(Titre titre) {
        return titreSqlDao.update(titre);
    }

    @Override
    public boolean deleteTitre(int id) {
        return titreSqlDao.deleteById(id);
    }

    @Override
    public List<Titre> trouverTous() {
        return titreSqlDao.findAll();
    }
}
