<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Home - RoseTube</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Catamaran:100,200,300,400,500,600,700,800,900">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i">
    <link rel="stylesheet" href="css/scrollbar-1.css">
    <link rel="stylesheet" href="css/scrollbar.css">
    <link rel="stylesheet" href="css/untitled.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script src="https://code.iconify.design/1/1.0.5/iconify.min.js"></script>

</head>

<body>

<!-- Modal pour un nouveau compte -->
<div id="modalNewAccount" role="dialog" tabindex="-1" class="modal fade">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Inscrivez-vous</h4><button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button></div>
            <div class="modal-body">
                <form method="post" action="/add">
                    <div class="form-group"><input type="text" class="form-control" name="pseudo" placeholder="Nom d'utilisateur" /></div>
                    <div class="form-group"><input type="email" class="form-control" name="courriel" placeholder="adresse@courriel.ca" /></div>
                    <div class="form-group"><input type="password" class="form-control" name="motPasse" placeholder="Mot de passe" /></div>
                    <div class="form-group"><input type="password" class="form-control" name="password2" placeholder="Entrez le mot de passe une seconde fois" /></div>
                    <div class="form-group"><button class="btn btn-primary btn-block" type="submit">S'inscrire</button></div></form>
            </div>
            <div class="modal-footer"><button class="btn btn-light" type="button" data-dismiss="modal">Fermer</button></div>
        </div>
    </div>
</div>

<!-- Modal pour se connecter -->
<div id="modalLogin" role="dialog" tabindex="-1" class="modal fade">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Connectez-vous</h4><button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button></div>
            <div class="modal-body">
                <form method="post">
                    <div class="form-group"><input type="email" class="form-control" name="email" placeholder="adresse@courriel.ca" /></div>
                    <div class="form-group"><input type="password" class="form-control" name="password" placeholder="Mot de passe" /></div>
                    <div class="form-group"><button class="btn btn-primary btn-block" type="submit">Se connecter</button></div><a class="forgot" href="#">Vous avez oubliez votre mot de passe?</a></form>
            </div>
            <div class="modal-footer"><button  class="btn btn-light" type="button" data-dismiss="modal">Fermer</button></div>
        </div>
    </div>
</div>


<nav class="navbar navbar-dark navbar-expand-lg fixed-top bg-dark navbar-custom">
    <div class="container"><a class="navbar-brand" href="#">RoseTube</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navbarResponsive"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="nav navbar-nav ml-auto">
                <li class="nav-item"><button class="btn btn-primary" data-toggle="modal" data-target="#modalNewAccount" type="button">S'inscrire</button></li>
                <li class="nav-item"><button class="btn btn-primary" data-toggle="modal" data-target="#modalLogin" type="button">Se connecter</button></li>

            </ul>
        </div>
    </div>
</nav>
<header class="masthead text-center text-white">
    <div class="masthead-content">
        <div class="container">
            <h2 class="masthead-heading mb-0">Musique illimitee</h2>
            <h2 class="masthead-subheading mb-0">Enfin presque, on n'a pas les droits</h2><button class="btn btn-primary btn-xl rounded-pill mt-5" data-toggle="modal" data-target="#modalLogin" type="button">S'inscrire</button></div>
    </div>
    <div class="bg-circle-1 bg-circle"></div>
    <div class="bg-circle-2 bg-circle"></div>
    <div class="bg-circle-3 bg-circle"></div>
    <div class="bg-circle-4 bg-circle"></div>
</header>
<section>
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-6 order-lg-2">
                <div class="p-5"><img class="rounded-circle img-fluid" src="img/01.jpg"></div>
            </div>
            <div class="col-lg-6 order-lg-1">
                <div class="p-5">
                    <h2 class="display-4">Les plus grands noms de la musique</h2>
                    <p>Ou presque...<br>Ou presque pas...</p>
                </div>
            </div>
        </div>
    </div>
</section>
<section class="impair">
    <div class="container">
        <div class="row align-items-center impair">
            <div class="col-lg-6 order-lg-1">
                <div class="p-5"><img class="rounded-circle img-fluid" src="img/02.jpg"></div>
            </div>
            <div class="col-lg-6 order-lg-2">
                <div class="p-5">
                    <h2 class="display-4">Vibre avec tes amis</h2>
                    <p>Connecte toi avec tes amis.<br>Partage la musique que tu aimes.</p>
                </div>
            </div>
        </div>
    </div>
</section>
<section>
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-6 order-lg-2">
                <div class="p-5"><img class="rounded-circle img-fluid" src="img/03.jpg"></div>
            </div>
            <div class="col-lg-6 order-lg-1">
                <div class="p-5">
                    <h2 class="display-4">C'est toi qui a le controle.</h2>
                    <p><br>Offre soumise a conditions</p>
                </div>
            </div>
        </div>
    </div>
</section>
<footer class="py-5 bg-black">
    <div class="container">
        <p class="text-center text-white m-0 small">Copyright&nbsp;© RoseTube 2099</p>
    </div>
</footer>
<script src="js/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>

</html>
