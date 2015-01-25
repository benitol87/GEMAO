<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Changement de mot de passe" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<h1>Changer son mot de passe</h1>

<form method="post" action="<c:url value="/ChangerMotDePasse" />">
	<fieldset>
		<legend>Informations</legend>
		
		<div>
			<label for="ancien" class='required'>Saisir l'ancien mot de passe </label>
			<input type="password" name="ancien" required/>
		</div>
		
		<div class='align-center text-danger'><c:out value="${requestScope.form.erreurs['ancien'] }"></c:out> </div>
		
		<div>
			<label for="nouveau1" class='required'>Saisir le nouveau mot de passe </label>
			<input type="password" name="nouveau1" required/>
		</div>
		
		<div>
			<label for="nouveau2" class='required'>Resaisir le nouveau mot de passe </label>
			<input type="password" name="nouveau2" required/>
		</div>		
		
		<div class='align-center text-danger'><c:out value="${requestScope.form.erreurs['nouveau'] }"></c:out> </div>
	</fieldset>
	
	<fieldset class='align-center no-border'>
		<input type="submit" value="Valider"/>
	</fieldset>
</form>
	
<c:import url="/inc/footer.inc.jsp" />