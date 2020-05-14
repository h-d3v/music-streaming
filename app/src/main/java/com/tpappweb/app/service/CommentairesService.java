package com.tpappweb.app.service;

import com.tpappweb.app.dao.CommentaireSQLDAO;
import com.tpappweb.app.entites.Commentaire;
import com.tpappweb.app.entites.Titre;
import com.tpappweb.app.entites.Utilistateur;
import com.tpappweb.app.service.interfaces.ICommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentairesService implements ICommentaireService {

    @Autowired
    private CommentaireSQLDAO commentaireSQLDAO;

    @Override
    public boolean ajouterCommentaire(Commentaire commentaire) {
       return commentaireSQLDAO.create(commentaire);
    }

    @Override
    public boolean supprimmerCommentaire(Commentaire commentaire) {
        return commentaireSQLDAO.delete(commentaire);
    }

    @Override
    public boolean modifierCommentaire(Commentaire commentaire) {
        return commentaireSQLDAO.update(commentaire);
    }

    @Override
    public List<Commentaire> chercherCommentairesParUtilisateur(Utilistateur utilistateur) {
        return commentaireSQLDAO.findByObject(utilistateur);
    }

    @Override
    public List<Commentaire> chercherCommentairesParTitre(Titre titre) {
        return commentaireSQLDAO.findByObject(titre);
    }

    @Override
    public boolean supprimmerCommentairesParUtilisateur(Utilistateur utilistateur) {
        List<Commentaire> commentairesASupprimer= commentaireSQLDAO.findByObject(utilistateur);
        for (Commentaire commentaire : commentairesASupprimer){
            commentaireSQLDAO.delete(commentaire);
        }
        return commentaireSQLDAO.findByObject(utilistateur).size()==0;
    }

    @Override
    public boolean supprimerCommentairesParTitre(Titre titre) {
        List<Commentaire> commentairesASupprimer= commentaireSQLDAO.findByObject(titre);
        for (Commentaire commentaire : commentairesASupprimer){
            commentaireSQLDAO.delete(commentaire);
        }
        return commentaireSQLDAO.findByObject(titre).size()==0;
    }

    @Override
    public boolean supprimerComentaireParId(int id) {
        return commentaireSQLDAO.deleteById(id);
    }

    @Override
    public Commentaire chercherCommentaireParId(int id) {
        return commentaireSQLDAO.findById(id);
    }

}
