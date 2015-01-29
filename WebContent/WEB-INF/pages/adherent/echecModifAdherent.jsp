<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Modification d'un adhérent" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<script src="<c:url value="/js/jquery.min.js"/>"></script>
<script src="<c:url value="/js/modifierAdherent.js"/>"></script>
<h1>Confirmation</h1>
<p>L'adhérent ... n'a pas été modifié</p>

<c:import url="/inc/footer.inc.jsp" />
