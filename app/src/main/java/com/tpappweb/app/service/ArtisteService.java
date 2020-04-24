package com.tpappweb.app.service;

import com.tpappweb.app.dao.ArtisteMySqlDao;
import com.tpappweb.app.entites.Artiste;
import com.tpappweb.app.service.interfaces.IArtisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public boolean addArtiste(Artiste artiste) {
        return false;
    }

    @Override
    public void updateArtiste(Artiste artiste) {

    }

    @Override
    public void deleteArtiste(int id) {

    }
}
