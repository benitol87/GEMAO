<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.gemao.view.Pattern"%>

<c:set var="titre" value="Liste des disciplines" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
<script src="<c:url value="/js/listerDisciplines.js"/>"></script>


<h1>Liste des disciplines</h1>

<c:forEach var="discipline" items="${sessionScope.listDiscipline }">
	<div class="offset">
		<input type="text" value="${discipline.getMatiere().getNomMatiere()}" readonly>
		<input type="text" value="${discipline.getNiveau().getNomNiveau()}" readonly>
		<a class="icon icon-pen" title='Modifier la discipline'></a>
	</div>
</c:forEach>

<c:import url="/inc/footer.inc.jsp" />