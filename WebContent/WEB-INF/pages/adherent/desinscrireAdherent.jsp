<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.gemao.view.Pattern"%>

<c:set var="titre" value="Désinscription d'un adhérent" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<script src="<c:url value="/js/desinscrireAdherent.js"/>"></script>

<h1>Désinscription d'un adhérent</h1>

<form action="#" method="post">
	<fieldset>
	</fieldset>
</form>

<c:import url="/inc/footer.inc.jsp" />