package com.tpappweb.app.dao;


import com.tpappweb.app.entites.LikeOrDislike;
import com.tpappweb.app.entites.Utilistateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.List;

public class LikeOrDislikeSQLDAO extends MySQLDAO<LikeOrDislike> {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public boolean create(LikeOrDislike x) {
        String sql="INSERT INTO LikeOuDislike VALUES (1,:likeOrDislike,:titreId,:utilisateurPseudo)";
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(x);
        return jdbcTemplate.update(sql, sqlParameterSource)==1;
    }

    @Override
    public LikeOrDislike findById(Object x) {
        String sql="SELECT id, likeOuDislike, titreId, utilisateurPseudo FROM LikeOuDislike WHERE id=:id";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id", x);
        return (LikeOrDislike) jdbcTemplate.queryForObject(sql,mapSqlParameterSource,new BeanPropertyRowMapper(LikeOrDislike.class));

    }

    @Override
    public boolean deleteById(int id) {

        String sql= "DELETE FROM LikeOuDislike WHERE id=:id";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id", id);
        int w =jdbcTemplate.update(sql, mapSqlParameterSource);
        return w==1;
    }

    @Override
    public boolean delete(LikeOrDislike x) {
        String sql= "DELETE FROM LikeOuDislike WHERE id=:id";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id", x.getId());
        int w =jdbcTemplate.update(sql, new BeanPropertySqlParameterSource(x));
        return w==1;
    }

    @Override
    public boolean update(LikeOrDislike x) {
        String sql= "UPDATE LikeOuDislike SET likeOuDislike=:likeOuDislike" +
                   " WHERE titreId=:titreId AND utilisateurPseudo=:utilisateurPseudo AND id=:id";
        int i=jdbcTemplate.update(sql, new BeanPropertySqlParameterSource(x));
        return i==1;
    }

    @Override
    public List<LikeOrDislike> findAll() {
        String sql="SELECT * FROM LikeOuDislike";

        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<LikeOrDislike>());
    }
}
