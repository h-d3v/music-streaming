package com.tpappweb.app.service.interfaces;

import com.tpappweb.app.entites.Artiste;

public interface IArtisteService {
    Artiste getArtisteById(int id);
    boolean addArtiste(Artiste artiste);
    void updateArtiste(Artiste artiste);
    void deleteArtiste(int id);
}
