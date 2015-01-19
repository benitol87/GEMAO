<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Modification d'un responsable" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
<h1>Modification d'un responsable</h1>
<form action="#" method="post">
	<fieldset>
		<div>
			<label for="nom">Nom : </label>
			<input type="text" name="nom" required="required"
					autocomplete="off" value="ancienne valeur" />
		</div>
		<div>
			<label for="prenom">Prénom : </label>
			<input type="text" name="prenom" required="required"
					autocomplete="off" value="ancienne valeur" />
		</div>
		<div>
			<label for="tel">Téléphone : </label>
			<input type="text" name="tel" pattern="[0][1-9][0-9]{8}"
					required="required" autocomplete="off" value="ancienne valeur" />
		</div>
		<div>
			<label for="email">E-mail : </label>
			<input type="text" name="email" required="required"
					autocomplete="off" value="ancienne valeur" />
		</div>
	</fieldset>
	<fieldset class='align-center no-border'>
		<div>
			<input type="button" value="Annuler" /> <input type="button"
				value="Suivant" /> <input type="button" value="Valider" />
		</div>
	</fieldset>
</form>
<c:import url="/inc/footer.inc.jsp" />