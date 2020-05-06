package com.tpappweb.app.init;

import com.tpappweb.app.entites.Titre;
import com.tpappweb.app.service.Formulaire;
import com.tpappweb.app.service.GestionMetaDatasMp3;
import com.tpappweb.app.service.TitreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Initialisation {
    private static final String DIR_AUDIO="src/main/resources/static/audio/";
    private static ArrayList<String> artistes=new ArrayList<>();

    public static void main(String[] args) throws IOException {
        enregistrer("/home/jj/Musique");
    }
    public static void enregistrer(String folderDepart) throws IOException {

        File folder = new File(folderDepart);
        File[] fileNames = folder.listFiles();
        for (File file : fileNames) {
            System.out.println(file.getName().trim());
            File fileCopie = new File(DIR_AUDIO + file.getName().replace(" ", "%"));
            FileInputStream is = new FileInputStream(file);
            FileOutputStream os = new FileOutputStream(fileCopie);
            //On copie les fichiers dans le repertoire audio du serveur TOMCAt
            try {


                byte[] buf = new byte[1024];

                int bytesRead;
                while ((bytesRead = is.read(buf)) > 0) {
                    os.write(buf, 0, bytesRead);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                is.close();
                os.close();
            }
            //On Copie les fichiers photo


            GestionMetaDatasMp3 gestionMetaDatasMp3=new GestionMetaDatasMp3(fileCopie.getName());
            Titre titre = new Titre();
            if(gestionMetaDatasMp3.isFichierValide()) {
                gestionMetaDatasMp3.creerPhoto();
                titre.setDateSortie(gestionMetaDatasMp3.getDate());
                titre.setUrlImage(gestionMetaDatasMp3.getNomFichierPhoto());
                titre.setUrl(gestionMetaDatasMp3.getCheminFichiermP3());
                titre.setNom(gestionMetaDatasMp3.getTitre());
                titre.setGenre(gestionMetaDatasMp3.getGenre());
                titre.setDuree(gestionMetaDatasMp3.getDuree());
                titre.setNomArtiste(gestionMetaDatasMp3.getAuteur());
                titre.setTitreAlbum(gestionMetaDatasMp3.getAlbum());

                if (!artistes.contains(titre.getNomArtiste())) {
                    artistes.add(titre.getNomArtiste());
                    System.out.println("INSERT INTO Artiste(nom) VALUES (\'" + titre.getNomArtiste() + "\');");
                }
                System.out.println("INSERT INTO Titre(nomArtiste, nom, url, duree, urlImage, dateSortie, genre, titreAlbum) VALUES " +
                        "( \'" + titre.getNomArtiste() +
                        "\',\'" + titre.getNom() +
                        "\',\'" +DIR_AUDIO+ titre.getUrl() +
                        "\'," + titre.getDuree() +
                        ",\'"+gestionMetaDatasMp3.getDIR_PHOTO()+ titre.getUrlImage() +
                        "\',\'" + titre.getDateSortie() +
                        "\',\'"+ titre.getGenre() +
                        "\',\'"+ titre.getTitreAlbum() +
                        "\');");

            }



        }



    }
}