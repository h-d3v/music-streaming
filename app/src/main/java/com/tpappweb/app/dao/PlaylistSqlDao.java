package com.tpappweb.app.dao;

import com.tpappweb.app.dao.romappers.PlaylistRowMapper;
import com.tpappweb.app.entites.PlayList;
import com.tpappweb.app.entites.Titre;
import com.tpappweb.app.entites.Utilistateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.apache.commons.lang3.NotImplementedException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PlaylistSqlDao extends MySQLDAO<PlayList>{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    /*Quand on créer une playlist, il n'y a pas de titre dans celle
     *  ci, donc on fait juste l'ajouté a la table playlist. Voir méthode ajouter titre
     * pour l'ajout d'un titre à une playlist.
    */
    public boolean create(PlayList x) {

            String sql = "INSERT INTO Playlist ( utilisateurPseudo, nom, dateCreation) values (?,?,?)";
            return jdbcTemplate.update(sql, x.getUtilistateur().getPseudo(), x.getNom(), LocalDateTime.now().toString()) == 1;

        }


    @Override
    public PlayList findById(String string) {
        throw new NotImplementedException();
    }

    @Override
    public PlayList findById(int x) {
        String sql = "SELECT id, utilisateurPseudo, nom, dateCreation FROM Playlist WHERE id=?";
        PlayList playList;
        playList= jdbcTemplate.queryForObject(sql, new PlaylistRowMapper(), x);

        return playList;
    }

    @Override
    public boolean deleteById(int id) {
        String sql ="DELETE FROM Playlist WHERE id = ?";

        return jdbcTemplate.update(sql, id)==1;
    }

    @Override
    public boolean delete(PlayList x) {
        String sql ="DELETE FROM Playlist WHERE id = ?";

        return jdbcTemplate.update(sql, x.getId())==1;
    }

    @Override
    public boolean update(PlayList x) {
        return false;
    }

    @Override
    public List<PlayList> findByObject(Object object) {
        if(object instanceof Utilistateur){
            String sql = "SELECT utilisateurPseudo, nom, Playlist.id, dateCreation FROM Playlist JOIN Utilisateur ON Playlist.utilisateurPseudo = Utilisateur.pseudo";
            return jdbcTemplate.query(sql, new PlaylistRowMapper());

        }

        return null;
    }

    @Override
    public List<PlayList> findAll() {
        return null;
    }
}
