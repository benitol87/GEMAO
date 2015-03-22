<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.gemao.view.Pattern"%>

<c:set var="titre" value="Ajout d'un membre du personnel - Informations personnelles" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<c:import url="/js/autocompleteCommune.jsp"/>

<script src="<c:url value="/js/AjouterPersonnel.js"/>"></script>

	<!-- 1er partie du formulaire -->
<h1>Ajout d'un membre du personnel</h1>
<form id="ajoutp1" method="post" action="<c:url value="<%= Pattern.PERSONNEL_AJOUT %>" />">
	<fieldset>
		<legend>Informations personnelles</legend>
		
		<div>
			<label>Civilité</label>
			<span>
				<input type="radio" name="civilite" value="Madame" checked> <label for="civilite">Mme</label>
				<input type="radio" name="civilite" value="Monsieur"> <label for="civilite">M.</label>
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
			<label for="comnaiss" class='required'>Commune de naissance </label>
			<input type="text" name="comnaiss" required id="commune"/>
		</div>
					
		<div>
			<label for="codep" class='required'>Code postal </label>
			<input type="text" maxlength="5" name="codep" required autocomplete="off" />
		</div>
					
		<div>
			<label for="fixe" class='required'>Téléphone fixe </label>
			<input type="text" name="fixe" maxlength="10" pattern="[0][1-9][0-9]{8}" required autocomplete="on"/>
		</div>
		
		<div>
			<label for="portable">Téléphone portable </label>
			<input type="text" name="portable" maxlength="10" pattern="[0][1-9][0-9]{8}"  autocomplete="on"/>
		</div>
		
		<div>
			<label for="email">E-mail </label>
			<input type="email" name="email" autocomplete="on"/>
	
		</div>
		
		<div>
			<label for="email">Numéro de sécurité sociale </label>
			<input type="text" name="numeroSS" autocomplete="on" maxlength="15"/>
		</div>
	</fieldset>
	
	<fieldset>
		<legend>Adresse</legend>
		
		<div>
			<label for="numRue">N° </label>
			<input type="text" name="numRue" pattern="\d*" autocomplete="off"/>
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
				<select name="fonction1" required>
					<c:forEach var="responsabilite" items="${sessionScope.listResponsabilites }">
						<option value="${ responsabilite.getIdResponsabilite() }">${ responsabilite.getLibelle() }</option>
					</c:forEach>
				</select>
				<input type="button" value="+" id="ajoutFonction"/>
				<input type="button" value="-" id="retireFonction"/>
			</div>
		</div>
		
		<div id="disciplines">
			<div id="discipline1">
				<label for="discipline1">Discipline </label>
				<select name="discipline1">
				
				</select>
				<input type="button" value="+" id="ajoutDiscipline"/>
				<input type="button" value="-" id="retireDiscipline"/>
			</div>
		</div>
	</fieldset>
	<fieldset class='align-center no-border'>
		<input type="submit" value="Suivant"/>
	</fieldset>
</form>
	
<c:import url="/inc/footer.inc.jsp" />