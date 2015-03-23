<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.gemao.view.Pattern"%>

<c:set var="titre" value="Accueil" scope="request" />

<c:import url="/inc/head.inc.jsp" />
<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<p class="offset">La page à laquelle vous tentez d'accéder n'existe pas.</p>
<a class="offset btn" href="<c:url value="<%= Pattern.ACCUEIL %>"/>" >Accueil</a>
	

<c:import url="/inc/footer.inc.jsp" />