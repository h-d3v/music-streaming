package com.tpappweb.app.dao.romappers;

import com.tpappweb.app.dao.ArtisteSqlDao;
import com.tpappweb.app.entites.Artiste;
import com.tpappweb.app.entites.Titre;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TitreRowMapper implements RowMapper<Titre> {

    @Override
public Titre mapRow(ResultSet rs, int i) throws SQLException {
            ArtisteSqlDao artisteSqlDao = new ArtisteSqlDao();
            Titre titre=new Titre();
            titre.setId(rs.getInt("id"));
            titre.setNom(rs.getString("nom"));
            titre.setUrl(rs.getString("url"));
            titre.setUrlImage(rs.getString("urlPhoto"));
            //Recherche de l'artiste du titre
            Artiste artiste= artisteSqlDao.findById(rs.getInt("artisteId"));
            titre.setArtiste(artiste);
            return titre;
        }
}
