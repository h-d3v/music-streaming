package com.tpappweb.app.dao;

import com.tpappweb.app.entites.Utilistateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UtilisateurSqlDao extends MySQLDAO<Utilistateur>{
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Override
    public boolean create(Utilistateur x) {
        String sql="INSERT INTO Utilisateur VALUES (:pseudo,:courriel,:motPasse)";
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(x);
        return jdbcTemplate.update(sql, sqlParameterSource)==1;
    }

    @Override
    public Utilistateur findById(Object x) {
        String sql ="SELECT pseudo, courriel, motPasse  FROM Utilisateur WHERE pseudo=:pseudo ";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("pseudo", x);
        return (Utilistateur) jdbcTemplate.queryForObject(sql,mapSqlParameterSource,new BeanPropertyRowMapper(Utilistateur.class));
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public boolean delete(Utilistateur x) {
        String sql= "DELETE FROM Utilisateur WHERE pseudo=:pseudo";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("pseudo", x.getPseudo());
        int w =jdbcTemplate.update(sql, new BeanPropertySqlParameterSource(x));
        return w==1;
    }

    @Override
    public boolean update(Utilistateur x) {
        String sql= "UPDATE Utilisateur SET courriel=:courriel, motPasse=:motPasse WHERE pseudo=:pseudo";
        int i=jdbcTemplate.update(sql, new BeanPropertySqlParameterSource(x));
        return i==1;
    }

    @Override
    public List<Utilistateur> findAll() {
        String sql = "SELECT * FROM Utilisateur";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Utilistateur>(Utilistateur.class));
    }
}
