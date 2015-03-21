<%@page import="java.util.ArrayList"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Ajout d'un adhérent" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<c:import url="/js/autocompleteCommune.jsp"/>

<script src="<c:url value="/js/AjouterAdherent.js"/>"></script>


<h1>Ajout d'un adhérent</h1>

<c:if test="${errDate}">
	<p class="offset">Date de naissance < Date d'inscription <= Date du jour</p>
</c:if>
<form id="ajoutAdherent" action="#" method="post">
	<fieldset>
		<legend>Informations personnelles</legend>

		<div>
			<label>Civilité</label> <span> <input type="radio"
				name="civilite" value="F" id="civiliteF" checked="checked" /> <label
				for="civiliteF">Mme</label> <input type="radio" name="civilite" id="civiliteM"
				value="M" /><label for="civiliteM">M.</label>
			</span>
		</div>

		<div>
			<label for="nom" class='required'>Nom </label> <input type="text"
				name="nom" required="required" />
		</div>

		<div>
			<label for="prenom" class='required'>Prénom </label> <input
				type="text" name="prenom" required="required" />
		</div>

		<div>
			<label for="dateNaiss" class='required'>Date de naissance </label> <input
				type="text" name="dateNaiss" class="datepicker" required="required" />
		</div>

		<div>
			<label for="telFixe" class='required'>Téléphone fixe </label> <input
				type="text" name="telFixe" pattern="[0][1-9][0-9]{8}"
				required="required" maxlength="10" autocomplete="on" />
		</div>

		<div>
			<label for="telPort">Téléphone portable </label> <input type="text"
				name="telPort" pattern="[0][1-9][0-9]{8}" maxlength="10"
				autocomplete="on" />
		</div>

		<div>
			<label for="email">E-mail </label> <input type="email" name="email"
				autocomplete="on" />
		</div>
	</fieldset>
	<fieldset>
		<legend>Adresse</legend>
		<div>
			<label for="num">N° </label> <input type="text" name="num" />
		</div>

		<div>
			<label for="rue" class='required'>Rue </label> <input type="text"
				name="rue" required="required" />
		</div>

		<div>
			<label for="compl">Complément d'adresse </label> <input type="text"
				name="compl" />
		</div>

		<div>
			<label for="commune" class='required'>Commune </label> <input
				type="text" name="commune" required="required" id="commune" />
		</div>

		<div>
			<label for="codePostal" class='required'>Code postal </label> <input
				type="text" name="codePostal" id="codePostal" required="required" maxlength="5"
				pattern="\d*" />
		</div>
	</fieldset>
	<fieldset>
		<legend>Disciplines</legend>
		<div id='disciplines'>
			<div>
				<label>Cours</label> <select size="1" name="disciplines1">
					<c:forEach var="discipline" items="${sessionScope.listDiscipline }">
						<option value="${ discipline.getIdDiscipline() }">${ discipline.getMatiere().getNomMatiere()}
							- ${discipline.getNiveau().getNomNiveau() }</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class='align-center'>
			<input type="button" value="-" id="retireDiscipline" title="Retirer" />
			<input type="button" value="+" id="ajoutDiscipline" title="Ajouter" />
		</div>
	</fieldset>
	<fieldset>
		<legend>Informations complémentaires</legend>
		<div>
			<label for="dateInscri" class='required'>Date d'inscription </label>
			<input type="text" name="dateInscri" id="dateInscri"
				class="datepicker" required="required" />
		</div>
		<div>
			<label class='required'>Droit à l'image </label> <span> <input
				type="radio" name="droitImage" value="true" checked="checked" /> <label
				for="droitImage">Oui</label> <input type="radio" name="droitImage"
				value="false" /> <label for="droitImage">Non</label>
			</span>
		</div>
		<div>
			<label class='required'>Membre CA </label> <span> <input
				type="radio" name="membreCA" value="true"  /> <label
				for="membreCA">Oui</label> <input type="radio" name="membreCA"
				value="false" checked="checked"/> <label for="membreCA">Non</label>
			</span>
		</div>
	</fieldset>
	<fieldset class='align-center no-border'>
		<p>* Champs obligatoires</p>
		<input type="submit" value="Suivant" />
	</fieldset>
</form>
<c:import url="/inc/footer.inc.jsp" />
