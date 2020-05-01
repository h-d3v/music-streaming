package com.tpappweb.app.service.interfaces;

import com.tpappweb.app.entites.Artiste;

import java.util.List;

public interface IArtisteService {
    Artiste getArtisteById(int id);
    boolean addArtiste(Artiste artiste);
    boolean updateArtiste(Artiste artiste);
    boolean deleteArtiste(int id);
    List<Artiste> trouverTous();
}
