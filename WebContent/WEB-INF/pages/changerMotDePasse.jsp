<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Changement de mot de passe" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<h1>Changer son mot de passe</h1>

<form method="post" action="<c:url value="/profil/ModifierProfil" />">
	<fieldset>
		<legend>Informations</legend>
		
		<div>
			<label for="ancien" class='required'>Saisir l'ancien mot de passe </label>
			<input type="password" name="ancien" required autocomplete="off"/>
		</div>
		
		<div>
			<label for="nouveau1" class='required'>Saisir le nouveau mot de passe </label>
			<input type="password" name="nouveau1" required autocomplete="off"/>
		</div>
		
		<div>
			<label for="nouveau2" class='required'>Resaisir le nouveau mot de passe </label>
			<input type="password" name="nouveau2" required autocomplete="off"/>
		</div>		
	</fieldset>
	
	<fieldset class='align-center no-border'>
		<a href="ListerProfils"><input type="button" value="Retour" /></a>
		<input type="submit" value="Valider"/>
	</fieldset>
</form>
	
<c:import url="/inc/footer.inc.jsp" />