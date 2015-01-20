<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Ajout d'un membre du personnel - Informations personnelles" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
<script src="<c:url value="/js/jquery.min.js"/>"></script>
<script
	src="<c:url value="/js/jquery-ui.min.js"/>"></script>
<script src="<c:url value="/js/datepicker.js"/>"></script>
<script src="<c:url value="/js/AjouterPersonnel.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/datepicker.css"/>" />
	<!-- 1er partie du formulaire -->
<h1>Ajout d'un membre du personnel</h1>
<form id="ajoutp1" method="post" action="<c:url value="/personnel/AjoutPersonnel" />">
	<fieldset>
		<legend>Informations personnelles</legend>
		
		<div>
			<label>Civilité</label>
			<span>
				<input type="radio" name="civilite" value="Madame"> <label for="civilite">Mme</label>
				<input type="radio" name="civilite" value="Monsieur" checked> <label for="civilite">M.</label>
			</span>
		</div>
		
		<div>
			<label for="nom" class='required'>Nom </label>
			<input type="text" name="nom" required autocomplete="off"/>
		</div>
		
		<div>
			<label for="prenom" class='required'>Prénom </label>
			<input type="text" name="prenom" required autocomplete="off"/>
		</div>
		
		<div>
			<label for="date" class='required'>Date de naissance </label>
			<input type="text" name="date" class="datepicker" required autocomplete="off"/>
		</div>
					
		<div>
			<label for="fixe" class='required'>Téléphone fixe </label>
			<input type="text" name="fixe" maxlength="10" pattern="[0][1-9][0-9]{8}" required autocomplete="on"/>
		</div>
		
		<div>
			<label for="portable" class='required'>Téléphone portable </label>
			<input type="text" name="portable" maxlength="10" required pattern="[0][1-9][0-9]{8}"  autocomplete="on"/>
		</div>
		
		<div>
			<label for="email" class='required'>E-mail </label>
			<input type="email" name="email" required autocomplete="on"/>
	
		</div>
	</fieldset>
	
	<fieldset>
		<legend>Adresse</legend>
		
		<div>
			<label for="numRue" class='required'>N° </label>
			<input type="text" name="numRue" required pattern="\d*" autocomplete="off"/>
		</div>
		
		<div>
			<label for="nomRue" class='required'>Rue </label>
			<input type="text" name="nomRue" required autocomplete="off"/>
		</div>
		
		<div>
			<label for="infoComplem">Complément d'adresse</label>
			<input type="text" name="infoComplem" autocomplete="off" />
		</div>
		
		<div>
			<label for="ville" class='required'>Commune </label>
			<input type="text" name="ville" required autocomplete="off" />
		</div>
		
		<div>
			<label for="code" class='required'>Code postal </label>
			<input type="text" maxlength="5" name="code" required autocomplete="off" />
		</div>
	</fieldset>
	
	<fieldset>
		<legend>Informations professionnelles</legend>
		<div id="diplomes">
			<div id="divDiplome1">
				<label for="diplome1">Diplôme </label>
				<input type="text" name="diplome1" />
				<input type="button" value="+" id="ajoutDiplome"/>
				<input type="button" value="-" id="retireDiplome"/>
			</div>
		</div>

		<div id="fonctions">
			<div id="divFonction1">
				<label for="fonction1" class='required'>Fonction </label>
				<input type="text" name="fonction1" required />
				<input type="button" value="+" id="ajoutFonction"/>
				<input type="button" value="-" id="retireFonction"/>
			</div>
		</div>
	</fieldset>
	<fieldset class='align-center no-border'>
		<input type="submit" value="Suivant"/>
	</fieldset>
</form>
	
<c:import url="/inc/footer.inc.jsp" />