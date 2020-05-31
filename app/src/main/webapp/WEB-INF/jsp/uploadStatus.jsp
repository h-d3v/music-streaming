

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en" >
<body>

<h1>Ajouter un fichier</h1>

<div>
    <h2>${message}</h2>
</div>
<%--@elvariable id="formulaire" type="com.tpappweb.app.service.Formulaire"--%>
<h3>Photo de l'album</h3>
<p> Le serveur doir redemarrer pour afficher l'image et l'audio mis en memoire tampon(BETA)</p>
<img height="200px" width="auto" src="img/covers/coverTampon.jpg"/>
<audio src="audio/audioTampo.mp3" controls></audio>

<form:form method="post" modelAttribute="formulaire" action="titres/add">

    <form:label path="album" >Titre de l'album :</form:label>
    <form:input path="album" value="${album}" ></form:input>
    <form:label path="date" >Date de sortie : </form:label>
    <form:input path="date" value="${date}" ></form:input>
    <form:label path="duree" >Duree : </form:label>
    <form:input path="duree" value="${duree}" ></form:input>
    <form:label path="titre" >Titre: </form:label>
    <form:input path="titre" value="${titre}" ></form:input>
    <form:label path="genre" >Titre de l'album :</form:label>
    <form:input path="genre" value="${genre}" ></form:input>
    <form:label path="auteur" >Nom de l'auteur :</form:label>
    <form:input path="auteur" value="${auteur}" ></form:input>
    <form:label path="cheminPhoto" >Chemin photo NE PAS CHANGER(BETA) :</form:label>
    <form:input path="cheminPhoto" value="${cheminPhoto}"></form:input>
    <form:label path="cheminAudio" >Chemin audio  NE PAS CHANGER(BETA) :</form:label>
    <form:input path="cheminAudio" value="${cheminAudio}"></form:input>
    <input type="submit" value="Confirmer"/><p>Le nouveau titre sera entre dans la base de donnee, encore redemarrer Tomcat !!</p>

</form:form>

</body>
</html>