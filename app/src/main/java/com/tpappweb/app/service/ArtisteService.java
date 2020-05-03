package com.tpappweb.app.service;

import com.tpappweb.app.dao.ArtisteSqlDao;
import com.tpappweb.app.entites.Artiste;
import com.tpappweb.app.service.interfaces.IArtisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtisteService implements IArtisteService {

    @Autowired
    private ArtisteSqlDao artisteSqlDao;

    @Override
    public Artiste getArtisteById(int id) {
        Artiste artiste= artisteSqlDao.findById(id);
        return artiste;
    }

    @Override
    public synchronized boolean addArtiste(Artiste artiste) {
        if (artisteSqlDao.artisteExists(artiste.getId())) {
            return false;
        } else {
           return artisteSqlDao.create(artiste);
        }
    }

    @Override
    public boolean updateArtiste(Artiste artiste) {
        return artisteSqlDao.update(artiste);
    }

    @Override
    public boolean deleteArtiste(int id) {
        return artisteSqlDao.deleteById(id);
    }

    @Override
    public List<Artiste> trouverTous() {
        return artisteSqlDao.findAll();
    }


}
