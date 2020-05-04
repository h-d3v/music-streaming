package com.tpappweb.app.service;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public  class GestionMetaDatasMp3 {
    private final String DIR_AUDIO="src/main/resources/static/audio/";
    private  String cheminFichiermP3;
    private final String DIR_PHOTO="src/main/resources/static/img/covers/";
    private String nomFichierPhoto;
    Mp3File mp3File;
    private int duree;
    private String titre;
    private String album;
    private String genre;
    private String auteur;
    private String date;

    /***
     *
     * @param cheminFichiermP3 le nom du fichier mp3
     */
    public GestionMetaDatasMp3(String cheminFichiermP3){
        this.cheminFichiermP3=cheminFichiermP3;
        try{
        mp3File= new Mp3File(DIR_AUDIO+cheminFichiermP3);
        genre=mp3File.getId3v2Tag().getGenreDescription();
        duree= mp3File.getId3v2Tag().getLength();
        titre= mp3File.getId3v2Tag().getTitle();
        album= mp3File.getId3v2Tag().getAlbum();
        auteur= mp3File.getId3v2Tag().getArtist();
        date=  mp3File.getId3v2Tag().getDate();

        } catch (UnsupportedTagException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }
    }

    /***
     * Cree une photo a partir des
     * @return boolean true si le fichier jpg a ete cree dans le repetoire des photos d'albums
     */

    public  boolean creerPhoto(){


        try {
            if(mp3File.getId3v2Tag().getAlbumImage()==null){
                return false;
            }
            File file = new File(DIR_PHOTO+cheminFichiermP3+".jpg");
            file.createNewFile();
            FileOutputStream fileWriter = new FileOutputStream(file);
            fileWriter.write(mp3File.getId3v2Tag().getAlbumImage());
            fileWriter.close();
            setNomFichierPhoto(cheminFichiermP3+".jpg");
            return true;
        } catch (IOException e) {

            e.printStackTrace();

        }
        return false;
    }

    public String getDIR_AUDIO() {
        return DIR_AUDIO;
    }

    public String getCheminFichiermP3() {
        return cheminFichiermP3;
    }

    public void setCheminFichiermP3(String cheminFichiermP3) {
        this.cheminFichiermP3 = cheminFichiermP3;
    }

    public String getDIR_PHOTO() {
        return DIR_PHOTO;
    }

    public String getNomFichierPhoto() {
        return nomFichierPhoto;
    }

    public void setNomFichierPhoto(String nomFichierPhoto) {
        this.nomFichierPhoto = nomFichierPhoto;
    }

    public Mp3File getMp3File() {
        return mp3File;
    }

    public void setMp3File(Mp3File mp3File) {
        this.mp3File = mp3File;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
