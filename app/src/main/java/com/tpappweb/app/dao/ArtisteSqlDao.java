package com.tpappweb.app.dao;

import com.tpappweb.app.entites.Artiste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class ArtisteSqlDao extends MySQLDAO<Artiste> {

   @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean create(Artiste x) {
        String sql = "INSERT INTO Artiste (id, nom, biographie, urlPhoto) values (?,?,?,?)";
        return jdbcTemplate.update(sql, x.getId(),x.getNom(), x.getBiographie(), x.getUrlPhoto())==1;
    }

    @Override
    public Artiste findById(Object id) {
        String sql = "SELECT id, nom, prenom, biographie, pays, urlPhoto FROM Artiste WHERE id = ?";
        return jdbcTemplate.queryForObject(sql ,new BeanPropertyRowMapper<>(Artiste.class), id);
    }

    @Override
    public boolean deleteById(int id) {
        String sql = "DELETE FROM Artiste  WHERE id = ?";
        jdbcTemplate.update(sql, id);
        return true;
    }

    @Override
    public boolean delete(Artiste x) {
        return false;
    }

    @Override
    public boolean update(Artiste artiste) {
        String sql = "UPDATE Artiste SET nom=?, biographie=?,urlPhoto=? WHERE id=?";
        return jdbcTemplate.update(sql, artiste.getNom(), artiste.getBiographie(), artiste.getUrlPhoto(), artiste.getId())==1;
    }

    @Override
    public List<Artiste> findAll() {
        String sql = "SELECT id, nom, prenom, biographie, pays, urlPhoto FROM Artiste";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Artiste.class));
    }

    public boolean artisteExists(int id) {
        String sql = "SELECT count(*) FROM Artiste WHERE id = ? ";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return count != 0;
    }

}
