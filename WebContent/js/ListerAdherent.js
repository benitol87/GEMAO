$(function () {
	$(".listEmail").css('display','none');
	$(".listCom").css('display','none');
	$(".listNaiss").css('display','none');
	$(".listEntree").css('display','none');
	$(".listDroitIm").css('display','none');
	$(".listQF").css('display','none');
	$(".listCA").css('display','none');
	$(".listMotif").css('display','none');
	$(':checkbox:checked').removeAttr('checked');
});

function affEmail(){
	$(".listEmail").toggle();
}

function affCommune(){
	$(".listCom").toggle();
}

function affNaissance(){
	$(".listNaiss").toggle();
}

function affEntree(){
	$(".listEntree").toggle();
}

function affDroitImage(){
	$(".listDroitIm").toggle();
}

function affQF(){
	$(".listQF").toggle();
}

function affCA(){
	$(".listCA").toggle();
}

function affMotifSortie(){
	$(".listMotif").toggle();
}