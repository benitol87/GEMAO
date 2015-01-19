<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Liste des adhérents" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<h1>Liste des adhérents</h1>

<table>
	<tr>
		<th>Nom</th>
		<th>Prénom</th>
		<th>Actions</th>
	</tr>
	<c:forEach items="${listeAdherents}" var="adh">
		<tr>
			<td><c:out value="${adh['nom']}" /></td>
			<td><c:out value="${adh['prenom']}" /></td>
			<td>
				<a class="icon icon-search" href="ConsulteAdherent?id=<c:out value="${adh['idPersonne']}" />" title='Afficher les détails'></a>
				<a class="icon icon-pen" href="ModifierAdherent?id=<c:out value="${adh['idPersonne']}" />" title='Modifier les informations'></a>
			</td>
		</tr>
	</c:forEach>
</table>

<c:import url="/inc/footer.inc.jsp" />