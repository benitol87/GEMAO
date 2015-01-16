function ajouteEvent(objet, typeEvent, nomFunction, typePropagation){
	
	if(objet.addEventListener){
		objet.addEventListener(typeEvent,nomFunction,typePropagation);
	} else if(objet.attachEvent){
		objet.attachEvent('on'+typeEvent,nomFunction);
	}
}