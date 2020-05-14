package com.tpappweb.app.dao.romappers;

import com.tpappweb.app.dao.TitreSqlDao;
import com.tpappweb.app.dao.UtilisateurSqlDao;
import com.tpappweb.app.entites.Commentaire;
import com.tpappweb.app.entites.Titre;
import com.tpappweb.app.entites.Utilistateur;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentaireRowMapper implements RowMapper<Commentaire> {
    @Override
    public Commentaire mapRow(ResultSet resultSet, int i) throws SQLException {
        Titre titre = new Titre();
        Utilistateur utilistateur= new Utilistateur();
        utilistateur.setPseudo(resultSet.getString("utilisateurPseudo"));
        titre.setId(resultSet.getInt("titreid"));

        Commentaire commentaire= new Commentaire();
        commentaire.setCommentaire(resultSet.getString("commentaire"));
        commentaire.setDate(resultSet.getDate("date"));
        commentaire.setId(resultSet.getInt("id"));
        commentaire.setUtilistateur(utilistateur);
        commentaire.setTitre(titre);
        return commentaire;
    }
}
