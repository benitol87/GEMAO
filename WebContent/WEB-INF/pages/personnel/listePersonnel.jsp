<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Liste des personnels" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
<h1>Liste du personnel</h1>
<table>
	<tr>
		<th>Nom</th>
		<th>Prénom</th>
		<th>Actions</th>
	</tr>
	<c:forEach items="${listePersonnels}" var="pers">
		<tr>
			<td><c:out value="${pers['nom']}" /></td>
			<td><c:out value="${pers['prenom']}" /></td>
			<td>
				<a class="icon icon-search" href="ConsulterPersonnel?id=<c:out value="${pers['idPersonne']}" />" title='Afficher les détails'></a>
				<a class="icon icon-pen" href="ModifPersonnel?id=<c:out value="${pers['idPersonne']}" />" title='Modifier les informations'></a>
			</td>
		</tr>
	</c:forEach>
</table>
<c:import url="/inc/footer.inc.jsp" />