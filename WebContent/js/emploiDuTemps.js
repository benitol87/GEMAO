$(function() {
    var dialog, form, idCliquer

    function addCours() {
    	var valid = true;
    	var cours = $( "#cours option:selected" ),
    	professeur = $("#professeur option:selected"),
    	salle = $("#salle option:selected"),
    	duree = $("#duree option:selected");

    	if($("#"+idCliquer).text() == ""){

	    	if ( valid ) {
	    		duree = duree.text();
	    		if(duree == "1:00"){
	    			$("#"+idCliquer).attr("colspan", "2");
	    			$("#"+idCliquer).next().remove();
	    		}
	    		if(duree == "1:30"){
	    			$("#"+idCliquer).attr("colspan", "3");
	    			$("#"+idCliquer).next().next().remove();
	    			$("#"+idCliquer).next().remove();
	    		}
	    		if(duree == "2:00"){
	    			$("#"+idCliquer).attr("colspan", "4");
	    			$("#"+idCliquer).next().next().next().remove();
	    			$("#"+idCliquer).next().next().remove();
	    			$("#"+idCliquer).next().remove();
	    		}
	    		$("#"+idCliquer).append(cours.text()+"<br>"+professeur.text()+"<br>"+salle.text());
	       		dialog.dialog( "close" );
	     	}
	     	return valid;
	     }
	     else{
		$("#"+idCliquer).text("");
	     	$("#"+idCliquer).append(cours.text()+"<br>"+professeur.text()+"<br>"+salle.text());
	       	dialog.dialog( "close" );
	     }
    }

   	dialog = $( "#dialog-form" ).dialog({
      autoOpen: false,
      height: 300,
      width: 350,
      modal: true,
      buttons: {
        "Ajouter": addCours,
        Annuler: function() {
          dialog.dialog( "close" );
        }
      },
      close: function() {
        form[ 0 ].reset();
        //allFields.removeClass( "ui-state-error" );
      }
    });
 
    form = dialog.find( "form" ).on( "submit", function( event ) {
      event.preventDefault();
      addCours();
    });
 
 	$("td").each(function() {
  		$(this).click(function() {
  			idCliquer = this.id;
      		dialog.dialog( "open" );
    	});

	});
    
});