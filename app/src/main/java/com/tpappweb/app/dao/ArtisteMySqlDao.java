package com.tpappweb.app.dao;

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
    private JdbcTemplate jdbcTemplate= new JdbcTemplate();

    @Override
    public boolean create(Artiste x) {
        return false;
    }

    @Override
    public Artiste findById(int id) {
        String sql = "SELECT id, nom, prenom, biographie, pays, urlPhoto FROM artiste WHERE id = ?";
        RowMapper<Artiste> rowMapper = new BeanPropertyRowMapper<>(Artiste.class);
        Artiste artiste = jdbcTemplate.queryForObject(sql, rowMapper, id);
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
        return null;
    }
}
