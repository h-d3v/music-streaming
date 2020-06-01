function enregistrerPlayList(utilisateur) {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            location.reload();
        }
    };
    xhttp.open("GET", "/utilisateurs/"+utilisateur+"/addPlayList?nom="
        +document.getElementById("nomPlayListAEnregistrer").elements[0].value  , true);
    xhttp.send();
}
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

function ajouterLike(nom, titreId, action) {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            afficherLikes(titreId);
            if(action==='like') {
                document.getElementById("like"+titreId).style = 'color:red';
                document.getElementById("dislike"+titreId).style = 'color:white';
            }else if(action==='dislike'){
                document.getElementById("dislike"+titreId).style = 'color:red';
                document.getElementById("like"+titreId).style = 'color:white';
            }
        }
    };
    xhttp.open("GET", "/like/"+ "?action="  + action+"&utilisateurPseudo=" +nom+"&titreId="+ titreId, true);
    xhttp.send();
}

function ajouterComment(userPseudo) {
    const comment= document.getElementById("text-area-comment").value;
    const titreId= document.getElementById("titreIdComment").innerHTML;
    let xhttp =new XMLHttpRequest();
    xhttp.onreadystatechange=function(){
        alert(this.responseText);
    };
    xhttp.open("GET", "/addcomment/?comment="+comment+"&titreId="+titreId+"&userPseudo="+userPseudo, true);
    xhttp.send();
}


function afficherLikes(titreId) {
    let xhr= new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let tab =this.responseText.split(":");
            document.getElementById('nbrLikes'+titreId).innerText=tab[0];
            document.getElementById('nbrDislikes'+titreId).innerText=tab[1];
        }
    };
    xhr.open("GET", "/titre/"+titreId+"/likes", true);
    xhr.send();
}




function ouvrirModal(titreId, titreNom, titreArtiste){
    document.getElementById("message").innerHTML ="";
    document.getElementById("modalAjouterTitre").innerHTML="Ajouter le titre "+titreNom +" de "+titreArtiste;
    document.getElementById("titreId").innerHTML=titreId;
}


function ouvrirModalComment(titreId) {
    alert(titreId);
    document.getElementById("titreIdComment").innerHTML= titreId;
    alert(document.getElementById("titreIdComment").innerHTML);
}



function supprimerPlayList(playListId, utilisateur){
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById('playlist'+playListId).remove();
        }
    };
    xhttp.open("DELETE",'/utilisateurs/'+utilisateur+'/supprimerPlayList/'+playListId, true);
    xhttp.send();

}




function supprimerTitre(titreId, idPlayList){
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if (this.readyState == 4 && this.status == 200){
            location.reload();
        }

    };
    xhttp.open("GET", "/playlist/"+idPlayList+"/supprimerTitre?titreId="+titreId  , true);
    xhttp.send();
}


