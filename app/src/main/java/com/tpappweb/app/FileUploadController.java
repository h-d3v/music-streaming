package com.tpappweb.app;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.tpappweb.app.entites.Utilistateur;
import com.tpappweb.app.service.Formulaire;
import com.tpappweb.app.service.GestionMetaDatasMp3;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

@Controller
    public class FileUploadController {

        private static String UPLOAD_FOLDER="src/main/resources/static/audio/";

        @GetMapping("/uploadStatus")
        public String uploadStatus(HttpSession httpSession) {
            if (httpSession.getAttribute("utilisateurConnecte") == null) return "error";
            Utilistateur utilistateur = (Utilistateur) httpSession.getAttribute("utilisateurConnecte");
            if (!utilistateur.getEstAdmin()) {
                return "error";
            }
            return "uploadStatus";
        }
        @GetMapping("/upload")
        public String upload(HttpSession httpSession){
            if (httpSession.getAttribute("utilisateurConnecte") == null) return "error";

            Utilistateur utilistateur = (Utilistateur) httpSession.getAttribute("utilisateurConnecte");
            System.out.println(utilistateur.getEstAdmin());
            if (!utilistateur.getEstAdmin()) {
                return "error";
            }
            return "upload";
        }

        @PostMapping("/upload")
        public String fileUpload(@RequestParam MultipartFile file, Formulaire formulaire, ModelMap modelMap, HttpSession httpSession){
            if (httpSession.getAttribute("utilisateurConnecte") == null) return "error";
            Utilistateur utilistateur = (Utilistateur) httpSession.getAttribute("utilisateurConnecte");
            if (!utilistateur.getEstAdmin()) {
                return "error";
            }
            if(file.isEmpty()){
                modelMap.addAttribute("message","erreur, fichier vide");
                return "uploadStatus";
            }

            try {
                byte[] bytes=file.getBytes();
                Path path= Paths.get(UPLOAD_FOLDER+file.getOriginalFilename());
                Files.write(path, bytes);
                Files.write(Paths.get("src/main/resources/static/audio/audioTampo.mp3"), bytes);
                modelMap.addAttribute("formulaire", new Formulaire());
                modelMap.addAttribute("message", "Le fichier a bien ete enregistre");
                GestionMetaDatasMp3 gestionMetaDatasMp3= new GestionMetaDatasMp3(file.getOriginalFilename());
                modelMap.addAttribute("album",gestionMetaDatasMp3.getAlbum());
                modelMap.addAttribute("date", gestionMetaDatasMp3.getDate());
                modelMap.addAttribute("duree",gestionMetaDatasMp3.getDuree());
                modelMap.addAttribute("titre", gestionMetaDatasMp3.getTitre());
                modelMap.addAttribute("genre", gestionMetaDatasMp3.getGenre());
                modelMap.addAttribute("auteur", gestionMetaDatasMp3.getAuteur());
                Files.write(Paths.get("src/main/resources/static/img/covers/coverTampon.jpg"), gestionMetaDatasMp3.getMp3File().getId3v2Tag().getAlbumImage());
                gestionMetaDatasMp3.creerPhoto();
                modelMap.addAttribute("cheminPhoto", "img/covers/"+gestionMetaDatasMp3.getNomFichierPhoto());
                modelMap.addAttribute("cheminAudio", "audio/"+gestionMetaDatasMp3.getCheminFichiermP3());


            } catch (IOException e) {
                e.printStackTrace();

            }
            return "uploadStatus";

        }

}
