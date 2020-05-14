package com.tpappweb.app.dao.romappers;

import com.tpappweb.app.dao.TitreSqlDao;
import com.tpappweb.app.dao.UtilisateurSqlDao;
import com.tpappweb.app.entites.Commentaire;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentaireRowMapper implements RowMapper<Commentaire> {
    @Override
    public Commentaire mapRow(ResultSet resultSet, int i) throws SQLException {
        UtilisateurSqlDao utilisateurSqlDao= new UtilisateurSqlDao();
        TitreSqlDao titreSqlDao = new TitreSqlDao();

        Commentaire commentaire= new Commentaire();
        commentaire.setCommentaire(resultSet.getString("commentaire"));
        commentaire.setDate(resultSet.getDate("date"));
        commentaire.setId(resultSet.getInt("id"));
        commentaire.setTitre(titreSqlDao.findById(resultSet.getInt("titreid")));
        commentaire.setUtilistateur(utilisateurSqlDao.findById(resultSet.getString("utilisateurPseudo")));

        return commentaire;
    }
}
