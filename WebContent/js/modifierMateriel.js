function ajoutDesignation(){
	var answer = prompt ("Ajouter une désignation");
	answer = answer.trim();
	if(answer && answer!=""){
		var input=document.getElementById("nomDes");
		input.value=answer;
		document.getElementById("modifierMateriel").submit();
	} else {
		alert("Abandon de l'ajout");
	}
}

function ajoutMarque(){
	var answer = prompt ("Ajouter une marque");
	answer = answer.trim();
	if(answer && answer!=""){
		var input=document.getElementById("nomMarque");
		input.value=answer;
		document.getElementById("modifierMateriel").submit();
	} else {
		alert("Abandon de l'ajout");
	}
}

function ajoutFournisseur(){
	var answer = prompt ("Ajouter un fournisseur");
	answer = answer.trim();
	if(answer && answer!=""){
		var input=document.getElementById("nomFour");
		input.value=answer;
		document.getElementById("modifierMateriel").submit();
	} else {
		alert("Abandon de l'ajout");
	}
}



function ajoutCategorie(){
	var answer = prompt ("Ajouter une catégorie");
	answer = answer.trim();
	if(answer && answer!=""){
		var input=document.getElementById("nomCat");
		input.value=answer;
		document.getElementById("modifierMateriel").submit();
	} else {
		alert("Abandon de l'ajout");
	}
}

function ajoutEtat(){
	var answer = prompt ("Ajouter un etat");
	answer = answer.trim();
	if(answer && answer!=""){
		var input=document.getElementById("nomEtat");
		input.value=answer;
		document.getElementById("modifierMateriel").submit();
	} else {
		alert("Abandon de l'ajout");
	}
}
