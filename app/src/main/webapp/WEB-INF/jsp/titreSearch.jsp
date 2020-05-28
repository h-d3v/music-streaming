<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Ma playlist #1</title>
    <link href='https://fonts.googleapis.com/css?family=Allerta' rel='stylesheet'>
    <link href="css/playlistWidget.css" rel="stylesheet">
    <link href="css/itemList.css" rel="stylesheet">
    <link href="css/searchBar.css" rel="stylesheet">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="js/rechercheTitre.js"></script>
</head>
<header>
    <nav class="navbar navbar-expand navbar-dark bg-dark flex-column flex-md-row bd-navbar">
        <div class="container"><a class="navbar-brand" href="#">RoseTube</a>
            <button data-toggle="collapse" class="navbar-toggler" data-target="#navbarResponsive"><span
                    class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item" role="presentation"><a class="nav-link" href="player.jsp">Mon player</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="#">Mon compte
                        : ${sessionScope.utilisateurConnecte.pseudo}</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="seDeconnecter">Se Deconnecter</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<body>

<div class="input-group md-form form-sm form-1 pl-0 m-2">
    <div class="input-group-prepend">
        <span class="input-group-text orange lighten-3" id="basic-text1">
            <i class="fa fa-search" style="color: black" aria-hidden="true"></i></span>
    </div>
    <input class="form-control my-0 py-1" type="text" placeholder="Tapper un titre, le nom d'un artiste ou un genre de musique" aria-label="Search" onkeyup="chercherTitre()">
</div>

<div class="row">
    <c:forEach items="${titres}" var="unTitre">
        <div class="col-2 py-3 mx-auto col-xl-2 col-lg-4 col-md-6 col-sm-12"
             style="min-width: 300px;min-height: 300px;">
            <div class="card">
                <a href="#"><img class="img-fluid card-img-top" style="height: 212px;width: 553px;"
                                 src="${unTitre.urlImage}" alt="cover du titre"/></a>
                <div class="card-body">
                    <h5>${unTitre.nom}</h5>
                    <p>${unTitre.nomArtiste}</p>
                    <h8><c:if test="${!unTitre.genre.equals('null')}">Genre : ${unTitre.genre}</c:if></h8>
                </div>
                <div class="card-footer text-center"><small><a href="#"><i class="fa fa-plus pr-1"></i>Ajouter a une
                    playlist<br/></a></small></div>
            </div>
        </div>
    </c:forEach>
</div>
</body>