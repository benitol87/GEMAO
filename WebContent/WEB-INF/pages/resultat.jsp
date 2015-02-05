<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Changement de mot de passe" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<h1>Changer son mot de passe</h1>

<p class='offset text-success'><c:out value="${requestScope.resultat }"></c:out> </p>

<div class="align-center">
	<a href='<c:url value="${requestScope.lienBouton }"/>'><input type='button' value='<c:out value="${requestScope.nomBouton }"/>'/></a>
</div>
	
<c:import url="/inc/footer.inc.jsp" />