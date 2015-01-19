var compteur=0;

function retireDiscipline(){
	if(compteur>1){
		document.getElementById("disciplines").removeChild(document.getElementById("disciplines").lastChild);
		compteur--;
	}else if(compteur == 1){
		document.getElementById("select1").style.display="none";
		compteur --;
	}
}

function ajoutDiscipline(){
	if(compteur == 0){
		document.getElementById("select1").style.display="block";
		compteur++;
	}else{
		compteur++;
		var div = document.getElementById("disciplines").lastElementChild.cloneNode(true);
		div.id="select"+compteur;
		document.getElementById("disciplines").appendChild(div);
		document.getElementById("select"+compteur).firstChild.nextSibling.nextSibling.nextSibling.name="disciplines"+compteur;
		/*<!--document.getElementById(compteur).lastElementChild.firstElementChild.name="clas"+compteur;	-->*/
	}
}

$(function() {
	bouton1=document.getElementById("ajoutDiscipline");
	bouton2=document.getElementById("retireDiscipline");
	ajouteEvent(bouton1, 'click', ajoutDiscipline, false);
	ajouteEvent(bouton2, 'click', retireDiscipline, false);
	document.getElementById("select1").style.display="none";
	
	$(".supprimerDiscipline").click(function (e) {
		var div = e.target.parentNode;
		div.parentNode.removeChild(div);
	});
});