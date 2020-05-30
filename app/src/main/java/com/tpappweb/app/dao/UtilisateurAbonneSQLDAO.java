package com.tpappweb.app.dao;
import com.tpappweb.app.dao.romappers.AbonneRowMapper;
import com.tpappweb.app.entites.Utilistateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UtilisateurAbonneSQLDAO extends MySQLDAOJoin<Utilistateur,Utilistateur>{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * @param utilistateur
     * @param utilistateurAbonne l'objet t1 a ajouter
     * @return
     */
    @Override
    public boolean ajouterUn(Utilistateur utilistateur, Utilistateur utilistateurAbonne) {
        String sql="INSERT INTO Abonnes(utilisateur, abonne) VALUES (?,?)";
        return jdbcTemplate.update(sql, utilistateur, utilistateurAbonne)==1;
    }

    /**
     * @param utilistateur
     * @param utilistateurAbonne l'objet t1 a supprimmer
     * @return boolean
     */
    @Override
    public boolean supprimerUn(Utilistateur utilistateur, Utilistateur utilistateurAbonne) {
        String sql="DELETE FROM Abonnes WHERE abonne=? AND utilisateur=?";
        return jdbcTemplate.update(sql,utilistateurAbonne, utilistateur)==1;
    }

    /**
     * @param utilistateur
     * @return le nombre d'objets T1 supprimes
     */

    @Override
    public long supprimerTous(Utilistateur utilistateur) {
        String sql="DELETE FROM Abonnes WHERE utilisateur=?";
        return jdbcTemplate.update(sql, utilistateur);
    }

    @Override
    public List<Utilistateur> charger(Utilistateur utilistateur) {
        String sql="SELECT abonne FROM Abonnes WHERE utilisateur=?";

        return jdbcTemplate.query(sql, new AbonneRowMapper(),utilistateur.getPseudo());
    }


}
