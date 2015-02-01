<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.gemao.view.Pattern"%>

<c:set var="titre" value="Ajout d'un membre du personnel - Résultat" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<h1>Ajout d'un membre du personnel</h1>

<p class='offset'>La personne suivante a été ajoutée avec succès à la liste du personnel.</p>

<table>
	<tr>
		<td>Nom</td>
		<td><c:out value="${personnel['nom']}" /></td>
	</tr>
	<tr>
		<td>Prénom</td>
		<td><c:out value="${personnel['prenom']}" /></td>
	</tr>
	<tr>
		<td>Login</td>
		<td><c:out value="${personnel['login']}" /></td>
	</tr>
	<tr>
		<td>Mot de passe</td>
		<td><c:out value="${personnel['password']}" /></td>
	</tr>
</table>

<c:import url="/inc/footer.inc.jsp" />