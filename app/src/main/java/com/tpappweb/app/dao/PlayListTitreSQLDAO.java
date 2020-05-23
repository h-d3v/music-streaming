package com.tpappweb.app.dao;

import com.tpappweb.app.entites.PlayList;
import com.tpappweb.app.entites.Titre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PlayListTitreSQLDAO extends MySQLDAOJoin<PlayList, Titre> {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;




    @Override
    public boolean ajouterUn(PlayList playList, Titre titre) {
        String sql = "INSERT INTO Titre_Playlist (titreId, playlistId) VALUES (:titreid,:playlistid)";
        MapSqlParameterSource mapSqlParameterSource= new MapSqlParameterSource();
        mapSqlParameterSource.addValue("titreid", titre.getId());
        mapSqlParameterSource.addValue("playlistid", playList.getId());
        return jdbcTemplate.update(sql, mapSqlParameterSource )==1;
    }

    @Override
    public boolean supprimerUn(PlayList playList, Titre titre) {
        String sql = "DELETE FROM Titre_Playlist WHERE playlistId=:playlistid AND titreId=:titreid";
        MapSqlParameterSource mapSqlParameterSource= new MapSqlParameterSource();
        mapSqlParameterSource.addValue("titreid", titre.getId());
        mapSqlParameterSource.addValue("playlistid", playList.getId());
        return jdbcTemplate.update(sql, mapSqlParameterSource )==1;
    }

    @Override
    public  long supprimerTous(PlayList playList) {
        String sql = "DELETE FROM Titre_Playlist WHERE playlistId=:playlistid";
        MapSqlParameterSource mapSqlParameterSource= new MapSqlParameterSource();
        mapSqlParameterSource.addValue("playlistid", playList.getId());
        return jdbcTemplate.update(sql, mapSqlParameterSource );
    }

    @Override
    public List<Titre> charger(PlayList playList) {
        String sql ="SELECT id, nomArtiste, nom, url, duree, urlImage, dateSortie, genre, titreAlbum " +
                "FROM Titre JOIN Titre_Playlist TP ON Titre.id = TP.titreId WHERE TP.playlistId=:id";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id", playList.getId());
        return jdbcTemplate.query(sql,mapSqlParameterSource, new BeanPropertyRowMapper<>(Titre.class));
    }
}
