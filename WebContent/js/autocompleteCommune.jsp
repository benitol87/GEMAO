<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
$(function() {
	var availableTags = ${requestScope.listNomCommune};
	$("#commune").autocomplete({
		source : availableTags,
		change: function(event, ui){
			remplirCodePostal("#commune", ui.item.value);
		},
		select: function(event, ui){
			remplirCodePostal("#commune", ui.item.value);
		}
	});
	
	
	$("#commune").on("change", {selecteurCommune: "#commune"}, remplirCodePostalHandler);
	$("#commune").on("input", {selecteurCommune: "#commune"}, remplirCodePostalHandler);
});


function remplirCodePostal(selecteurCommune, value){
	var dicoCommune = ${requestScope.dicoCommune};
	for(c in dicoCommune){
		if(c == value){
			$("#codePostal").val(dicoCommune[c]);
			console.log(dicoCommune[c])
		}
	}
}

function remplirCodePostalHandler(event){
	var dicoCommune = ${requestScope.dicoCommune};
	for(c in dicoCommune){
		if(c == $(event.data.selecteurCommune).val()){
			$("#codePostal").val(dicoCommune[c]);
			console.log(dicoCommune[c])
		}
	}
}
</script>