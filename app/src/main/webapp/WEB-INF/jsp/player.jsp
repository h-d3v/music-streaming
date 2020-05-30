
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>tpAppWeb</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Catamaran:100,200,300,400,500,600,700,800,900">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/scrollbar-1.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/untitled.css">
</head>

<body>
<nav class="navbar navbar-dark navbar-expand-lg fixed-top bg-dark navbar-custom">
    <div class="container"><a class="navbar-brand" href="#">RoseTube</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navbarResponsive"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="nav navbar-nav ml-auto">

                <li class="nav-item" role="presentation"><a class="nav-link" href="#">Mon compte : ${sessionScope.utilisateurConnecte.pseudo}</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="${pageContext.request.contextPath}/seDeconnecter">Se Deconnecter</a></li>
            </ul>
        </div>
    </div>
</nav>
<div style="margin-top: 71px;">
    <div class="container m-auto">
        <div class="row">
            <div class="col-md-3 col-lg-3 col-xl-3">
                <section>
                    <ul class="list-group sc-overflow" style="max-height: 150px;">
                        <li class="list-group-item"><a href="${pageContext.request.contextPath}/">Accueil</a></li>
                        <li class="list-group-item"><a href="#">Rechercher</a></li>
                        <li type="button" class="list-group-item">
                            Genres</li>
                                <c:forEach items="${genres}" var="genre">
                                   <li><a class="nav-link" href='/playlist/${genre}/'> ${genre} </a></li>
                    </c:forEach>

                    </ul>
                </section>
                <section>
                    <h4>Mes Playlists</h4>
                    <ul class="list-group sc-overflow" style="max-height: 150px;">
                           <!-- Button trigger modal -->
                           <li type="button" class="list-group-item"  data-toggle="modal" data-target="#modalCommencerPlayList">
                               Creer une nouvelle PlayList
                           </li>

                           <!-- Modal -->
                           <div class="modal fade" id="modalCommencerPlayList" tabindex="-1" role="dialog" aria-labelledby="modalCommencerPlayList" aria-hidden="true">
                               <div class="modal-dialog" role="document">
                                   <div class="modal-content">
                                       <div class="modal-header">
                                           <h5 class="modal-title" style="color: #1d2124" id="modalCommencerPlayListLabel">Nouvelle PlayList</h5>
                                           <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                               <span aria-hidden="true">&times;</span>
                                           </button>
                                       </div>
                                       <form id="nomPlayListAEnregistrer">
                                       <div class="modal-body">
                                           <div class="form-group"><input type="text"  class="form-control" name="nom" placeholder="Nom de la playlist" /></div>
                                       </div>
                                       <div class="modal-footer">
                                           <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
                                           <button type="button" onclick="enregistrerPlayList()"  class="btn btn-primary">Enregistrer</button>
                                       </div>
                                       </form>
                                       <script>
                                           function enregistrerPlayList() {
                                               let xhttp = new XMLHttpRequest();
                                               xhttp.onreadystatechange = function() {
                                                   if (this.readyState == 4 && this.status == 200) {
                                                       location.reload();
                                                   }
                                               };
                                               xhttp.open("GET", "/utilisateurs/${sessionScope.utilisateurConnecte.pseudo}/addPlayList?nom="
                                                   +document.getElementById("nomPlayListAEnregistrer").elements[0].value  , true);
                                               xhttp.send();
                                           }

                                       </script>

                                   </div>
                               </div>
                           </div>


                        <!-- Liste des Playlists -->
                        <c:forEach items="${playlistsUtilisateur}" var="playList">
                            <li class="list-group-item"><a href="/playlists/${playList.id}"> <span>${playList.nom}</span> </a></li>

                        </c:forEach>

                    </ul>
                </section>
            </div>
            <!-- Liste des Titres par genre -->
            <div class="col-md-6 col-lg-6 col-xl-6">
                <h2>Playlist en cours</h2>
                <div style="padding-top: 20px !important;" class="container-fluid">
                    <h3 class="text-center text-dark">${ !empty titresLectureActuelle ?  titresLectureActuelle.nom : 'Selectionnez une playlist'}</h3>
                    <div class="row">

                        <c:if test="${ !empty titresLectureActuelle }">
                            <div class="table-responsive">
                            <table id="tableTitre"  class="table table-striped table-dark table-fixed">
                                <thead>
                                <tr>
                                    <th scope="col" class="col-2">Titre</th>
                                    <th scope="col" class="col-2">Artiste</th>
                                    <th scope="col" class="col-2">Durée</th>
                                    <th scope="col" class="col-2"><span class="oi oi-heart" title="heart" aria-hidden="true"></span></th>
                                    <th scope="col" class="col-2"><span class="oi oi-thumb-down" title="thumb down" aria-hidden="true"></span></th>
                                    <th scope="col" class="col-2">Genre</th>
                                </tr>
                                </thead>
                                <tbody>
                            <c:forEach items="${titresLectureActuelle.listeTitres}" var='titre'>
                            <tr type="button" onclick="lireTitre(${titre.id})">

                                <td class="col-2">${titre.nom}</td>
                                <td class="col-2">${titre.nomArtiste}</td>
                                <td class="col-2">3:${titre.duree}</td>
                                <td class="col-2">0</td><!-- likesEtDIslike a mod dans le back end -->
                                <td class="col-2">1</td>
                                <td class="col-2">${titre.genre}</td>
                            </tr>
                            </c:forEach>
                                </tbody>
                            </table>
                                <script>
                                    function lireTitre(titreId) {
                                        let xhttp = new XMLHttpRequest();
                                        xhttp.onreadystatechange = function() {
                                            if (this.readyState == 4 && this.status == 200) {
                                                let reponse = xhttp.responseText;
                                                let json = JSON.parse(reponse);
                                                document.getElementById("titreLecture").innerText=json.nom;
                                                document.getElementById("nomArtisteLecture").innerText=json.nomArtiste;
                                                document.getElementById("imagePath").src="/"+json.urlImage;
                                                document.getElementById("mp3fichier").src="/"+json.url;
                                                document.getElementById("mp3fichier").setAttribute("autoplay",true);

                                            }
                                        };
                                        xhttp.open("GET","/titre/"+titreId  , true);
                                        xhttp.send();
                                    }

                                </script>
                    </div>

                        </c:if>
                        <c:if test="${ empty titresLectureActuelle }">
                            <p>Vos titres de la playlist s'afficheront ici</p>
                        </c:if>

                        </div>


            </div>
            </div>
            <div class="col-md-3 col-lg-3 col-xl-3">
                <section>
                    <h4>Lecture en cours</h4>
                    <h5>Titre : <span id="titreLecture"></span></h5>
                    <h6>Artiste : <span id="nomArtisteLecture"></span> </h6>
                    <img class="imageAlbum" id="imagePath" src="${pageContext.request.contextPath}/img/noMusic.jpg"></section>
                <audio id="mp3fichier" src="" controls="" style="width: 100%;"></audio>
                <section>
                    <h4>Commentaires</h4>
                    <ul class="list-group sc-overflow" style="max-height: 150px;">
                        <li class="list-group-item"><span>List Group Item</span></li>
                        <li class="list-group-item"><span>List Group Item</span></li>
                        <li class="list-group-item"><span>List Group Item</span></li>
                        <li class="list-group-item"><span>List Group Item</span></li>
                    </ul>
                </section>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 col-lg-3 col-xl-3">
                <h2>Mes amis</h2>
                <ul class="list-group sc-overflow" style="max-height: 150px;">
                    <li class="list-group-item"><span>Ami1</span></li>
                    <li class="list-group-item"><span>Ami2</span></li>
                    <li class="list-group-item"><span>Ami3</span></li>
                    <li class="list-group-item"><span>Ami4</span></li>
                </ul>
            </div>
            <div class="col">
                <h2>Activite recente de mon ami ami1</h2>
                <ul class="list-group sc-overflow" style="max-height: 150px;">
                    <li class="list-group-item"><span>List Group Item</span></li>
                    <li class="list-group-item"><span>List Group Item</span></li>
                    <li class="list-group-item"><span>List Group Item</span></li>
                    <li class="list-group-item"><span>List Group Item</span></li>
                </ul>
            </div>
        </div>
    </div>


</div>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>



</body>

</html>
