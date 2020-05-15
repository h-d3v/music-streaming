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
        PlayList playList=new PlayList();
        Utilistateur utilistateur = new Utilistateur();
        utilistateur.setPseudo(rs.getString("utilisateurPseudo"));
        playList.setId(rs.getInt("Playlist.id"));
        playList.setNom(rs.getString("nom"));
        playList.setUtilistateur(utilistateur);
        playList.setDateEdition(rs.getDate("dateCreation").toLocalDate());
        return playList;
    }
}
