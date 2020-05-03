package com.tpappweb.app.dao;

import com.tpappweb.app.entites.PlayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
        String sql = "INSERT INTO playlist (id, utilisateurPseudo, nom) values (?,?,?)";
        return jdbcTemplate.update(sql, x.getId(),x.getUtilistateur().getPseudo(), x.getNom())==1;
    }

    @Override
    public PlayList findById(Object x) {
        String sql = "SELECT id, utilisateurPseudo, nom FROM playlist WHERE id = ?";
        //Todo trouver une facon d'instancier tous les titre d'une meme playlist.
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public boolean delete(PlayList x) {
        return false;
    }

    @Override
    public boolean update(PlayList x) {
        return false;
    }

    @Override
    public List<PlayList> findAll() {
        return null;
    }
}
