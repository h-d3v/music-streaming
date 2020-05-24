package com.tpappweb.app.dao;


import com.tpappweb.app.entites.LikeOuDislike;
import com.tpappweb.app.entites.Titre;
import com.tpappweb.app.entites.Utilistateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.apache.commons.lang3.NotImplementedException;

import java.util.List;

@Repository
public class LikeOuDislikeSQLDAO extends MySQLDAO<LikeOuDislike> {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public LikeOuDislike creer(LikeOuDislike likeOuDislike){
        String sql="INSERT INTO LikeOuDislike(titreId, utilisateurPseudo, likeOuDislike) VALUES (:titreId,:utilisateurPseudo,:likeOuDislike)";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("likeOuDislike", likeOuDislike.getLikeOuDislike());
        mapSqlParameterSource.addValue("titreId", likeOuDislike.getTitreId());
        mapSqlParameterSource.addValue("utilisateurPseudo", likeOuDislike.getUtilistateurPseudo());
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(likeOuDislike);
        jdbcTemplate.update(sql, sqlParameterSource);
        sql="SELECT * FROM LikeOuDislike WHERE titreId=:titreId AND utilisateurPseudo=:utilisateurPseudo";
        return (LikeOuDislike) jdbcTemplate.query(sql, new BeanPropertyRowMapper<LikeOuDislike>(LikeOuDislike.class));
    }

    @Override
    public boolean create(LikeOuDislike x) {
        String sql="INSERT INTO LikeOuDislike(likeOuDislike, titreId, utilisateurPseudo) VALUES (:likeOrDislike,:titreId,:utilisateurPseudo)";
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(x);
        return jdbcTemplate.update(sql, sqlParameterSource)==1;
    }

    @Override
    public LikeOuDislike findById(String string) {
        throw new NotImplementedException();
    }

    @Override
    public LikeOuDislike findById(int id) {

        String sql="SELECT id, likeOuDislike, titreId, utilisateurPseudo FROM LikeOuDislike WHERE id=:id";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id", id);
        return (LikeOuDislike) jdbcTemplate.queryForObject(sql,mapSqlParameterSource,new BeanPropertyRowMapper(LikeOuDislike.class));

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
    public boolean delete(LikeOuDislike x) {
        String sql= "DELETE FROM LikeOuDislike WHERE id=:id";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id", x.getId());
        int w =jdbcTemplate.update(sql, new BeanPropertySqlParameterSource(x));
        return w==1;
    }

    public LikeOuDislike modifier(LikeOuDislike likeOuDislike){
        if(this.findByObject(likeOuDislike).size()==0){
            return null;
        }
        else {
            likeOuDislike = this.findByObject(likeOuDislike).get(0);
            likeOuDislike.setLikeOuDislike(!likeOuDislike.getLikeOuDislike());
            return findByObject(likeOuDislike).get(0);
        }

    }

    @Override
    public boolean update(LikeOuDislike x) {
        String sql= "UPDATE LikeOuDislike SET likeOuDislike=:likeOuDislike" +
                   " WHERE titreId=:titreId AND utilisateurPseudo=:utilisateurPseudo AND id=:id";
        int i=jdbcTemplate.update(sql, new BeanPropertySqlParameterSource(x));
        return i==1;
    }

    /***
     *
     * @param object soit utilisateur, soit titre, soit LikeOudisLike
     * @return Lis<LikeOuDislike> la liste est limitee a 0 ou 1 si likeOuDislike est entree en parametre et cherchera le likeOuDislike
     * selon le nom d'utilisateur et le titre associe
     */
    @Override
    public List<LikeOuDislike> findByObject(Object object) {
        if(object instanceof Utilistateur){
            String sql = "SELECT * FROM LikeOuDislike WHERE utilisateurPseudo=:utilisateurPseudo";
            MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
            mapSqlParameterSource.addValue("utilisateurPseudo", ((Utilistateur) object).getPseudo());
            return jdbcTemplate.query(sql,new BeanPropertyRowMapper<LikeOuDislike>());
        }
        else if(object instanceof Titre){
            String sql = "SELECT * FROM LikeOuDislike WHERE titreId=:titreId";
            MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
            mapSqlParameterSource.addValue("titreId", ((Titre) object).getId());
            return jdbcTemplate.query(sql,new BeanPropertyRowMapper<LikeOuDislike>());
        }

        else if(object instanceof LikeOuDislike){
            String sql = "SELECT * FROM LikeOuDislike WHERE titreId=:titreId AND utilisateurPseudo=:utilisateurPseudo";
            MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
            mapSqlParameterSource.addValue("titreId", ((LikeOuDislike) object).getTitreId());
            mapSqlParameterSource.addValue("utilisateurPseudo", ((LikeOuDislike) object).getUtilistateurPseudo());
            return jdbcTemplate.query(sql,new BeanPropertyRowMapper<LikeOuDislike>());
        }
        else throw new NotImplementedException();
    }

    @Override
    public List<LikeOuDislike> findAll() {
        String sql="SELECT * FROM LikeOuDislike";

        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<LikeOuDislike>());
    }
}
