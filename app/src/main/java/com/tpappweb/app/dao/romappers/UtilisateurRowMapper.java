package com.tpappweb.app.dao.romappers;
import com.tpappweb.app.entites.Utilistateur;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilisateurRowMapper  implements RowMapper<Utilistateur> {

    @Override
    public Utilistateur mapRow(ResultSet resultSet, int i) throws SQLException {
        Utilistateur utilistateur= new Utilistateur();
        utilistateur.setPseudo(resultSet.getString("pseudo"));
        utilistateur.setCourriel(resultSet.getString("courriel"));
        utilistateur.setMotPasse(resultSet.getString("motPasse"));
        utilistateur.setEstAdmin(resultSet.getBoolean("estAdmin"));
        return utilistateur;
    }
}
