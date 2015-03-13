function ajouteEvent(objet, typeEvent, nomFunction, typePropagation){
	
	if(objet.addEventListener){
		objet.addEventListener(typeEvent,nomFunction,typePropagation);
	} else if(objet.attachEvent){
		objet.attachEvent('on'+typeEvent,nomFunction);
	}
}

function getDateActuelle()
{
	var date = new Date;
	var jour = date.getDate();
	var mois = date.getMonth()+1;
	var annee = date.getFullYear();
	var dateActuelle = "0"+jour+"/"+"0"+mois+"/"+annee;
	
	return dateActuelle;
}