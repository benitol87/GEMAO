<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Ajout d'un adhérent" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<script src="<c:url value="/js/AjouterAdherent.js"/>"></script>

<h1>Ajout d'un adhérent</h1>
<form id="ajoutAdherent" action="#" method="post">
	<fieldset>
		<legend>Informations personnelles</legend>

		<div>
			<label>Civilité</label> <span> <input type="radio"
				name="civilite" value="F" checked="checked" /> <label
				for="civilite">Mme</label> <input type="radio" name="civilite"
				value="M" <c:if test="${civilite == 'M' }">checked="checked"</c:if>/><label for="civilite">M.</label>
			</span>
		</div>

		<div>
			<label for="nom" class='required'>Nom </label> <input type="text"
				name="nom" required="required" <c:out value="${nom}"/> />
		</div>

		<div>
			<label for="prenom" class='required'>Prénom </label> <input
				type="text" name="prenom" required="required" <c:out value="${prenom}"/>/>
		</div>

		<div>
			<label for="dateNaiss" class='required'>Date de naissance </label> <input
				type="text" name="dateNaiss" class="datepicker" required="required" <c:out value="${dateNaiss}"/>/>
		</div>

		<div>
			<label for="telFixe" class='required'>Téléphone fixe </label> <input
				type="text" name="telFixe" pattern="[0][1-9][0-9]{8}"
				required="required" maxlength="10" autocomplete="on" <c:out value="${telFixe}"/>/>
		</div>

		<div>
			<label for="telPort">Téléphone portable </label> <input type="text"
				name="telPort" pattern="[0][1-9][0-9]{8}" maxlength="10"
				autocomplete="on" <c:out value="${telPort}"/>/>
		</div>

		<div>
			<label for="email">E-mail </label> <input type="email" name="email"
				autocomplete="on" <c:out value="${email}"/>/>
		</div>
	</fieldset>
	<fieldset>
		<legend>Adresse</legend>
		<div>
			<label for="num">N° </label> <input type="text" name="num" <c:out value="${num}"/>/>
		</div>

		<div>
			<label for="rue" class='required'>Rue </label> <input type="text"
				name="rue" required="required" <c:out value="${rue}"/>/>
		</div>

		<div>
			<label for="compl">Complément d'adresse </label> <input type="text"
				name="compl" <c:out value="${compl}"/>/>
		</div>

		<div>
			<label for="commune" class='required'>Commune </label> <input
				type="text" name="commune" required="required" <c:out value="${commune}"/>/>
		</div>

		<div>
			<label for="codePostal" class='required'>Code postal </label> <input
				type="text" name="codePostal" required="required" maxlength="5" pattern="\d*" <c:out value="${codePostal}"/>/>
		</div>
	</fieldset>
	<fieldset>
		<legend>Disciplines</legend>
		<div id='disciplines'>
			<div>
				<label>Cours</label> <select size="1" name="disciplines1">
					<c:forEach var="discipline" items="${sessionScope.listDiscipline }">
						<option value="${ discipline.getIdDiscipline() }">${ discipline.getNom() }</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class='align-center'>
			<input type="button" value="-" id="retireDiscipline" title="Retirer" />
			<input type="button" value="+" id="ajoutDiscipline" title="Ajouter" />
			<input type="button" name="ajoutNewDiscipline" id="ajoutNewDiscipline"
			value="Créer..." /> <input type="text" name="nomDiscipline"
			id="nomDiscipline" class="hidden" />
		</div>
	</fieldset>
	<fieldset>
		<legend>Informations complémentaires</legend>
		<div>
			<label for="dateInscri" class='required'>Date d'inscription </label>
			<input type="text" name="dateInscri" id="dateInscri"
				class="datepicker" required="required" <c:out value="${dateInscri}"/>/>
		</div>
		<div>
			<label class='required'>Droit à l'image </label> <span> <input
				type="radio" name="droitImage" value="true" checked="checked" /> <label
				for="droitImage">Oui</label> <input type="radio" name="droitImage"
				value="false" <c:if test="${droitImage == false}">checked="checked"</c:if>/> <label for="droitImage">Non</label>
			</span>
		</div>
	</fieldset>
	<fieldset class='align-center no-border'>
		<p>* Champs obligatoires</p>
		<input type="submit" value="Suivant" />
	</fieldset>
</form>
<c:import url="/inc/footer.inc.jsp" />
