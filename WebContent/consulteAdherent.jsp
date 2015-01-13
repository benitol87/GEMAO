<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Consultation d'un adhérent" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<h1>Consultation d'un adhérent</h1>
<table>
	<tr>
		<td><label for="nom">Nom : </label></td>
		<td><p>NOM ICI</p></td>
		<td><label for="prenom">Prénom : </label></td>
		<td><p>PRENOM ICI</p></td>
		<td><label for="dateNaiss">Date de naissance : </label></td>
		<td><p>DATE DE NAISSANCE ICI</p></td>
	</tr>
	<tr>
		<td><label for="telFixe">Téléphone fixe : </label></td>
		<td><p>Tel Fixe ICI</p></td>
		<td><label for="telPort">Téléphone portable : </label></td>
		<td><p>TEL PORT ICI</p></td>
		<td><label for="email">E-mail : </label></td>
		<td><p>MAIL ICI</p></td>
	</tr>
</table>
<br />

<fieldset>
	<legend>Adresse</legend>
	<table>
		<tr>
			<td><label for="num">Numéro : </label></td>
			<td><p>NUMERO ICI</p></td>
		</tr>
		<tr>
			<td><label for="rue">Rue : </label></td>
			<td><p>RUE ICI</p></td>
		</tr>
		<tr>
			<td><label for="compl">Complémentaire : </label></td>
			<td><p>COMPLEMENT ICI (SI EXISTE)</p></td>
		</tr>
		<tr>
			<td><label for="codeP">Code Postal : </label></td>
			<td><p>CODE POSTAL ICI</p></td>
		</tr>
		<tr>
			<td><label for="commune">Commune : </label></td>
			<td><p>COMMUNE ICI</p></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend>Discipline</legend>
	<table>
		<tbody id="disciplines">
			<tr>
				<td><p>Discipline</p></td>
				<td><p>Classe</p></td>
			</tr>
			<tr id="1">
				<td><p>DISCIPLINE 1 ICI</p></td>
				<td><p>CLASSE 1 ICI</p></td>
			</tr>
			<tr id="2">
				<td><p>DISCIPLINE 2 ICI</p></td>
				<td><p>CLASSE 2 ICI</p></td>
			</tr>
		</tbody>
	</table>
</fieldset>
<div>
	<span>Droit à l'image : OUI (OU NON)</span>
</div>
<p>SI IL Y A UN RESPONSABLE</p>
<table>
	<tr>
		<td><label for="nom">Nom : </label></td>
		<td><p>NOM RESPONSABLE ICI</p></td>
		<td><label for="prenom">Prénom : </label></td>
		<td><p>PRENOM RESPONSABLE ICI</p></td>
	</tr>
	<tr>
		<td><label for="telFixe">Téléphone fixe : </label></td>
		<td><p>TEL FIXE RESPONSABLE ICI</p></td>
		<td><label for="telPort">Téléphone portable : </label></td>
		<td><p>TEL PORT RESPONSABLE ICI</p></td>
		<td><label for="email">E-mail : </label></td>
		<td><p>MAIL RESPONSABLE ICI</p></td>
	</tr>
</table>
<div>
	<a href="listeAdherents.jsp"><input type="button" value="Retour" /></a> <input type="button"
		value="Modifier" />
</div>

<c:import url="/inc/footer.inc.jsp" />