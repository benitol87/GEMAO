<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.gemao.view.Pattern"%>

<c:set var="titre" value="GEMAO - Liste des modifications" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
<h1>Liste des modifications</h1>
<table>
	<tr>
		<th>Date</th>
		<th>Responsable</th>
		<th>Action</th>
	</tr>
	<c:forEach items="${requestScope.listeModifs}" var="modif">
		<tr>
			<td><c:out value="${modif.dateModif}" /></td>
			<td><c:out value="${modif.personne.login}" /></td>
			<td><c:out value="${modif.libelle}" /></td>
		</tr>
	</c:forEach>
</table>
<c:import url="/inc/footer.inc.jsp" />