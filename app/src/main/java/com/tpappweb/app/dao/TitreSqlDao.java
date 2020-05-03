package com.tpappweb.app.dao;

import com.tpappweb.app.entites.Titre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TitreSqlDao extends MySQLDAO<Titre> {


    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public boolean create(Titre x) {
        String sql="INSERT INTO titre (id, artisteId, nom, url, urlImage, TitreAlbum) VALUES (?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, x.getId(), x.getArtiste().getId(),x.getNom(),x.getUrl(),x.getUrlImage(),x.getTitreAlbum())==1;
    }

    @Override
    public Titre findById(Object id) {
        String sql="SELECT id, artisteId, nom, url, urlImage, dateSortie, TitreAlbum FROM titre WHERE id=?";
        return jdbcTemplate.queryForObject(sql ,new BeanPropertyRowMapper<>(Titre.class), id);
    }

    @Override
    public boolean deleteById(int id) {
        String sql = "DELETE FROM titre  WHERE id = ?";
        return jdbcTemplate.update(sql, id)==1;
    }

    @Override
    public boolean delete(Titre x) {
        return false;
    }

    @Override
    public boolean update(Titre x) {
        String sql = "UPDATE titre SET nom=?, url=?,urlImage=?, TitreAlbum=? WHERE id=?";
        return jdbcTemplate.update(sql, x.getNom(),x.getUrl(),x.getUrlImage(), x.getTitreAlbum(), x.getId())==1;
    }

    @Override
    public List<Titre> findAll() {
        String sql = "SELECT id, artisteId, nom, url, duree, urlImage, dateSortie, genre, TitreAlbum FROM titre";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Titre.class));
    }
}
