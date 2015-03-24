<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.gemao.view.Pattern"%>

<c:set var="titre" value="Liste des disciplines" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
<script src="<c:url value="/js/listerDisciplines.js"/>"></script>


<h1>Liste des disciplines</h1>
<h2 class="offset">Matière - Niveau</h2>

<c:forEach var="discipline" items="${sessionScope.listDiscipline }">
	<form action="#" method="post" class="offset">
		<input type="text" name="matiere" value="${discipline.getMatiere().getNomMatiere()}" readonly>
		<input type="text" name="niveau" value="${discipline.getNiveau().getNomNiveau()}" readonly>
		<input type="text" name="id" value="${discipline.getIdDiscipline()}" style="display: none">
		<a class="icon icon-pen" title='Modifier la discipline'></a>
		<input type="submit" class="btModif hidden" value="Modifier">
	</form>
</c:forEach>
<form action="#" method="post" class="offset">
	<input type="text" name="matiere" value="" >
	<input type="text" name="niveau" value="" >
	<input type="text" name="id" value="0" style="display: none">
	<input type="submit" value="Ajouter">
</form>

<c:import url="/inc/footer.inc.jsp" />