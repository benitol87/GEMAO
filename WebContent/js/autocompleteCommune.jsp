<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
$(function() {
	var availableTags = ${requestScope.listNomCommune};
	$("#commune").autocomplete({
		source : availableTags
	});
	
	var dicoCommune = ${requestScope.dicoCommune};
	$("#commune").on("change", function(){
		for(c in dicoCommune){
			if(c == this.value){
				$("#codePostal").val(dicoCommune[c]);
				console.log(dicoCommune[c])
			}
			console.log(c);
		}
	});
});
</script>