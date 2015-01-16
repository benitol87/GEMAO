function ajoutEtat(){
	var answer = prompt ("Ajouter un etat.");
	if(answer!=""){
		var input=document.getElementById("nomEtat");
		input.value=answer;
		document.getElementById("ajouterMateriel").submit();
	}
}

function dispatchEvents(){
	var etat = document.getElementById("ajoutEtat");
	if(etat)
		ajouteEvent(etat,"click",ajoutEtat,false);
}

window.onload=function(){
	dispatchEvents();
};