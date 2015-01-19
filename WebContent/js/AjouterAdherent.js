var compteur=1;

function retireDiscipline(){
	if(compteur>1){
		document.getElementById("disciplines").removeChild(document.getElementById("disciplines").lastChild);
		compteur--;
	}
}

function ajoutDiscipline(){
	compteur++;
	var tr = document.getElementById("disciplines").lastElementChild.cloneNode(true);
	tr.id=compteur;
	document.getElementById("disciplines").appendChild(tr);
	document.getElementById(compteur).firstElementChild.firstElementChild.name="dis"+compteur;
	document.getElementById(compteur).lastElementChild.firstElementChild.name="clas"+compteur;	
}

$(function() {
	bouton1=document.getElementById("ajoutDiscipline");
	bouton2=document.getElementById("retireDiscipline");
	ajouteEvent(bouton1, 'click', ajoutDiscipline, false);
	ajouteEvent(bouton2, 'click', retireDiscipline, false);
});
