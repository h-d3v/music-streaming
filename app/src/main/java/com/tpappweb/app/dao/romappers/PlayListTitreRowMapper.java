package com.tpappweb.app.dao.romappers;

import com.tpappweb.app.entites.Titre;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayListTitreRowMapper  implements RowMapper<Titre> {
    @Override
    public Titre mapRow(ResultSet resultSet, int i) throws SQLException {
        Titre titre = new Titre();
        titre.setId(resultSet.getInt("titreId"));
        return null;
    }
}
