<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Ajout d'un profil" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<h1>Ajout d'un profil</h1>

<form method="post" action="<c:url value="/profil/AjouterProfil" />">
	<fieldset>
		<legend>Informations</legend>
		
		<div>
			<label for="nom" class='required'>Nom </label>
			<input type="text" name="nom" required autocomplete="off"/>
		</div>
		
		<ul>
			<c:forEach items="${listeModules}" var="module">
				<li>
					<input type="checkbox" name="module<c:out value="${module.idModule}"/>"/>
					<label for="module<c:out value="${module.idModule}"/>"><c:out value="${module.nomModule}"/></label>
				</li>
			</c:forEach>
		</ul>
		
	</fieldset>
	
	<fieldset class='align-center no-border'>
		<a href="ListerProfils"><input type="button" value="Retour" /></a>
		<input type="submit" value="Valider"/>
	</fieldset>
</form>
	
<c:import url="/inc/footer.inc.jsp" />