<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.gemao.view.Pattern"%>

<c:set var="titre" value="Consultation d'un membre du personnel"
	scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
<h1>Consultation d'un profil</h1>
<table>
	<caption>Informations du profil : <c:out value="${profil.nomProfil}" ></c:out></caption>
	<tr>
		<th>
			<span>Modules accessibles</span>
		</th>
	</tr>

	<c:forEach items="${requestScope.listeModules}" var="module">
		<tr>
			<td><c:out value="${module.nomModule}" /></td>
		</tr>
	</c:forEach>	
</table>
<p class='align-center no-border'>
	<a href="<c:url value="<%= Pattern.PROFIL_LISTER %>" />"><input type="button" value="Retour" /></a>
	<a href="<c:url value="<%= Pattern.PROFIL_MODIFIER %>" />?id=<c:out value="${requestScope.id}"/>"><input type="button" value="Modifier" /></a>
</p>
<c:import url="/inc/footer.inc.jsp" />