<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="GEMAO - Liste des profils" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
<h1>Liste des profils</h1>
<table>
	<tr>
		<th>Nom</th>
		<th>Actions</th>
	</tr>
	<c:forEach items="${listeProfils}" var="profil">
		<tr>
			<td><c:out value="${profil.nomProfil}" /></td>
			<td>
				<a class="icon icon-search" href="?ConsulterProfil?id=<c:out value="${profil.idProfil}" />" title='Afficher les détails'></a>
				<a class="icon icon-pen" href="ModifierProfil?id=<c:out value="${profil.idProfil}" />" title='Modifier les informations'></a>
			</td>
		</tr>
	</c:forEach>
</table>
<c:import url="/inc/footer.inc.jsp" />