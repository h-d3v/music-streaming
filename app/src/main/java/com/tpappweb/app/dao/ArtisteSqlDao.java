package com.tpappweb.app.dao;

import com.tpappweb.app.entites.Artiste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang3.NotImplementedException;
import java.util.List;

@Transactional
@Repository
public class ArtisteSqlDao extends MySQLDAO<Artiste> {

   @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean create(Artiste x) {
        String sql = "INSERT INTO Artiste (nom, biographie, urlPhoto) values (?,?,?)";
        return jdbcTemplate.update(sql,x.getNom(), x.getBiographie(), x.getUrlPhoto())==1;
    }

    @Override
    public Artiste findById(String string) {
        throw new NotImplementedException();
    }

    @Override
    public Artiste findById(int id) {
       throw new NotImplementedException();
    }

    @Override
    public boolean deleteById(int id) {
        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Artiste x) {
        return false;
    }

    @Override
    public boolean update(Artiste artiste) {
        String sql = "UPDATE Artiste SET biographie=?,urlPhoto=? WHERE nom=?";
        return jdbcTemplate.update(sql, artiste.getBiographie(), artiste.getUrlPhoto(), artiste.getNom())==1;
    }

    @Override
    public List<Artiste> findByObject(Object object) {
        throw  new NotImplementedException();
    }

    @Override
    public List<Artiste> findAll() {
        String sql = "SELECT nom, biographie, pays, urlPhoto FROM Artiste";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Artiste.class));
    }

    public boolean artisteExists(String nom) {
        String sql = "SELECT count(*) FROM Artiste WHERE nom= ? ";
        int count=-1;
        if(jdbcTemplate.queryForObject(sql, Integer.class, nom)!=null){
            count = jdbcTemplate.queryForObject(sql, Integer.class, nom);
        }

        return count == 1;
    }

}
