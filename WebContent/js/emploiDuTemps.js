$(function() {
	var dialog, form, idCliquer

	function remiseAZero() {
		$('#cours>option:eq(0)').attr('selected', true);
		$('#professeur>option:eq(0)').attr('selected', true);
		$('#salle>option:eq(0)').attr('selected', true);
		$('#duree>option:eq(0)').attr('selected', true);
		$('#duree').attr('disabled', false);
	}
	function ajoutTexte(cours, professeur, salle) {
		$("#" + idCliquer).text("");
		$("#" + idCliquer).append(
				cours.text() + "<br>" + professeur.text() + "<br>"
						+ salle.text());
		dialog.dialog("close");
	}

	function modifierCours() {
		var contenu = $("#" + idCliquer).html();
		var cours = contenu.split("<br>")[0];
		var professeur = contenu.split("<br>")[1];
		var salle = contenu.split("<br>")[2];

		var duree = $('#' + idCliquer).attr('colspan');
		duree = duree - 1;

		$('#cours>option[value="' + cours + '"]').attr('selected', true);
		$('#professeur>option[value="' + professeur + '"]').attr('selected',
				true);
		$('#salle>option[value="' + salle + '"]').attr('selected', true);
		$('#duree>option:eq(' + duree + ')').attr('selected', true);
		$('#duree').attr('disabled', 'disabled');

	}

	function addCours() {
		var valid = true;
		var cours = $("#cours option:selected"), professeur = $("#professeur option:selected"), salle = $("#salle option:selected"), duree = $("#duree option:selected");
		var ajoutable = true;

		if ($("#" + idCliquer).html() == "") {
			if (valid) {
				duree = duree.text();
				if (duree == "1:00") {
					if ($("#" + idCliquer).next().html() == ""
							&& $("#" + idCliquer).next().get(0).tagName != 'TH') {
						$("#" + idCliquer).attr("colspan", "2");
						$("#" + idCliquer).next().remove();
					} else {
						ajoutable = false;
					}
				}
				if (duree == "1:30") {
					if ($("#" + idCliquer).next().html() == ""
							&& $("#" + idCliquer).next().next().html() == ""
							&& $("#" + idCliquer).next().get(0).tagName != 'TH') {
						$("#" + idCliquer).attr("colspan", "3");
						$("#" + idCliquer).next().next().remove();
						$("#" + idCliquer).next().remove();
					} else {
						ajoutable = false;
					}
				}
				if (duree == "2:00") {
					if ($("#" + idCliquer).next().html() == ""
							&& $("#" + idCliquer).next().next().html() == ""
							&& $("#" + idCliquer).next().next().next().html() == ""
							&& $("#" + idCliquer).next().get(0).tagName != 'TH') {
						$("#" + idCliquer).attr("colspan", "4");
						$("#" + idCliquer).next().next().next().remove();
						$("#" + idCliquer).next().next().remove();
						$("#" + idCliquer).next().remove();
					} else {
						ajoutable = false;
					}
				}
				if (ajoutable) {
					ajoutTexte(cours, professeur, salle);
				} else {
					alert("Impossible d'ajouter le cours dans l'emploi du temps");
				}
			}
		} else {
			ajoutTexte(cours, professeur, salle);
		}
	}

	dialog = $("#dialog-form").dialog({
		autoOpen : false,
		height : 300,
		width : 350,
		modal : true,
		buttons : {
			"Ajouter" : addCours,
			Annuler : function() {
				dialog.dialog("close");
			}
		},
		close : function() {
			remiseAZero();
			// allFields.removeClass( "ui-state-error" );
		}
	});

	form = dialog.find("form").on("submit", function(event) {
		event.preventDefault();
		addCours();
	});

	$("td").each(function() {
		$(this).click(function() {
			idCliquer = this.id;
			if ($("#" + idCliquer).html() != "") {
				modifierCours();
				dialog.dialog("open");
			}
			if ($("#" + idCliquer).html() == "") {
				dialog.dialog("open");
			}
		});

	});

});