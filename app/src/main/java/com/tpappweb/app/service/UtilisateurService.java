package com.tpappweb.app.service;

import com.tpappweb.app.dao.UtilisateurSqlDao;
import com.tpappweb.app.entites.Utilistateur;
import com.tpappweb.app.service.interfaces.IUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService implements IUtilisateurService {
    @Autowired
    private UtilisateurSqlDao utilisateurSqlDao;

    @Override
    public boolean ajouterUtilisateur(Utilistateur utilistateur) {
        return  utilisateurSqlDao.create(utilistateur);
    }

    @Override
    public boolean modifierMotPasse(Utilistateur utilistateur, String motPasse) {
        return false;
    }

    @Override
    public boolean supprimerUtilisateur(Utilistateur utilistateur) {
        utilisateurSqlDao.delete(utilistateur);
        //TODO mauvais retour
        return false;
    }

    @Override
    public boolean ajouterAbonne(Utilistateur utilistateur, Utilistateur utilistateurAAjouter) {
        return false;
    }

    @Override
    public boolean supprimmerAbonne(Utilistateur utilistateur, Utilistateur utilistateurASupprimer) {
        return false;
    }

    @Override
    public Utilistateur getUtilisateur(String pseudo) {
        return utilisateurSqlDao.findById(pseudo);
    }

    @Override
    public List<Utilistateur> trouverTous() {
        return utilisateurSqlDao.findAll();
    }
}
