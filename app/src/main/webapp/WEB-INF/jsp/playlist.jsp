<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <title>Ma playlist #1</title>
  <link rel="stylesheet" href="css/musicWidget.css">
  <link href='https://fonts.googleapis.com/css?family=Allerta' rel='stylesheet'>
  <link rel="stylesheet" href="css/scrollbar.css">
  <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="css/black-footer.css" rel="stylesheet">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <link href="img/open-iconic-master/font/css/open-iconic-bootstrap.css" rel="stylesheet">

  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
</head>
<header>
  <nav class="navbar navbar-dark navbar-expand-lg fixed-top bg-dark navbar-custom overflow-hidden">
    <div class="container"><a class="navbar-brand" href="#">RoseTube</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navbarResponsive"><span class="navbar-toggler-icon"></span></button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="nav navbar-nav ml-auto">

          <li class="nav-item" role="presentation"><a class="nav-link" href="#">Mon compte : ${sessionScope.utilisateurConnecte.pseudo}</a></li>
          <li class="nav-item" role="presentation"><a class="nav-link" href="seDeconnecter">Se Deconnecter</a></li>
        </ul>
      </div>
    </div>
  </nav>
</header>
<body class="overflow-auto">
<!--Copyright (c) 2020 by Rofida Abd Elrahman (https://codepen.io/Roro-decode/pen/VWpLRm)-->
  <div style="margin-top: 70px;" class="container-audio">
<!--
    <div class="colum1">
      <div class="row"></div>
    </div>
    <div class="colum1">
      <div class="row"></div>
    </div>
    <div class="colum1">
      <div class="row"></div>
    </div>
    <div class="colum1">
      <div class="row"></div>
    </div>
    <div class="colum1">
      <div class="row"></div>
    </div>
    <div class="colum1">
      <div class="row"></div>
    </div>
    <div class="colum1">
      <div class="row"></div>
    </div>
    <div class="colum1">
      <div class="row"></div>
    </div>
    <div class="colum1">
      <div class="row"></div>
    </div>
    <div class="colum1">
      <div class="row"></div>
    </div>
    <div class="colum1">
      <div class="row"></div>
    </div>
    <div class="colum1">
      <div class="row"></div>
    </div>
    <div class="colum1">
      <div class="row"></div>
    </div>
    <div class="colum1">
      <div class="row"></div>
    </div>
    <div class="colum1">
      <div class="row"></div>
    </div>
    <div class="colum1">
      <div class="row"></div>
    </div>
    <div class="colum1">
      <div class="row"></div>
    </div>
    <div class="colum1">
      <div class="row"></div>
    </div>
    <div class="colum1">
      <div class="row"></div>
    </div>
    <div class="colum1">
      <div class="row"></div>
    </div>
    <div class="colum1">
      <div class="row"></div>
    </div>
-->
    <div class="container py-5">
      <h3 class="text-center text-white">Titre de la playlist</h3>
      <div class="row">

        <div class="col-lg-12 mx-auto bg-white rounded shadow">

          <!-- Fixed header table-->
          <div class="table-responsive">
            <table class="table table-fixed">
              <thead>
              <tr>
                <th scope="col" class="col-2 text-white">img</th>
                <th scope="col" class="col-2">Artise</th>
                <th scope="col" class="col-2">Durée</th>
                <th scope="col" class="col-2"><span class="oi oi-heart" title="heart" aria-hidden="true"></span></th>
                <th scope="col" class="col-2"><span class="oi oi-thumb-down" title="thumb down" aria-hidden="true"></span></th>
                <th scope="col" class="col-2">Genre</th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td class="col-2"><img src="https://via.placeholder.com/20 " alt="cover titre"/></td>
                <td class="col-2">Sch otto</td>
                <td class="col-2">Otto</td>
                <td class="col-2">76</td>
                <td class="col-2">87</td>
                <td class="col-2">87</td>
              </tr>
              <tr >
                <td class="col-2"><img src="https://via.placeholder.com/20 " alt="cover titre"/></td>
                <td class="col-2">Sch otto</td>
                <td class="col-2">Otto</td>
                <td class="col-2">76</td>
                <td class="col-2">87</td>
                <td class="col-2">87</td>
              </tr>
              </tbody>
            </table>
          </div>
          <!-- End -->
        </div>
      </div>
    </div>
  </div>
</body>
<footer class="footer overflow-auto">
  <div class="container-audio">
    <audio id="" controls  loop autoplay>
      <source src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/9473/new_year_dubstep_minimix.ogg" type="audio/ogg">
      Your browser dose not Support the audio Tag
    </audio>
  </div>
</footer>
</html>