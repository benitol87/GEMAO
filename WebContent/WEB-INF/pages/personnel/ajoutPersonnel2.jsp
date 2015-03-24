<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.gemao.view.Pattern"%>

<c:set var="titre" value="Ajout d'un membre du personnel - Contrat"
	scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<script src="<c:url value="/js/AjouterPersonnel.js"/>"></script>

<h1>Ajout d'un membre du personnel</h1>

<!-- 2eme partie du formulaire -->
<form id="ajoutp2" method="post"
	action="<c:url value="<%=Pattern.PERSONNEL_AJOUT2%>" />">
	<fieldset>
		<div>
			<label>Nom : </label> <span><c:out value="${personnel['nom']}" /></span>
		</div>
		<div>
			<label>Prénom : </label> <span><c:out
					value="${personnel['prenom']}" /></span>
		</div>
		<div>
			<label for="type">Type de contrat </label> <select name="type"
				id="type" onClick="afficherDuree()">
				<option value="1">CDI</option>
				<option value="2">CDD</option>
				<option value="4">CTT</option>
				<option value="3">Bénévole</option>
			</select>
		</div>
		<div>
			<label for="datedeb" class="required">Date de début du contrat </label> <input
				type="text" name="datedeb" class="datepicker" required />
		</div>
		<div>
			<label for="datedebEns" class="required">Date de début d'enseignement </label> <input
				type="text" name="datedebEns" class="datepicker" required />
		</div>
		<div id="duree" hidden=hidden>
			<label for="duree">Durée </label> <input type="number" name="duree"
				min="1" value="1" /> mois
		</div>
	</fieldset>
	<fieldset class='align-center no-border'>
		<p class="oblig">* Champs obligatoires</p>
		<a href="<c:url value="<%=Pattern.PERSONNEL_AJOUT%>" />"><input
			type="button" value="Retour" /></a> <input type="submit" value="Valider" />
	</fieldset>
</form>
<c:import url="/inc/footer.inc.jsp" />