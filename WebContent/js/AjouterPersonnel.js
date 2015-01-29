var compteur=1;
var compteurF=1
function retireDiplome(){
	if(compteur>1){
		document.getElementById("divDiplome" + (compteur-1)).appendChild(document.getElementById("ajoutDiplome").cloneNode(true));
		document.getElementById("divDiplome" + (compteur-1)).appendChild(document.getElementById("retireDiplome").cloneNode(true));
		document.getElementById("diplomes").removeChild(document.getElementById("diplomes").lastChild);
		ajoutEventAjoutDiplome();
		ajoutEventRetireDiplome();
		compteur--;
	}
}

function ajoutDiplome(){
	//$("#divDiplome"+compteur + "input").remove();
	compteur++;
	var tr = document.getElementById("diplomes").lastElementChild.cloneNode(true);
	tr.id="divDiplome"+compteur;
	document.getElementById("diplomes").appendChild(tr);
	document.getElementById("divDiplome"+compteur).firstChild.nextSibling.nextSibling.nextSibling.name="diplome"+compteur;
	
	$("#divDiplome"+(compteur-1) + " input[type=button]").remove();
	ajoutEventAjoutDiplome();
	ajoutEventRetireDiplome();
}

function retireFonction(){
	if(compteurF>1){
		document.getElementById("divFonction" + (compteurF-1)).appendChild(document.getElementById("ajoutFonction").cloneNode(true));
		document.getElementById("divFonction" + (compteurF-1)).appendChild(document.getElementById("retireFonction").cloneNode(true));
		document.getElementById("fonctions").removeChild(document.getElementById("fonctions").lastChild);
		ajoutEventAjoutFonction();
		ajoutEventRetireFonction();
		compteurF--;
	}
}

function ajoutFonction(){
//	$("#divFonction"+compteurF + "input").remove();
	compteurF++;
	var tr = document.getElementById("fonctions").lastElementChild.cloneNode(true);
	tr.id="divFonction"+compteurF;
	document.getElementById("fonctions").appendChild(tr);
	document.getElementById("divFonction"+compteurF).firstChild.nextSibling.nextSibling.nextSibling.name="fonction"+compteurF;
	
	//Supprime les boutons de l'avant dernier champ
	$("#divFonction"+(compteurF-1) + " input[type=button]").remove();
	ajoutEventAjoutFonction();
	ajoutEventRetireFonction();
}

$(function() {
	ajoutEventAjoutDiplome();
	ajoutEventRetireDiplome();
	ajoutEventAjoutFonction();
	ajoutEventRetireFonction();
});

function ajoutEventAjoutDiplome(){
	bouton1=document.getElementById("ajoutDiplome");
	ajouteEvent(bouton1, 'click', ajoutDiplome, false);
}

function ajoutEventRetireDiplome(){
	bouton2=document.getElementById("retireDiplome");
	ajouteEvent(bouton2, 'click', retireDiplome, false);
}

function ajoutEventAjoutFonction(){
	bouton1=document.getElementById("ajoutFonction");
	ajouteEvent(bouton1, 'click', ajoutFonction, false);
}

function ajoutEventRetireFonction(){
	bouton2=document.getElementById("retireFonction");
	ajouteEvent(bouton2, 'click', retireFonction, false);
}

function afficherDuree(){
	var duree= document.getElementById("duree");
	var liste= document.getElementById("type");
	var option= liste.options.selectedIndex;
	if(option.value!= "cdi"){
		duree.style.visibility="visible";
	}
	
}