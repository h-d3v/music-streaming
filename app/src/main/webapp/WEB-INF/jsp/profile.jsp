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
                    <li class="nav-item" role="presentation"><a class="nav-link" href="Explore">Explorer</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="#">Mes playlists</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="seDeconnecter">Se Deconnecter</a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<div class="container profile profile-view" id="profile">
    <div class="row">
        <div class="col-md-12 alert-col relative">
            <div class="alert alert-success alert-dismissible">
                <a href="#" class="close" data-dismiss="alert" aria-label="Close">&times;</a>
                <strong>Success</strong> Votre mot de passe a ete changer !
            </div>
        </div>
    </div>
    <form class="text-white">
        <div class="form-row profile-row">
            <div class="col-md-4 relative">
                <div class="avatar">
                    <div class="avatar-bg center">
                        <img src='https://avataaars.io/?avatarStyle=Circle&topType=ShortHairTheCaesar&accessoriesType=Sunglasses&hairColor=SilverGray&facialHairType=Blank&clotheType=Hoodie&clotheColor=PastelRed&eyeType=Default&eyebrowType=Default&mouthType=Default&skinColor=Light' alt="avatar"/>
                    </div>
                </div><input type="file" class="form-control" name="avatar-file" /></div>
            <div class="col-md-8">
                <h1 class="">{nom du profile} </h1>
                <hr />
                <div class="form-row ">
                    <div class="col-sm-12 col-md-6">
                        <div class="form-group"><label>Prenom </label><input class="form-control" type="text" name="firstname" /></div>
                    </div>
                    <div class="col-sm-12 col-md-6">
                        <div class="form-group"><label>Nom </label><input class="form-control" type="text" name="lastname" /></div>
                    </div>
                </div>
                <div class="form-group"><label>Email </label><input class="form-control" type="email" autocomplete="off" required name="email" /></div>
                <div class="form-row">
                    <div class="col-sm-12 col-md-6">
                        <div class="form-group"><label>Mot de passe </label><input class="form-control" type="password" name="password" autocomplete="off" required /></div>
                    </div>
                    <div class="col-sm-12 col-md-6">
                        <div class="form-group"><label>Confirmer le mot de passe </label><input class="form-control" type="password" name="confirmpass" autocomplete="off" required /></div>
                    </div>
                </div>
                <hr />
                <div class="form-row">
                    <div class="col-md-12 content-right"><button class="btn btn-success form-btn" type="submit">Sauvegarder </button></div>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>