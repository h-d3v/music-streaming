package com.tpappweb.app.dao.romappers;

import com.tpappweb.app.entites.LikeOuDislike;
import com.tpappweb.app.entites.Titre;
import com.tpappweb.app.entites.Utilistateur;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LikeOuDislikeRowMapper implements RowMapper<LikeOuDislike> {
    @Override
    public LikeOuDislike mapRow(ResultSet resultSet, int i) throws SQLException {
        LikeOuDislike likeOuDislike = new LikeOuDislike();
        Titre titre = new Titre();
        titre.setId(resultSet.getInt("titreId"));
        Utilistateur utilistateur = new Utilistateur();
        utilistateur.setPseudo(resultSet.getString("utilisateurPseudo"));
        likeOuDislike.setTitreId(titre);
        likeOuDislike.setUtilistateurPseudo(utilistateur);
        likeOuDislike.setLikeOuDislike(resultSet.getBoolean("likeOuDislike"));
        return likeOuDislike;
    }
}
