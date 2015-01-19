<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Liste des materiel" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<h1>Liste des matériels</h1>

<table>
	<tr>
		<th>Désignation</th>
		<th>Catégorie</th>
		<th>Quantité</th>
		<th></th>
		<th></th>
	</tr>
	<c:forEach items="${listeMateriels}" var="mat">
		<tr>
			<td><c:out value="${mat.designation.libelleDesignation}" /></td>
			<td><c:out value="${mat.categorie.libelleCat}" /></td>
			<td><c:out value="${mat.quantite}" /></td>

			<c:choose>
				<c:when test="${!empty page}">
					<td><a
						href="ModifierMateriel?idMateriel=<c:out value="${mat.idMateriel}" />"><input
							type="button" value="Modifier" /></a>
					<td>
				</c:when>
				<c:otherwise>
					<td><a
						href="ConsulterMateriel?idMateriel=<c:out value="${mat.idMateriel}" />"><input
							type="button" value="Consulter" /></a>
					<td>
				</c:otherwise>
			</c:choose>
		</tr>
	</c:forEach>
</table>

<c:import url="/inc/footer.inc.jsp" />