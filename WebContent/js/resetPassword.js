function envoyerForm(){
	var elem = document.getElementById("id");
	if(elem)
		elem.value = '';
	document.getElementById("form").submit();
}

function recupMdp(){
	var answer = prompt ("Saisissez votre mot de passe");
	answer = answer.trim();
	if(answer && answer!=""){
		var input=document.getElementById("password");
		input.value=answer;
		return true;
	} else {
		return false;
	}
}

function dispatchEvents(){
	var elem = document.getElementById("idPersonne");
	if(elem)
		ajouteEvent(elem,"change",envoyerForm,false);
	elem = document.getElementById("Valider");

	if(elem){
		ajouteEvent(elem,"click",recupMdp,false);
	}
}

window.onload=function(){
	dispatchEvents();
};