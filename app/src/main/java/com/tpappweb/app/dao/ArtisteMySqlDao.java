package com.tpappweb.app.dao;

import com.tpappweb.app.dao.romappers.ArtisteRowMapper;
import com.tpappweb.app.entites.Artiste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class ArtisteMySqlDao extends MySQLDAO<Artiste> {

   @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean create(Artiste x) {
        return false;
    }

    @Override
    public Artiste findById(Object id) {
        String sql = "SELECT id, nom, prenom, biographie, pays, urlPhoto FROM Artiste WHERE id = ?";
        Artiste artiste =(Artiste) jdbcTemplate.queryForObject(sql , new Object[]{id} ,new BeanPropertyRowMapper(Artiste.class));
        return artiste;
    }

    @Override
    public boolean delete(Artiste x) {
        return false;
    }

    @Override
    public boolean update(Artiste x) {
        return false;
    }


    @Override
    public List<Artiste> findAll() {
        String sql = "SELECT id, nom, prenom, biographie, pays, urlPhoto FROM Artiste";
        List<Artiste> artistes= jdbcTemplate.query(sql,new BeanPropertyRowMapper(Artiste.class));
        return artistes;
    }
}
