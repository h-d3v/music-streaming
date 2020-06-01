<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <title>Profile</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>

<body class="bg-dark">

<header>
    <nav class="navbar navbar-expand navbar-dark bg-dark flex-column flex-md-row bd-navbar">
        <div class="container"><a class="navbar-brand" href="#">RoseTube</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navbarResponsive"><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item" role="presentation"><a class="nav-link" href="${pageContext.request.contextPath}/titreSearch">Explorer</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="${pageContext.request.contextPath}/">Mes playlists</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="seDeconnecter">Se Deconnecter</a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<div class="container profile profile-view" id="profile">
    <div class="row">
        <div class="col-md-12 alert-col relative">
            <c:if test="${succes==true}">
            <div class="alert alert-success alert-dismissible">
                <a href="#" class="close" data-dismiss="alert" aria-label="Close">&times;</a>
                <strong>Success</strong> Votre mot de passe a ete changer !
            </div>
            </c:if>
            <c:if test="${succes==false}">
                <div class="alert alert-danger alert-dismissible">
                    <a href="#" class="close" data-dismiss="alert" aria-label="Close">&times;</a>
                    <strong>Erreur</strong> Votre mot de passe n'a pu etre changer !
                </div>
            </c:if>
        </div>
    </div>
    <c:if test="${sessionScope.utilisateurConnecte.estAdmin==true}">
    <h1> Compte Administrateur</h1>
    <a href="${pageContext.request.contextPath}/upload">Cliquez ici pour ajouter des musiques</a>
    </c:if>
    <form class="text-white" method="post" action="modifierMotPasse">
        <div class="form-row">
            <div class="col-md-12 relative">
                <div class="avatar">
                    <div class="avatar-bg center">
                        <img src='https://avataaars.io/?avatarStyle=Circle&topType=ShortHairTheCaesar&accessoriesType=Sunglasses&hairColor=SilverGray&facialHairType=Blank&clotheType=Hoodie&clotheColor=PastelRed&eyeType=Default&eyebrowType=Default&mouthType=Default&skinColor=Light' alt="avatar"/>
                    </div>

            <div class="col-md-12">
                <h1>${sessionScope.utilisateurConnecte.pseudo} </h1>

                <h2>Modifier votre mot de passe</h2>
                <hr />

                <div class="form-group"><label>Email </label><input class="form-control" type="email" autocomplete="off" required name="email" /></div>
                <div class="form-row">
                    <div class="form-group"><label>Votre ancien mot de passe </label><input class="form-control" type="password" name="vieuxpassword" autocomplete="off" required /></div>
                </div>
                <div class="form-row">
                    <div class="col-sm-12 col-md-6">
                        <div class="form-group"><label>Nouveau mot de passe </label><input class="form-control" type="password" name="Nouveaupassword" autocomplete="off" required /></div>
                    </div>
                    <div class="col-sm-12 col-md-6">
                        <div class="form-group"><label>Confirmer le nouveau mot de passe </label><input class="form-control" type="password" name="confirmpass" autocomplete="off" required /></div>
                    </div>
                </div>
                <hr />
                <div class="form-row">
                    <div class="col-md-12 content-right"><button class="btn btn-success form-btn" type="submit">Enregistrer </button></div>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>