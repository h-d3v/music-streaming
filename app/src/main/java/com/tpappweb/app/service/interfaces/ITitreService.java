package com.tpappweb.app.service.interfaces;

import com.tpappweb.app.entites.Artiste;
import com.tpappweb.app.entites.Titre;

import java.util.List;

public interface ITitreService {
    Titre getTitreById(int id);
    boolean addTitre(Titre titre);
    boolean updateTitre(Titre titre);
    boolean deleteTitre(int id);
    List<Titre> trouverTous();
}
