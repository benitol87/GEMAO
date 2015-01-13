function afficherType()
{

	if(document.getElementById("categorie").options[document.getElementById("categorie").options.selectedIndex].text=="Instrument")
	{

		document.getElementById("ajouterMaterielInstrument").style.display="inline";
		document.getElementById("ajouterMaterielMobilier").style.display="none";
	}
	else
	{
		document.getElementById("ajouterMaterielInstrument").style.display="none";
		document.getElementById("ajouterMaterielMobilier").style.display="inline";
	}
}

function ajouteEvent(objet,typeEvent,nomFonction,typePropagation){
	if(objet.addEventListener){
		objet.addEventListener(typeEvent,nomFonction,typePropagation);
	}else if(objet.attachEvent){
		objet.attachEvent("on"+typeEvent,nomFonction);
	}
}

function dispatchEvents(){
	var catego = document.getElementById("categorie");
	if(catego)
		ajouteEvent(catego,"click",afficherType,false);
}

window.onload=function(){
	dispatchEvents();
};