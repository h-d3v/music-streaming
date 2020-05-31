function chercherTitre() {
    var i;
    var search = document.getElementById("search");
    var filter = search.value.toUpperCase();
    const titresBody = document.getElementsByClassName("card-body");
    const conteneursTitres = document.getElementsByClassName("mx-auto");

    for (i = 0; i < titresBody.length; i++) {
        let h5 = titresBody[i].getElementsByTagName("h5")[0];
        let p = titresBody[i].getElementsByTagName("p")[0];
        let h6 = titresBody[i].getElementsByTagName("h6")[0];
        let txtValue = h5.textContent || h5.innerText;

        txtValue += p.innerText || p.textContent;
        txtValue += h6.innerText || p.textContent;

        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            conteneursTitres[i].style.display = "";
        } else {
            conteneursTitres[i].style.display = "none";
        }
    }
}

function jouerTitre(x) {

    //Prend les infos du titres
    const nomTitreToPlay=document.getElementById("titre-nom-"+x.id).innerText;
    const artisteTitreToPlay=document.getElementById("titre-artiste-"+x.id).innerText;
    const imgToPlay=document.getElementById("titre-img-"+x.id).src;

    //Modifie les info dans le player
    document.getElementById("player-img").src=imgToPlay;
    document.getElementById("player-img").style.display="";
    document.getElementById("msg-player").style.display="none";
    document.getElementById("player-nom-titre").innerText=nomTitreToPlay;
    document.getElementById("player-artiste").innerText=artisteTitreToPlay;

    //joue le titre
    const player=document.getElementsByTagName("audio")[0];
    document.getElementsByTagName("source")[0].src=document.getElementById("chemin-titre-" + x.id).innerText;
    player.load();
    player.play();

}