package com.tpappweb.app.dao;

import com.tpappweb.app.entites.Titre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

@Repository
public class TitreSqlDao extends MySQLDAO<Titre> {


    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public boolean create(Titre x) {
        //id int(10) NOT NULL AUTO_INCREMENT, artisteId int(10) NOT NULL, nom , url  , duree time, urlImage , dateSortie , genre, titreAlbum
        String sql="INSERT INTO Titre(nomArtiste, nom, url, duree, urlImage, dateSortie, genre, titreAlbum) VALUES (?,?,?,?,?,?,?,?)";

        return jdbcTemplate.update(sql, x.getNomArtiste(),x.getNom(),x.getUrl(),x.getDuree(),x.getUrlImage(),x.getDateSortie(),x.getGenre(),x.getTitreAlbum())==1;
    }

    @Override
    public Titre findById(String string) {
        throw new NotImplementedException();
    }

    @Override
    public Titre findById(int id) {
        String sql="SELECT id, nomArtiste, nom, url, urlImage, dateSortie, titreAlbum FROM Titre WHERE id=?";
        return jdbcTemplate.queryForObject(sql ,new BeanPropertyRowMapper<>(Titre.class), id);
    }

    @Override
    public boolean deleteById(int id) {
        String sql = "DELETE FROM Titre  WHERE id = ?";
        return jdbcTemplate.update(sql, id)==1;
    }

    @Override
    public boolean delete(Titre x) {
        throw new NotImplementedException();
    }

    @Override
    public boolean update(Titre x) {
        String sql = "UPDATE Titre SET nom=?, url=?,urlImage=?, titreAlbum=? WHERE id=?";
        return jdbcTemplate.update(sql, x.getNom(),x.getUrl(),x.getUrlImage(), x.getTitreAlbum(), x.getId())==1;
    }

    @Override
    public List<Titre> findByObject(Object object) {
        throw new NotImplementedException();
    }

    @Override
    public List<Titre> findAll() {
        String sql = "SELECT * FROM Titre";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Titre.class));
    }
}
