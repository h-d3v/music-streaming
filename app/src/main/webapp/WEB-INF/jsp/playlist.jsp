<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <title>Ma playlist #1</title>
  <link href='https://fonts.googleapis.com/css?family=Allerta' rel='stylesheet'>
  <link href="css/playlistWidget.css" rel="stylesheet">
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<header>
  <nav class="navbar navbar-expand navbar-dark bg-dark flex-column flex-md-row bd-navbar">
    <div class="container"><a class="navbar-brand" href="#">RoseTube</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navbarResponsive"><span class="navbar-toggler-icon"></span></button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="nav navbar-nav ml-auto">
          <li class="nav-item" role="presentation"><a class="nav-link" href="player.jsp">Mon player</a></li>
          <li class="nav-item" role="presentation"><a class="nav-link" href="#">Mon compte : ${sessionScope.utilisateurConnecte.pseudo}</a></li>
          <li class="nav-item" role="presentation"><a class="nav-link" href="seDeconnecter">Se Deconnecter</a></li>
        </ul>
      </div>
    </div>
  </nav>
</header>
<div class="container" role="main">
  <div style="margin-top: 0" class="container">
    <div style="padding-top: 20px !important;" class="container-fluid">
      <h3 class="text-center text-dark">Titre de la playlist</h3>
      <div class="row">
        <div style="background-color:lightsalmon " class="col-lg-12 mx-auto rounded shadow">
          <!-- Fixed header table-->
          <div class="table-responsive">
            <table id="tableTitre"  class="table table-striped table-dark table-fixed">
              <thead>
              <tr>
                <th scope="col" class="col-2">Titre</th>
                <th scope="col" class="col-2">Artise</th>
                <th scope="col" class="col-2">Durée</th>
                <th scope="col" class="col-2"><span class="oi oi-heart" title="heart" aria-hidden="true"></span></th>
                <th scope="col" class="col-2"><span class="oi oi-thumb-down" title="thumb down" aria-hidden="true"></span></th>
                <th scope="col" class="col-2">Genre</th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td class="col-2">Otto</td>
                <td class="col-2">Sch</td>
                <td class="col-2">3:09</td>
                <td class="col-2">76</td>
                <td class="col-2">87</td>
                <td class="col-2">Rap</td>
              </tr>
              <tr>
                <td class="col-2">Otto</td>
                <td class="col-2">Sch</td>
                <td class="col-2">3:09</td>
                <td class="col-2">76</td>
                <td class="col-2">87</td>
                <td class="col-2">Rap</td>
              </tr>
              <tr>
                <td class="col-2">Otto</td>
                <td class="col-2">Sch</td>
                <td class="col-2">3:09</td>
                <td class="col-2">76</td>
                <td class="col-2">87</td>
                <td class="col-2">Rap</td>
              </tr>
              <tr>
                <td class="col-2">Otto</td>
                <td class="col-2">Sch</td>
                <td class="col-2">3:09</td>
                <td class="col-2">76</td>
                <td class="col-2">87</td>
                <td class="col-2">Rap</td>
              </tr>
              <tr>
                <td class="col-2">Otto</td>
                <td class="col-2">Sch</td>
                <td class="col-2">3:09</td>
                <td class="col-2">76</td>
                <td class="col-2">87</td>
                <td class="col-2">Rap</td>
              </tr>
              <tr>
                <td class="col-2">Otto</td>
                <td class="col-2">Sch</td>
                <td class="col-2">3:09</td>
                <td class="col-2">76</td>
                <td class="col-2">87</td>
                <td class="col-2">Rap</td>
              </tr>
              </tbody>
            </table>
          </div>
          <!-- End -->
        </div>
      </div>
    </div>
  </div>
  <div class="row container-fluid">
    <div class="col-4">
      <img style="margin-top: 10px;" class="img-thumbnail img-fluid" src="https://generative-placeholders.glitch.me/image?width=120&height=120&style=tiles" alt="image album">
    </div>
    <div style="margin-top: 40px" class="col-4">
      <h3 class="h3 text-left text-dark">
        Otto
      </h3>
    </div>
    <div style="margin-top: 40px" class="col-4">
      <h3 class="h3 text-dark">
        Par : SCH
      </h3>
    </div>
  </div>

</div>
<footer class="footer fixed-bottom">
  <audio id="" controls  loop autoplay>
    <source src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/9473/new_year_dubstep_minimix.ogg" type="audio/ogg">
    Your browser dose not Support the audio Tag
  </audio>
</footer>
</body>
</html>