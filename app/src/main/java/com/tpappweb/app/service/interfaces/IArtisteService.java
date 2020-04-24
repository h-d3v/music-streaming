package com.tpappweb.app.service.interfaces;

import com.tpappweb.app.entites.Artiste;

import java.util.List;

public interface IArtisteService {
    Artiste getArtisteById(int id);
    boolean addArtiste(Artiste artiste);
    void updateArtiste(Artiste artiste);
    void deleteArtiste(int id);
    List<Artiste> trouverTous();
}
