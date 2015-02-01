<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.gemao.view.Pattern"%>

<c:set var="titre" value="Modifier un profil" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<h1>Modification d'un profil</h1>

<form method="post" action="<c:url value="<%= Pattern.PROFIL_MODIFIER %>" />">
	<fieldset>
		<legend>Informations</legend>
		
		<div>
			<label for="nom" class='required'>Nom </label>
			<input type="text" name="nom" required autocomplete="off" value="<c:out value="${profil.nomProfil}"/>"/>
		</div>
		
		<ul>
			<c:forEach items="${requestScope.listeModules}" var="module">
				<li>
					<input type="checkbox" name="module<c:out value="${module.idModule}"/>" 
						<c:if test="${!empty requestScope.profil.listeModules[module.nomModule] }"> checked </c:if>
					/>
					<label for="module<c:out value="${module.idModule}"/>"><c:out value="${module.nomModule}"/></label>
				</li>
			</c:forEach>
		</ul>
		
	</fieldset>
	
	<fieldset class='align-center no-border'>
		<a href="<c:url value="<%= Pattern.PROFIL_LISTER %>" />"><input type="button" value="Retour" /></a>
		<input type="submit" value="Valider"/>
	</fieldset>
</form>
	
<c:import url="/inc/footer.inc.jsp" />