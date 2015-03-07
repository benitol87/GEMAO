<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.gemao.view.Pattern"%>

<c:set var="titre" value="Liste des personnels" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
<h1>Liste du personnel</h1>
<table class='tablesorter-blue'>
<thead>
	<tr>
		<th>Nom</th>
		<th>Prénom</th>
		<th>Actions</th>
	</tr>
</thead>
<tbody>
	<c:forEach items="${listePersonnels}" var="pers">
		<tr>
			<td><c:out value="${pers['nom']}" /></td>
			<td><c:out value="${pers['prenom']}" /></td>
			<td>
				<a class="icon icon-search" href="<c:url value="<%= Pattern.PERSONNEL_CONSULTER %>" />?id=<c:out value="${pers['idPersonne']}" />" title='Afficher les détails'></a>
				<a class="icon icon-pen" href="<c:url value="<%= Pattern.PERSONNEL_MODIFIER %>" />?id=<c:out value="${pers['idPersonne']}" />" title='Modifier les informations'></a>
			</td>
		</tr>
	</c:forEach>
</tbody>
</table>
<c:import url="/inc/footer.inc.jsp" />