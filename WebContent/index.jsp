<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="GEMAO - Accueil" scope="request" />

<c:import url="/inc/head.inc.jsp" />
<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<h1>Accueil</h1>
<div id="logo" class='offset'>
	<img alt="Logo Anacrouse" src="<c:url value="/ressources/images/Anacrouse.png"/>" width="50%" height="20%" align="middle"/>
</div>

<c:import url="/inc/footer.inc.jsp" />
