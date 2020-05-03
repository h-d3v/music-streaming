package com.tpappweb.app.dao.romappers;

import com.tpappweb.app.dao.UtilisateurSqlDao;
import com.tpappweb.app.entites.PlayList;
import com.tpappweb.app.entites.Utilistateur;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaylistRowMapper implements RowMapper<PlayList> {
    @Override
    public PlayList mapRow(ResultSet rs, int i) throws SQLException {
        UtilisateurSqlDao utilisateurSqlDao= new UtilisateurSqlDao();
        PlayList playList=new PlayList();
        playList.setId(rs.getInt("id"));
        playList.setNom("nom");
        Utilistateur utilistateur=utilisateurSqlDao.findById(rs.getInt("utilisateurId"));
        playList.setUtilistateur(utilistateur);
        return playList;
    }
}
