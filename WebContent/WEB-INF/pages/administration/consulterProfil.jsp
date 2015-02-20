<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.gemao.view.Pattern"%>

<c:set var="titre" value="Consultation d'un membre du personnel"
	scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
<h1>Consultation d'un profil : <c:out value="${profil.nomProfil}" ></c:out></h1>
<div class='offset'>
	<c:forEach items="${requestScope.listeModules}" var="module">
		<div>
			<span>Module <c:out value="${module.nomModule}" /></span> : 
			<c:out value="${profil.recupererTypeDroit(module.nomModule)}"/>
		</div>
	</c:forEach>
</div>
<p class='align-center no-border'>
	<a href="<c:url value="<%= Pattern.ADMINISTRATION_LISTER_PROFIL %>" />"><input type="button" value="Retour" /></a>
	<a href="<c:url value="<%= Pattern.ADMINISTRATION_MODIFIER_PROFIL %>" />?id=<c:out value="${requestScope.profil.idProfil}"/>"><input type="button" value="Modifier" /></a>
</p>
<c:import url="/inc/footer.inc.jsp" />