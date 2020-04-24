package com.tpappweb.app.dao.romappers;

import com.tpappweb.app.entites.Artiste;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtisteRowMapper implements RowMapper<Artiste> {
    @Override
    public Artiste mapRow(ResultSet rs, int i) throws SQLException {

        Artiste artiste=new Artiste();
        System.out.print(artiste.getId());
        artiste.setId(rs.getInt("id"));
        artiste.setNom(rs.getString("nom"));
        artiste.setBiographie(rs.getString("biorgraphie"));
        artiste.setUrlPhoto(rs.getString("urlPhoto"));

        return artiste;
    }
}
