package com.tpappweb.app.dao;

import com.tpappweb.app.entites.PlayList;
import com.tpappweb.app.entites.Titre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PlayListTitreSQLDAO extends MySQLDAOJoin<PlayList, Titre> {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;




    @Override
    boolean ajouterUn(PlayList playList, Titre titre) {
        String sql = "INSERT INTO Titre_Playlist (titreId, playlistId) VALUES (:titreid,:playlistid)";
        MapSqlParameterSource mapSqlParameterSource= new MapSqlParameterSource();
        mapSqlParameterSource.addValue("titreid", titre.getId());
        mapSqlParameterSource.addValue("playlistid", playList.getId());
        return jdbcTemplate.update(sql, mapSqlParameterSource )==1;
    }

    @Override
    boolean supprimerUn(PlayList playList, Titre titre) {
        String sql = "DELETE FROM Titre_Playlist WHERE playlistId=:playlistid AND titreId=:titreid";
        MapSqlParameterSource mapSqlParameterSource= new MapSqlParameterSource();
        mapSqlParameterSource.addValue("titreid", titre.getId());
        mapSqlParameterSource.addValue("playlistid", playList.getId());
        return jdbcTemplate.update(sql, mapSqlParameterSource )==1;
    }

    @Override
    long supprimerTous(PlayList playList) {
        String sql = "DELETE FROM Titre_Playlist WHERE playlistId=:playlistid";
        MapSqlParameterSource mapSqlParameterSource= new MapSqlParameterSource();
        mapSqlParameterSource.addValue("playlistid", playList.getId());
        return jdbcTemplate.update(sql, mapSqlParameterSource );
    }
}
