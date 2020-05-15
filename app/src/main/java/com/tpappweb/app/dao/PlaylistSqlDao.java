package com.tpappweb.app.dao;

import com.tpappweb.app.entites.PlayList;
import com.tpappweb.app.entites.Titre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
        if(x.getListeTitres().size()==0) {
            String sql = "INSERT INTO Playlist ( utilisateurPseudo, nom, dateCreation) values (?,?,?)";
            return jdbcTemplate.update(sql, x.getUtilistateur().getPseudo(), x.getNom(), LocalDateTime.now().toString()) == 1;
        }
        else{
            KeyHolder keyHolder = new GeneratedKeyHolder();
            String sql = "INSERT INTO Playlist ( utilisateurPseudo, nom, dateCreation) values (?,?,?)";
            String finalSql = sql;
            jdbcTemplate.update(new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                    PreparedStatement preparedStatement = connection.prepareStatement(finalSql, Statement.RETURN_GENERATED_KEYS);
                    preparedStatement.setString(1,x.getUtilistateur().getPseudo());
                    preparedStatement.setString(2, x.getNom());
                    preparedStatement.setString(3, LocalDateTime.now().toString());
                    return preparedStatement;
                }
            }, keyHolder);
            sql= "INSERT INTO Titre_Playlist(titreId, playlistId) VALUES (?,?)";
            int clePlayListId = keyHolder.getKey().intValue();
            boolean valide = true;
            for(Titre titre:x.getListeTitres()){
                valide= valide && jdbcTemplate.update(sql,titre.getId(), clePlayListId)==1;
            }
            return valide;
        }
    }

    @Override
    public PlayList findById(String string) {
        throw new NotImplementedException();
    }

    @Override
    public PlayList findById(int x) {
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
    public List<PlayList> findByObject(Object object) {
        return null;
    }

    @Override
    public List<PlayList> findAll() {
        return null;
    }
}
