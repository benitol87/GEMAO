<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Accueil" scope="request" />

<c:import url="/inc/head.inc.jsp" />
<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<p>La page à laquelle vous tentez d'accéder n'existe pas.</p>
<a href="javascript:history.back()">Retour</a>
	

<c:import url="/inc/footer.inc.jsp" />