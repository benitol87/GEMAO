<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Changement de mot de passe" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<h1>Changer son mot de passe</h1>

<p class='offset'><c:out value="${requestScope.resultat }"></c:out> </p>

<c:if test="${!empty requestScope.lien }">
	<a href='<c:out value="${requestScope.lien }"/>'><input type='button' value='Retour'/></a>
</c:if>
	
<c:import url="/inc/footer.inc.jsp" />