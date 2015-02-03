<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.gemao.view.Pattern"%>

<c:set var="titre" value="Liste des materiel" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<h1>Liste des matériels</h1>
<p>${form.erreurs['Modification']}</p>
<table>
	<tr>
		<th>Désignation</th>
		<th>Catégorie</th>
		<th>Quantité</th>
		<th>Actions</th>
	</tr>
	<c:forEach items="${listeMateriels}" var="mat">
		<tr>
			<td><c:out value="${mat.designation.libelleDesignation}" /></td>
			<td><c:out value="${mat.categorie.libelleCat}" /></td>
			<td><c:out value="${mat.quantite}" /></td>
			<td>
				<a class="icon icon-search" href="<c:url value="<%= Pattern.MATERIEL_CONSULTER %>" />?idMateriel=<c:out value="${mat.idMateriel}" />" title='Afficher les détails'></a>
				<a class="icon icon-pen" href="<c:url value="<%= Pattern.MATERIEL_MODIFIER %>" />?idMateriel=<c:out value="${mat.idMateriel}" />" title='Modifier les informations'></a>
			</td>
		</tr>
	</c:forEach>
</table>

<c:import url="/inc/footer.inc.jsp" />