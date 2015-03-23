<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.gemao.view.Pattern"%>

<c:set var="titre" value="Liste des designations" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
<script src="<c:url value="/js/listerDesignation.js"/>"></script>


<h1>Liste des désignations</h1>
<h2 class="offset">Designation</h2>
<table>
	<c:forEach var="des" items="${listDes}">
		<tr>
			<form action="#" method="post" class="offset">
				<td><label for="des">${des.libelleDesignation}</label></td>
				<input type="text" name="id" value="${des.idDesignation}" style="display: none">
				<td><input type="submit" class="btSuppr" value="Supprimer"></td>
			</form>
		</tr>	
	</c:forEach>
	<form action="#" method="post" class="offset">
		<tr>
			<td><input type="text" name="libelle" value="" ></td>
			<input type="text" name="id" value="0" style="display: none">
			<td><input type="submit" value="Ajouter"></td>
		</tr>
	</form>
</table>

<c:import url="/inc/footer.inc.jsp" />