function ajoutDesignation(){
	var answer = prompt ("Ajoutez une désignation.");
	if(answer!=""){
		var input=document.getElementById("nomDes");
		input.value=answer;
		document.getElementById("ajouterMateriel").submit();
	}
}

function ajoutMarque(){
	var answer = prompt ("Ajoutez une marque.");
	if(answer!=""){
		var input=document.getElementById("nomMarque");
		input.value=answer;
		document.getElementById("ajouterMateriel").submit();
	}
}

function ajoutFournisseur(){
	var answer = prompt ("Ajouter un fournisseur.");
	if(answer!=""){
		var input=document.getElementById("nomFour");
		input.value=answer;
		document.getElementById("ajouterMateriel").submit();
	}
}

function ajoutCategorie(){
	var answer = prompt ("Ajouter une catégorie");
	if(answer!=""){
		var input=document.getElementById("nomCat");
		input.value=answer;
		document.getElementById("ajouterMateriel").submit();
	}
}
 

function dispatchEvents(){
	var des = document.getElementById("ajoutDes");
	var marque = document.getElementById("ajoutMarque");
	var four = document.getElementById("ajoutFour");
	var cat = document.getElementById("ajoutCat");
	if(des)
		ajouteEvent(des,"click",ajoutDesignation,false);
	if(marque)
		ajouteEvent(marque,"click",ajoutMarque,false);
	if(four)
		ajouteEvent(four,"click",ajoutFournisseur,false);
	if(cat)
		ajouteEvent(cat,"click",ajoutCategorie,false);
}

window.onload=function(){
	dispatchEvents();
};