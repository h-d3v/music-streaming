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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/rechercheTitre.js"></script>
</head>

<body style="overflow-x: hidden">
<header>
    <nav class="navbar navbar-expand navbar-dark bg-dark flex-column flex-md-row bd-navbar">
        <div class="container"><a class="navbar-brand" href="#">RoseTube</a>
            <button data-toggle="collapse" class="navbar-toggler" data-target="#navbarResponsive"><span
                    class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="nav navbar-nav ml-auto">
                    <c:choose>
                    <c:when test="${sessionScope.utilisateurConnecte.pseudo!=null}">
                        <li class="nav-item" role="presentation"><a class="nav-link" href="#">Mon compte : ${sessionScope.utilisateurConnecte.pseudo}</a></li>
                        <li class="nav-item" role="presentation"><a class="nav-link" href="player.jsp">Mon player</a></li>
                        <li class="nav-item" role="presentation"><a class="nav-link" href="seDeconnecter">Deconnexion</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item" role="presentation"><a class="nav-link" href="${pageContext.request.contextPath}/">Page principale</a></li>
                    </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
    </nav>
</header>
    <!-- Modal pour ajouter un titre a une playlist-->
    <div class="modal fade" id="modalAjouter" tabindex="-1" role="dialog" aria-labelledby="modalAjouter" >
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" style="color: #1d2124" id="modalAjouterLabel">Ajouter un titre a une de vos playlist</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true"><i class="fa fa-times"></i></span>
                    </button>
                </div>
                    <div class="modal-body">
                        <c:choose>
                            <c:when test="${sessionScope.utilisateurConnecte.pseudo==null}">
                                <h2 class="h2 text-center text-dark"> Allez a la page principale pour vous creer un compte et commencez à personnalisez vos playlists</h2>
                            </c:when>
                            <c:otherwise>
                                <div id="titreId" hidden ></div>
                                <h4 id="modalAjouterTitre"></h4>
                                <div id="message" style="color: #1d2124"></div>
                                <select id="selectPlayList" class="custom-select"  name="PlayLists">
                                    <c:forEach items="${sessionScope.playlistsUtilisateur}" var="playList">
                                        <option value="${playList.id}">${playList.nom}</option>
                                    </c:forEach>
                                </select>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="modal-footer">
                        <c:choose>
                            <c:when test="${sessionScope.utilisateurConnecte.pseudo==null}">
                                <a href="/"><button type="button"  class="btn btn-primary">Page principale</button></a>
                            </c:when>
                            <c:otherwise>
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
                                <button type="button" onclick="enregistrerTitreDansPlayList()" class="btn btn-primary">Enregistrer</button>

                            </c:otherwise>
                        </c:choose>
                    </div>
            </div>
        </div>
    </div>

    <!--bar de recherche-->
    <div class="input-group md-form form-sm form-1 p-3">
        <div class="input-group-prepend">
            <span class="input-group-text orange lighten-3" id="basic-text1">
                <i class="fa fa-search" style="color: black" aria-hidden="true"></i></span>
        </div>
        <input id="search" class="form-control py-1" type="text"
               placeholder="Tapper un titre, le nom d'un artiste ou un genre de musique" aria-label="Search" onkeyup="chercherTitre()">
    </div>

    <div class="row" style="margin-bottom: 180px;">
        <c:forEach items="${titres}" var="unTitre">
            <div id="" class="col-2 py-3 mx-auto col-xl-1 col-lg-4 col-md-5 col-sm-12"
                 style="min-width: 300px;min-height: 300px;">
                <div class="card">
                    <div class="containerImg">
                    <img id="titre-img-${unTitre.id}" class="img-fluid card-img-top" style="height: 212px;width: 553px;" src="${unTitre.urlImage}" alt="cover du titre"/>
                    <div class="overlay">
                        <a onclick="jouerTitre(this)" id="${unTitre.id}" class="iconImgTitre" title="Play titre">
                            <i  class="fa fa-play"></i>
                        </a>
                    </div>
                    </div>
                    <div class="card-body">
                        <h5 class="h5" id="titre-nom-${unTitre.id}">${unTitre.nom}</h5>
                        <p id="titre-artiste-${unTitre.id}">${unTitre.nomArtiste}</p>
                        <h6 class="h6"><c:if test="${!unTitre.genre.equals('') || !unTitre.genre.equals('')}">Genre : ${unTitre.genre}</c:if></h6>
                        <p id="chemin-titre-${unTitre.id}" style="display: none">${unTitre.url}</p>
                    </div>
                    <!--Trigger pour le modal d'ajout d'un titre a une playlist-->
                    <div class="card-footer text-center"><small><a href="#" type="button" onclick='ouvrirModal( ${unTitre.id} ,"${unTitre.nom}", "${unTitre.nomArtiste}")' data-toggle="modal" data-target="#modalAjouter"><i class="fa fa-plus pr-1"></i>Ajouter a une playlist<br/></a></small></div>
                </div>
            </div>
        </c:forEach>
    </div>


    <div   style="background-color: #040505A8;" class="rounded container-fluid fixed-bottom">
        <h3 id="msg-player" class="h1 text-center" style="color:lightpink">Cliquez sur un titre</h3>
        <div class="row align-items-center">
            <div class="col-12 col-xs-10 col-md-2">
                <img class="img-thumbnail rounded "  id="player-img" style="display:none;height: 105px; width: 115px" src="" alt="cover du titre"/>
            </div>
            <div class="col-6 col-xs-6 col-md-4 col-lg-5">
                <h4 id="player-nom-titre" class="text-center h4 text-white"> </h4>
            </div>
            <div class="col-6 col-xs-6 col-md-4 col-lg-5">
                <h4 id="player-artiste" class="text-center h4 text-white"> </h4>
            </div>
        </div>
        <div class="row">
            <audio controls autoplay class="">
                <source id="player-titre-chemin" src="" type="audio/mp3">
                Your browser does not support the audio tag.
            </audio>
        </div>
    </div>
</body>
</html>