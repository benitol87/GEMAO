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
			<td><label for="nbPers">Nombre de personne : </label></td>
			<td><input type="number" name="nbPers" required="required"
				autocomplete="off" /></td>
			<td><label for="nbEnf">Nombre d'enfant : </label></td>
			<td><input type="number" name="nbEnf" required="required"
				autocomplete="off" /></td>
			<td><label for="revenues">Revenus annuels : </label></td>
			<td><input type="number" namme="revenues" required="required"
				autocomplete="off" /></td>
		</tr>
	</table>
	<div>
		<input type="button" value="Annuler" /> <input type="button"
			value="Valider" />
	</div>
</form>
<c:import url="/inc/footer.inc.jsp" />