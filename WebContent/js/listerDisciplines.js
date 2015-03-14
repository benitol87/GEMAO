$(function(){
	$(".icon-pen").on("click",modifDiscipline);
});

function modifDiscipline(e){
	var div = e.target.parentNode;
	$(div.getElementsByTagName('input')).attr("readonly",false);

}