<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Liste des personnels" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
<h1>Liste du personnel</h1>
<table>
	<c:forEach items="${listePersonnels}" var="pers">
		<tr>
			<td><c:out value="${pers['nom']}" /></td>
			<td><c:out value="${pers['prenom']}" /></td>
			<td><a
				href="consulterPersonnel?id=<c:out value="${pers['idPersonne']}" />"><input
					type="button" value="Détails" /></a>
			<td>
		</tr>
	</c:forEach>
</table>
<c:import url="/inc/footer.inc.jsp" />