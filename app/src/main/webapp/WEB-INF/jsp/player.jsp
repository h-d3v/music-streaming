<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=yes">
    <title>tpAppWeb</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Catamaran:100,200,300,400,500,600,700,800,900">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/scrollbar-1.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/player.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/img/open-iconic-master/font/css/open-iconic-bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/player.js"></script>

</head>

<body>
<nav class="navbar navbar-dark navbar-expand-lg fixed-top bg-dark navbar-custom">
    <div class="container"><a class="navbar-brand" href="#">RoseTube</a>
        <button data-toggle="collapse" class="navbar-toggler" data-target="#navbarResponsive"><span
                class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="nav navbar-nav ml-auto">

                <li class="nav-item" role="presentation">
                    <a class="nav-link" href="${pageContext.request.contextPath}/profile">
                        Mon compte :
                        ${sessionScope.utilisateurConnecte.pseudo}
                        <c:if test="${sessionScope.utilisateurConnecte.estAdmin==true}"> ADMIN </c:if>
                    </a>
                </li>
                <li class="nav-item" role="presentation"><a class="nav-link"
                                                            href="${pageContext.request.contextPath}/titreSearch">Explorer</a>
                </li>
                <li class="nav-item" role="presentation"><a class="nav-link"
                                                            href="${pageContext.request.contextPath}/seDeconnecter">Se
                    Deconnecter</a></li>

            </ul>
        </div>
    </div>
