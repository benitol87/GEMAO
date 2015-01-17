var compteur=1;
function retireDiplome(){
	if(compteur>1){
		document.getElementById("diplomes").deleteRow(-1);
		compteur--;
	}
}

function ajoutDiplome(){
	compteur++;
	var tr = document.getElementById("diplomes").lastElementChild.cloneNode(true);
	tr.id=compteur;
	document.getElementById("diplomes").appendChild(tr);
//	document.getElementById(compteur).firstElementChild.firstElementChild.name="dis"+compteur;
//	document.getElementById(compteur).lastElementChild.firstElementChild.name="clas"+compteur;	
}

$(function() {
	bouton1=document.getElementById("ajoutDiplome");
	bouton2=document.getElementById("retireDiplome");
	ajouteEvent(bouton1, 'click', ajoutDiplome, false);
	ajouteEvent(bouton2, 'click', retireDiplome, false);
});