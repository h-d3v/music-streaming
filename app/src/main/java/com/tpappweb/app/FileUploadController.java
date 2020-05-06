package com.tpappweb.app;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.tpappweb.app.service.Formulaire;
import com.tpappweb.app.service.GestionMetaDatasMp3;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
    public class FileUploadController {

        private static String UPLOAD_MUSIC_FOLDER="src/main/resources/static/audio/";

        @GetMapping("/uploadStatus")
        public String uploadStatus() {
            return "uploadStatus";
        }
        @GetMapping("/upload")
        public String upload(){
            return "upload";
        }

        @PostMapping("/upload")
        public String fileUpload(@RequestParam MultipartFile file, ModelMap modelMap){
            if(file.isEmpty()){
                modelMap.addAttribute("message","erreur, fichier vide");

                return "uploadStatus";
            }

            try {
                byte[] bytes=file.getBytes();
                Path path= Paths.get(UPLOAD_MUSIC_FOLDER+file.getOriginalFilename());
                Files.write(path, bytes);
                Files.write(Paths.get("src/main/resources/static/audio/audioTampo.mp3"), bytes);
                modelMap.addAttribute("formulaire", new Formulaire());
                modelMap.addAttribute("message", "Le fichier a bien ete enregistre");
                GestionMetaDatasMp3 gestionMetaDatasMp3= new GestionMetaDatasMp3(file.getOriginalFilename());
                if(!gestionMetaDatasMp3.isFichierValide()){
                    modelMap.addAttribute("message", "Le type de fichier n'est pas valide");
                    return "uploadStatus";
                }
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