</nav>
<div style="margin-top: 71px;">
    <div class="container">
        <div class="row">
            <div class="col-md-3 col-lg-3 col-xl-3">
                <section>
                    <h4>Genres</h4>
                    <ul class="list-group sc-overflow" style="max-height: 200px;">
                        <c:forEach items="${genres}" var="genre">
                            <li><a class="nav-link list-group-item" href='/playlist/${genre}/'> ${genre} </a></li>
                        </c:forEach>

                    </ul>

                </section>
                <section>
                    <h4>Mes Playlists</h4>
                    <ul class="list-group sc-overflow" style="max-height: 280px;">
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
                                            <div class="form-group"><input type="text"  class="form-control" name="nom" placeholder="Nom de la playlist" required /></div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
                                            <button type="button" onclick="enregistrerPlayList('${sessionScope.utilisateurConnecte.pseudo}')"  class="btn btn-primary">Enregistrer</button>
                                        </div>
                                    </form>

                                </div>
                            </div>
                        </div>


                        <!-- Liste des Playlists -->
                        <c:forEach items="${sessionScope.playlistsUtilisateur}" var="playList">
                            <li id="playlist${playList.id}" class="list-group-item">
                                <span class="oi oi-delete" title="Supprimer la Playlist" type="button"
                                      style="margin-right: 5px" onclick="supprimerPlayList(${playList.id})">

                                </span>
                                <a title="lire la Playlist"
                                   href="/playlist/${sessionScope.utilisateurConnecte.pseudo}/${playList.id}">
                                    <span>${playList.nom}</span> </a>

                            </li>

                        </c:forEach>

                    </ul>
                </section>
            </div>
            <!-- Liste des Titres par genre -->
            <div class="col-md-9 col-lg-9 col-xl-9 sc-overflow" style="max-height: 480px">
                <div style="padding-top: 2px !important;" class="container-fluid">
                    <h3 class="text-center text-dark">${ !empty titresLectureActuelle ?  titresLectureActuelle.nom : 'Selectionnez une playlist'}</h3>
                    <div class="row">
                        <c:if test="${empty titresLectureActuelle.listeTitres }">
                            <div><p>La liste de lecture est vide, vous pouvez rechercher des titres et les ajouter en
                                allant sur les pages rechercher et genres</p></div>
                        </c:if>
                        <c:if test="${ !empty titresLectureActuelle.listeTitres }">

                            <div class="table-responsive">
                                <table id="tableTitre" class="table table-striped table-dark table-fixed">
                                    <thead>
                                    <tr>
                                        <th scope="col" class="col-1"></th>
                                        <th scope="col" class="col-2">Titre</th>
                                        <th scope="col" class="col-2">Artiste</th>
                                        <th scope="col" class="col-2">Genre</th>
                                        <th scope="col" class="col-2">Durée</th>
                                        <th scope="col" class="col-1"></th>
                                        <c:if test="${titresLectureActuelle.id>0}">
                                            <th scope="col" class="col-1"></th>
                                        </c:if>
                                        <th scope="col" class="col-1"></th>
                                        <th scope="col" class="col-1"></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${titresLectureActuelle.listeTitres}" var='titre'>
                                        <tr>
                                            <td class="col-1" type="button" onclick="lireTitre(${titre.id})"><span
                                                    class="oi oi-media-play" title="lire le titre"
                                                    aria-hidden="false"></span></td>
                                            <td class="col-2">${titre.nom}</td>
                                            <td class="col-2">${titre.nomArtiste}</td>
                                            <td class="col-2">${titre.genre}</td>
                                            <td class="col-2">3:${titre.duree}</td>
                                            <td class="col-1" type="button" title="Ajouter le titre"
                                                onclick='ouvrirModal(${titre.id} ,"${titre.nom}", "${titre.nomArtiste}")'
                                                data-toggle="modal" data-target="#modalAjouterTritre">
                                                <span class="oi oi-plus"></span>
                                            </td>
                                            <td class="col-1" type="button" title="Commenter le titre" onclick="ouvrirModalComment(${titre.id})"
                                                data-toggle="modal" data-target="#modalAjoutComment">
                                                <span class="oi oi-comment-square"></span>
                                            </td>
                                            <c:if test="${titresLectureActuelle.id>0}">
                                                <td class="col-1" type="button" title="Supprimer le titre"
                                                    onclick='supprimerTitre(${titre.id}, ${titresLectureActuelle.id}) '>
                                                    <span class="oi oi-minus"></span>
                                                </td>
                                            </c:if>
                                            <td class="col-2">
                                    <span id="like${titre.id}" type="button"
                                          onclick="ajouterLike('${sessionScope.utilisateurConnecte.pseudo}', ${titre.id},'like')"
                                          class="oi oi-heart"
                                            <c:forEach items="${likesOuDislikesUser}" var="like">
                                                <c:if test="${like.titreId.id==titre.id && like.likeOuDislike==true}">
                                                    style = 'color:red'
                                                </c:if>
                                            </c:forEach>
                                          title="J'aime" aria-hidden="false">

                                    </span>

                                                <div id="nbrLikes${titre.id}">${titre.nbrlikeOuDislike[0]}</div>

                                            </td>
                                            <td class="col-2">
                                    <span id="dislike${titre.id}"
                                            <c:forEach items="${likesOuDislikesUser}" var="like">
                                                <c:if test="${like.titreId.id==titre.id && like.likeOuDislike==false}">
                                                    style = 'color:red'
                                                </c:if>
                                            </c:forEach>
                                          type="button"
                                          onclick="ajouterLike('${sessionScope.utilisateurConnecte.pseudo}', ${titre.id},'dislike')"
                                          class="oi oi-thumb-down" title="Je n'aime pas" aria-hidden="false">

                                    </span
                                    >
                                                <div id="nbrDislikes${titre.id}">${titre.nbrlikeOuDislike[1]}</div>
                                            </td>

                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>



                            </div>

                        </c:if>
                        <c:if test="${ empty titresLectureActuelle }">
                            <p>Vos titres de la playlist s'afficheront ici</p>
                        </c:if>

                    </div>


                </div>
            </div>

        </div>
        <div class="row">
            <div class="col-md-3 col-lg-3 col-xl-3">
                <section>
                    <h4>Lecture en cours</h4>
                    <img class="imageAlbum" id="imagePath" alt="cover musique en cours"
                         src="${pageContext.request.contextPath}/img/noMusic.jpg"></section>
                <audio id="mp3fichier" src="" controls="" style="width: 100%;"></audio>
                <h5>Titre : <span id="titreLecture"></span></h5>
                <h6>Artiste : <span id="nomArtisteLecture"></span></h6>
                </section>
            </div>
            <div class="col-md-9 col-lg-9 col-lg-xl-9">
                <h4>Commentaires</h4>
                <ul class="list-group sc-overflow" style="max-height: 300px;">
                    <li class="list-group-item"><span>List Group Item</span></li>
                    <li class="list-group-item"><span>List Group Item</span></li>
                    <li class="list-group-item"><span>List Group Item</span></li>
                    <li class="list-group-item"><span>List Group Item</span></li>
                </ul>
            </div>
        </div>
    </div>

    <!-- Modal pour ajouter un commentaire a un titre-->
    <div class="modal fade" id="modalAjoutComment" tabindex="-1" role="dialog"
         aria-labelledby="modalAjoutComment" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 style="color:lightsalmon" class="modal-title">Commenter le titre</h5>
                    <button type="button" class="close" data-dismiss="modal"
                            aria-label="Close">
                        <span class="oi oi-x" aria-hidden="true"></span>
                    </button>
                </div>

                <div class="modal-body">
                    <p id="titreIdComment" style="display: none"></p>
                    <div id="messageModalComment" style="color: #1d2124"></div>
                    <h6 style="color: #1d2124">Veuillez entrez votre commentaire</h6>
                    <div class="mb-4">
                        <i class="fa fa-pencil"></i>
                        <label for="text-area-comment"></label><textarea id="text-area-comment" placeholder="Entrer votre commentaire..."  class="md-textarea form-control" rows="3">ghhhhhhhhhhh</textarea>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" onclick="ajouterComment('${sessionScope.utilisateurConnecte.pseudo}')" class="btn btn-primary">Commenter</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal pour ajouter un titre a une playlist-->
    <div class="modal fade" id="modalAjouterTritre" tabindex="-1" role="dialog"
         aria-labelledby="modalAjouterTritre" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 style="color:lightsalmon" class="modal-title"
                        id="modalAjouterTitre"></h5>
                    <button type="button" class="close" data-dismiss="modal"
                            aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>


                <div class="modal-body">
                    <h6 style="color: #1d2124">Veuillez selectionner une playlist</h6>
                    <div id="titreId" hidden></div>
                    <div id="message" style="color: #1d2124"></div>
                    <select id="selectPlayList" class="custom-select" name="PlayLists">
                        <c:forEach items="${sessionScope.playlistsUtilisateur}"
                                   var="playList">
                            <option value="${playList.id}">${playList.nom}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">
                        Fermer
                    </button>
                    <button type="button" onclick="enregistrerTitreDansPlayList()"
                            class="btn btn-primary">Enregistrer
                    </button>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>
