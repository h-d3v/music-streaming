package com.tpappweb.app.service;
import com.tpappweb.app.dao.UtilisateurAbonneSQLDAO;
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
    @Autowired
    private UtilisateurAbonneSQLDAO utilisateurAbonneSQLDAO;

    @Override
    public boolean ajouterUtilisateur(Utilistateur utilistateur) {
        return utilisateurSqlDao.create(utilistateur);
    }

    @Override
    public boolean modifierMotPasse(Utilistateur utilistateur, String nouveauMotPasse) {
        //mot de passe, courriel et pseudo comme dans la base de donnees
        if(utilistateur.equals(getUtilisateur(utilistateur.getPseudo()))){
            /***
             * TODO if(validerReglesDuMotPasse(nouveauMotPasse){
             *
             *    code non commente ci dessous
             *
             *     return true;
             * }else return false;
             */
            utilistateur.setMotPasse(nouveauMotPasse);
            return utilisateurSqlDao.update(utilistateur);

        }

        return false;
    }

    @Override
    public boolean supprimerUtilisateur(Utilistateur utilistateur) {
        return false;
    }

    @Override
    public boolean ajouterAbonne(Utilistateur utilistateur, Utilistateur utilistateurAAjouter) {
       return utilisateurAbonneSQLDAO.ajouterUn(utilistateur, utilistateurAAjouter);

    }

    @Override
    public boolean supprimmerAbonne(Utilistateur utilistateur, Utilistateur utilistateurASupprimer) {
        return utilisateurAbonneSQLDAO.supprimerUn(utilistateur, utilistateurASupprimer);
    }

    @Override
    public Utilistateur getUtilisateur(String pseudo) {
        return utilisateurSqlDao.findById(pseudo);
    }

    @Override
    public List<Utilistateur> trouverTous() {
        return utilisateurSqlDao.findAll();
    }

    @Override
    public List<Utilistateur> trouverAbonnes(Utilistateur utilistateur) {
        return utilisateurAbonneSQLDAO.charger(utilistateur);
    }
}
