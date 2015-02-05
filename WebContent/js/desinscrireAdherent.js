var cpt = 1;

function ajoutMotif()
{
	alert('ok');
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

window.unload = function()
{
	var boutonAjouter = document.getElementById("ajoutMotif");
	var boutonValider = document.getElementById("valider");
	
	ajouteEvent(boutonValider, 'submit', confirmDesinscription, false);
	ajouteEvent(boutonAjouter, 'click', ajoutMotif, false);
}