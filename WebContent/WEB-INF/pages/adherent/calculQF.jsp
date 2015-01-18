<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Calcul du Quotient Familial" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
<h1>Calcul du quotient familial</h1>
<form action="#" method="post">
	<fieldset>
		<div>
			<label for="nbPers">* Nombre de personne(s) </label>
			<input type="number" name="nbPers" required="required" min="1" value="1" autocomplete="off" />
		</div>
		<div>
			<label for="nbEnf">* dont nombre d'enfant(s) </label>
			<input type="number" name="nbEnf" required="required" min="0" value="0" autocomplete="off" />
		</div>
		<div>
			<label for="revenues">* Revenus annuels </label>
			<input type="text" pattern="[0-9]*[0-9,.][0-9]*" name="revenues" required="required" autocomplete="off" />
		</div>
	</fieldset>
	<fieldset class='align-center no-border'>
		<input type="button" value="Annuler" /> 
		<input type="submit" value="Valider" />
	</fieldset>
</form>
<c:import url="/inc/footer.inc.jsp" />