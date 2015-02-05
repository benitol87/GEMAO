var cpt = 1;

function ajoutMotif()
{
	var rep = prompt("Ajouter un motif de sortie");
	rep = rep.trim();
	if(rep && rep != "")
	{
		var input = document.getElementById("libelleMotif");
		input.value = rep;
		document.getElementsById("desinscrire").submit();
	} 
	else 
	{
		alert("Abandon de l'ajout");
	}
}

function confirmDesinscription()
{
	var res = window.confirm("Souhaitez-vous réellement désinscrire cet adhérent ?");
	
	return res;
}

window.onload = function()
{
	var boutonAjouter = document.getElementById("ajoutMotif");
	var boutonValider = document.getElementById("valider");
	var champ_date = document.getElementById("dateSortie");
	champ_date.value = getDateActuelle();
	
	ajouteEvent(boutonValider, 'submit', confirmDesinscription, false);
	ajouteEvent(boutonAjouter, 'click', ajoutMotif, false);
}