package com.tpappweb.app.service.interfaces;

import com.tpappweb.app.entites.PlayList;

public interface IPlayListInterface {
   void ajouterPlaylist(PlayList playList);
   PlayList chercherPlayListParID(int id);
}
