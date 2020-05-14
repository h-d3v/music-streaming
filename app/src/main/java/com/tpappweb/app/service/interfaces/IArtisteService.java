package com.tpappweb.app.service.interfaces;

import com.tpappweb.app.entites.Artiste;

import java.util.List;

public interface IArtisteService {
    Artiste getArtisteByNom(String nom);
    boolean addArtiste(Artiste artiste);
    boolean updateArtiste(Artiste artiste);
    boolean deleteArtiste(String nom);
    List<Artiste> trouverTous();
}
