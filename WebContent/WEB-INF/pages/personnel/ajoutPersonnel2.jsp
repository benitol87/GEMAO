<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Personnel" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
<script src="<c:url value="/js/jquery.min.js"/>"></script>
<script src="<c:url value="/js/jquery-ui.min.js"/>"></script>
<script src="<c:url value="/js/datepicker.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/datepicker.css"/>" />
	<h1>Ajout d'un personnel</h1>
	<!-- 2eme partie du formulaire -->
	<form id="ajoutp2" method="post" action="<c:url value="/personnel/AjoutPersonnel2" />">
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
				<select name="type">
					<option>CDD</option>
					<option>CDI</option>
					<option>CTT</option>
					<option>Bénévole</option>
				</select>
			</div>
			<div>
				<label for="datedeb" class="required">Date de début : </label>
				<input type="text" name="datedeb" class="datepicker" required/>
			</div>
			<div>
				<label for="duree">Durée : </label>
				<input type="number" name="duree" min="1" value="1"/> mois
			</div>
		</fieldset>
		<fieldset class='align-center no-border'>
			<input type="submit" value="Valider"/>
		</fieldset>
	</form>
<c:import url="/inc/footer.inc.jsp" />