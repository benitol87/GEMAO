(function(factory) {
	if (typeof define === "function" && define.amd) {

		// AMD. Register as an anonymous module.
		define([ "../jquery.ui.datepicker" ], factory);
	} else {

		// Browser globals
		factory(jQuery.datepicker);
	}
}(function(datepicker) {
	datepicker.regional['fr'] = {
		closeText : 'Fermer',
		prevText : 'Précédent',
		nextText : 'Suivant',
		currentText : 'Aujourd\'hui',
		monthNames : [ 'janvier', 'février', 'mars', 'avril', 'mai', 'juin',
				'juillet', 'août', 'septembre', 'octobre', 'novembre',
				'décembre' ],
		monthNamesShort : [ 'janv.', 'févr.', 'mars', 'avril', 'mai', 'juin',
				'juil.', 'août', 'sept.', 'oct.', 'nov.', 'déc.' ],
		dayNames : [ 'dimanche', 'lundi', 'mardi', 'mercredi', 'jeudi',
				'vendredi', 'samedi' ],
		dayNamesShort : [ 'dim.', 'lun.', 'mar.', 'mer.', 'jeu.', 'ven.',
				'sam.' ],
		dayNamesMin : [ 'D', 'L', 'M', 'M', 'J', 'V', 'S' ],
		weekHeader : 'Sem.',
		dateFormat : 'dd/mm/yy',
		firstDay : 1,
		isRTL : false,
		showMonthAfterYear : false,
		yearSuffix : ''
	};
	datepicker.setDefaults(datepicker.regional['fr']);

	return datepicker.regional['fr'];

}));

var compteur=1;

function ajouteEvent(objet, typeEvent, nomFunction, typePropagation){
	
	if(objet.addEventListener){
		objet.addEventListener(typeEvent,nomFunction,typePropagation);
	} else if(objet.attachEvent){
		objet.attachEvent('on'+typeEvent,nomFunction);
	}
}

function retireDiscipline(){
	if(compteur>1){
		document.getElementById("disciplines").deleteRow(-1);
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
	$("#dateInscri").datepicker();
	$("#dateNaiss").datepicker();
	bouton1=document.getElementById("ajoutDiscipline");
	bouton2=document.getElementById("retireDiscipline");
	ajouteEvent(bouton1, 'click', ajoutDiscipline, false);
	ajouteEvent(bouton2, 'click', retireDiscipline, false);
});
