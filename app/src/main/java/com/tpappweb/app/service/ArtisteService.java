package com.tpappweb.app.service;

import com.tpappweb.app.dao.ArtisteMySqlDao;
import com.tpappweb.app.entites.Artiste;
import com.tpappweb.app.service.interfaces.IArtisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtisteService implements IArtisteService {

    @Autowired
    private ArtisteMySqlDao artisteMySqlDao;

    @Override
    public Artiste getArtisteById(int id) {
        Artiste artiste=artisteMySqlDao.findById(id);
        return artiste;
    }

    @Override
    public synchronized boolean addArtiste(Artiste artiste) {
        if (artisteMySqlDao.artisteExists(artiste.getId())) {
            return false;
        } else {
           return artisteMySqlDao.create(artiste);
        }
    }

    @Override
    public boolean updateArtiste(Artiste artiste) {
        return artisteMySqlDao.update(artiste);
    }

    @Override
    public boolean deleteArtiste(int id) {
        return artisteMySqlDao.deleteById(id);
    }

    @Override
    public List<Artiste> trouverTous() {
        return artisteMySqlDao.findAll();
    }


}
