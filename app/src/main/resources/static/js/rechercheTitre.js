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
function enregistrerTitreDansPlayList() {
    let e = document.getElementById("selectPlayList");
    let idPlayList = e.options[e.selectedIndex].value;
    let idTitre = document.getElementById("titreId").innerHTML;
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if (this.readyState == 4 && this.status == 200){
            document.getElementById("message").innerHTML = "Le titre a bien ete enregistre dans la Playlist";
        }
        else if (this.readyState == 4 && this.status == 409){
            document.getElementById("message").innerHTML = "Le titre se trouve deja dans la playlist";
        }
    };
    xhttp.open("GET","/playlist/"+idPlayList+"/ajouterTitre?titreId="+idTitre  , true);
    xhttp.send();


}


function ouvrirModal(titreId, titreNom, titreArtiste) {

    document.getElementById("message").innerHTML = "";
    document.getElementById("modalAjouterTitre").innerHTML = "Ajouter le titre " + titreNom + " de " + titreArtiste;
    document.getElementById("titreId").innerHTML = titreId;
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