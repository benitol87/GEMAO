<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Calcul du Quotient Familial" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
<h1>Calcul du Quotient Familial</h1>
<form action="#" method="post">
	<table>
		<tr>
			<td><label for="nbPers">Nombre de personne(s) : </label></td>
			<td><input type="number" name="nbPers" required="required" min="0"
				autocomplete="off" /></td>
			<td><label for="nbEnf">Nombre d'enfant(s) : </label></td>
			<td><input type="number" name="nbEnf" required="required" min="0"
				autocomplete="off" /></td>
			<td><label for="revenues">Revenus annuels : </label></td>
			<td><input type="text" pattern="[0-9]*[0-9,.][0-9]*" name="revenues" required="required"
				autocomplete="off" /></td>
		</tr>
	</table>
	<div>
		<input type="button" value="Annuler" /> 
		<input type="submit" value="Valider" />
	</div>
</form>
<c:import url="/inc/footer.inc.jsp" />