$(function () {
	$(".listEmail").css('display','none');
	$(".listCom").css('display','none');
	$(".listNaiss").css('display','none');
	$(".listEntree").css('display','none');
	$(".listDroitIm").css('display','none');
	$(':checkbox:checked').removeAttr('checked');
});

function affEmail(){
	if($('.listEmail').css('display') == 'none'){
		$(".listEmail").css('display','table-cell');
	} else {
		$(".listEmail").css('display','none');
	}
}

function affCommune(){
	if($('.listCom').css('display') == 'none'){
		$(".listCom").css('display','table-cell');
	} else {
		$(".listCom").css('display','none');
	}
}

function affNaissance(){
	if($('.listNaiss').css('display') == 'none'){
		$(".listNaiss").css('display','table-cell');
	} else {
		$(".listNaiss").css('display','none');
	}
}

function affEntree(){
	if($('.listEntree').css('display') == 'none'){
		$(".listEntree").css('display','table-cell');
	} else {
		$(".listEntree").css('display','none');
	}
}

function affDroitImage(){
	if($('.listDroitIm').css('display') == 'none'){
		$(".listDroitIm").css('display','table-cell');
	} else {
		$(".listDroitIm").css('display','none');
	}
}