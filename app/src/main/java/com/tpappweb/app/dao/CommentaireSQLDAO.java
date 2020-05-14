package com.tpappweb.app.dao;

import com.tpappweb.app.dao.romappers.CommentaireRowMapper;
import com.tpappweb.app.entites.Commentaire;
import com.tpappweb.app.entites.Titre;
import com.tpappweb.app.entites.Utilistateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class CommentaireSQLDAO extends MySQLDAO<Commentaire> {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public boolean create(Commentaire x) {
        String sql="INSERT INTO Commentaire(titreid, utilisateurPseudo, commentaire, date) VALUES (:titreid, :utilisateur, :commentaire, :date )";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("utilisateur", x.getUtilistateur().getPseudo());
        mapSqlParameterSource.addValue("titreid", x.getTitre().getId());
        mapSqlParameterSource.addValue("commentaire",x.getCommentaire());
        mapSqlParameterSource.addValue("date", LocalDateTime.now().toString());
        return jdbcTemplate.update(sql, mapSqlParameterSource)==1 ;
    }

    @Override
    public Commentaire findById(String string) {
        throw new NotImplementedException();

    }

    @Override
    public Commentaire findById(int x) {
        String sql = "SELECT * FROM Commentaire WHERE id=:id";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id", x);

        return jdbcTemplate.queryForObject(sql, mapSqlParameterSource,new CommentaireRowMapper());
    }

    @Override
    public boolean deleteById(int id) {
        String sql = "DELETE FROM Commentaire WHERE id=:id";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id", id);
        return jdbcTemplate.update(sql,mapSqlParameterSource)==1;
    }

    @Override
    public boolean delete(Commentaire x) {
        String sql = "DELETE FROM Commentaire WHERE id=:id";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id", x.getId());
        return jdbcTemplate.update(sql,mapSqlParameterSource)==1;
    }

    @Override
    public boolean update(Commentaire x) {

        String sql = "UPDATE Commentaire SET commentaire=:commentaire, date=:date  WHERE id=:id";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id", x.getId());
        mapSqlParameterSource.addValue("commentaire", x.getCommentaire());
        mapSqlParameterSource.addValue("date", LocalDateTime.now().toString());
        return jdbcTemplate.update(sql,mapSqlParameterSource)==1;
    }

    @Override
    public List<Commentaire> findByObject(Object object) {
        if(object instanceof Utilistateur){
            String sql = "SELECT * FROM Commentaire WHERE utilisateurPseudo=:utilisateur";
            MapSqlParameterSource mapSqlParameterSource= new MapSqlParameterSource();
            mapSqlParameterSource.addValue("utilisateur", ((Utilistateur) object).getPseudo());
            return jdbcTemplate.query(sql,mapSqlParameterSource, new CommentaireRowMapper());
        }
        else if(object instanceof Titre){
            String sql = "SELECT * FROM Commentaire WHERE titreid=:titre";
            MapSqlParameterSource mapSqlParameterSource= new MapSqlParameterSource();
            mapSqlParameterSource.addValue("titre", ((Titre) object).getId());
            return jdbcTemplate.query(sql, mapSqlParameterSource, new CommentaireRowMapper());
        }
        else throw new NotImplementedException();
    }

    @Override
    public List<Commentaire> findAll() {
        String sql = "SELECT * FROM Commentaire";
        return jdbcTemplate.query(sql, new CommentaireRowMapper());
    }
}
