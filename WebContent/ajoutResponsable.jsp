<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Ajout d'un adhérent" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
<h1>Ajout d'un responsable</h1>
<form action="#" method="post">
	<table>
		<tr>
			<td><label for="nom">Nom : </label></td>
			<td><input type="text" name="nom" required="required"
				autocomplete="off" /></td>
			<td><label for="prenom">Prénom : </label></td>
			<td><input type="text" name="prenom" required="required"
				autocomplete="off" /></td>
		</tr>
		<tr>
			<td><label for="tel">Téléphone : </label></td>
			<td><input type="text" name="tel" pattern="[0][1-9][0-9]{8}"
				required="required" autocomplete="off" /></td>
			<td><label for="email">E-mail : </label></td>
			<td><input type="text" name="email" required="required"
				autocomplete="off" /></td>
		</tr>
	</table>
	<div>
		<input type="button" value="Annuler" /> <input type="button"
			value="Suivant" /> <input type="button" value="Valider" />
	</div>
</form>
<c:import url="/inc/footer.inc.jsp" />