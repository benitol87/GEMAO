<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.gemao.view.Pattern"%>

<c:set var="titre" value="Ajout d'un membre du personnel - Contrat" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
	
	<h1>Ajout d'un membre du personnel</h1>
	
	<!-- 2eme partie du formulaire -->
	<form id="ajoutp2" method="post" action="<c:url value="<%= Pattern.PERSONNEL_AJOUT2 %>" />">
		<fieldset>
			<div>
				<label>Nom : </label>
				<span><c:out value="${personnel['nom']}" /></span>
			</div>
			<div>
				<label>Prénom : </label>
				<span><c:out value="${personnel['prenom']}" /></span>
			</div>
			<div>
				<label for="type">Type de contrat : </label>
				<select name="type" id="type" >
					<option value="cdi">CDI</option>
					<option>CDD</option>
					<option>CTT</option>
					<option>Bénévole</option>
				</select>
			</div>
			<div>
				<label for="datedeb" class="required">Date de début : </label>
				<input type="text" name="datedeb" class="datepicker" required/>
			</div>
			<div style="display: none" id="duree" >
				<label for="duree">Durée : </label>
				<input type="number" name="duree" min="1" value="1" /> mois
			</div>
		</fieldset>
		<fieldset class='align-center no-border'>
			<a href="<c:url value="<%= Pattern.PERSONNEL_AJOUT %>" />"><input type="button" value="Retour" /></a>
			<input type="submit" value="Valider"/>
		</fieldset>
	</form>
<c:import url="/inc/footer.inc.jsp" />