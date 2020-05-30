package com.tpappweb.app.dao.romappers;

import com.tpappweb.app.entites.Commentaire;
import com.tpappweb.app.entites.Utilistateur;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AbonneRowMapper implements RowMapper<Utilistateur> {
    @Override
    public Utilistateur mapRow(ResultSet resultSet, int i) throws SQLException {
        Utilistateur abonne = new Utilistateur();
        abonne.setPseudo(resultSet.getString("abonne"));
        return abonne;
    }
}
