<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Changement de mot de passe" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<h1>Configuration</h1>

<ul class="offset">
	<li><a href='<c:url value='/ChangerMotDePasse'/>'>Changer son mot de passe</a></li>
</ul>
	
<c:import url="/inc/footer.inc.jsp" />