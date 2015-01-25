function envoyerForm(){
	var elem = document.getElementById("id");
	if(elem)
		elem.value = '';
	document.getElementById("form").submit();
}

function dispatchEvents(){
	var elem = document.getElementById("idPersonne");
	if(elem)
		ajouteEvent(elem,"change",envoyerForm,false);
}

window.onload=function(){
	dispatchEvents();
};