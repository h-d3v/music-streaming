DROP DATABASE  IF EXISTS rosetube;
CREATE DATABASE rosetube;
USE rosetube;
CREATE TABLE Artiste (id int(10) NOT NULL AUTO_INCREMENT, nom varchar(10) NOT NULL, prenom varchar(10), biographie text, pays varchar(255), urlPhoto varchar(255), PRIMARY KEY (id));
CREATE TABLE Commentaire (Titreid int(10) NOT NULL, Utilisateurpseudo varchar(255) NOT NULL, id int(10) NOT NULL AUTO_INCREMENT, commentaire text NOT NULL, `date` int(10) NOT NULL, PRIMARY KEY (id));
CREATE TABLE LikeOuDislike (id int(10) NOT NULL AUTO_INCREMENT, likeOuDislike int(10) NOT NULL, Titreid int(10) NOT NULL, Utilisateurpseudo varchar(255) NOT NULL, PRIMARY KEY (id));
CREATE TABLE Playlist (id int(10) NOT NULL AUTO_INCREMENT, Utilisateurpseudo varchar(255) NOT NULL, Nom varchar(255) NOT NULL, dateCreation date NOT NULL, PRIMARY KEY (id));
CREATE TABLE Titre (id int(10) NOT NULL AUTO_INCREMENT, Artisteid int(10) NOT NULL, Nom varchar(255) NOT NULL, chemin varchar(255) NOT NULL UNIQUE, duree time NOT NULL, cheminImage int(10) UNIQUE, dateSortie int(10), genre int(10), TitreAlbum int(10), PRIMARY KEY (id));
CREATE TABLE Titre_Playlist (Titreid int(10) NOT NULL, Playlistid int(10) NOT NULL, PRIMARY KEY (Titreid, Playlistid));
CREATE TABLE Utilisateur (pseudo varchar(255) NOT NULL, courriel varchar(50) NOT NULL, motPasse varchar(255) NOT NULL, PRIMARY KEY (pseudo));
ALTER TABLE LikeOuDislike ADD CONSTRAINT FKLikeOuDisl172807 FOREIGN KEY (Titreid) REFERENCES Titre (id);
ALTER TABLE LikeOuDislike ADD CONSTRAINT FKLikeOuDisl334912 FOREIGN KEY (Utilisateurpseudo) REFERENCES Utilisateur (pseudo);
ALTER TABLE Playlist ADD CONSTRAINT FKPlaylist63323 FOREIGN KEY (Utilisateurpseudo) REFERENCES Utilisateur (pseudo);
ALTER TABLE Commentaire ADD CONSTRAINT FKCommentair768160 FOREIGN KEY (Titreid) REFERENCES Titre (id);
ALTER TABLE Commentaire ADD CONSTRAINT FKCommentair232032 FOREIGN KEY (Utilisateurpseudo) REFERENCES Utilisateur (pseudo);
ALTER TABLE Titre ADD CONSTRAINT FKTitre361371 FOREIGN KEY (Artisteid) REFERENCES Artiste (id);
ALTER TABLE Titre_Playlist ADD CONSTRAINT FKTitre_Play36931 FOREIGN KEY (Playlistid) REFERENCES Playlist (id);
ALTER TABLE Titre_Playlist ADD CONSTRAINT FKTitre_Play48210 FOREIGN KEY (Titreid) REFERENCES Titre (id);

