function chercherTitre() {
    var i;
    var search = document.getElementById("search");
    var filter = search.value.toUpperCase();
    const titresBody = document.getElementsByClassName("card-body");
    const conteneursTitres = document.getElementsByClassName("col-lg-4");
    for (i = 0; i < titresBody.length; i++) {
        let h5 = titresBody[i].getElementsByTagName("h5")[0];
        let p = titresBody[i].getElementsByTagName("p")[0];
        let h8 = titresBody[i].getElementsByTagName("h8")[0];
        let txtValue = h5.textContent || h5.innerText;
        txtValue += p.innerText || p.textContent;
        txtValue += h8.innerText || p.textContent;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            conteneursTitres[i].style.display = "";
        } else {
            conteneursTitres[i].style.display = "none";
        }
    }
}

function jouerTitre() {
    const cheminTitreAJouer=document.getElementById("chemin-titre").innerHTML;
    const cheminTitrePlayer=document.getElementById("chemint-titre-player").innerHTML;
    const nomTtreAJouer=document.getElementById("titre");
    const artisteTitreAJouer=document.getElementById("titre-artiste");
    const imageTitreAJouer=document.getElementById("titre-img");
    //TODO fair en sorte que le player joue sur le clique et modifie les infos.
}