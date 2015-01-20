<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Ajout d'un adhérent" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<script src="<c:url value="/js/jquery.min.js"/>"></script>
<script src="<c:url value="/js/jquery-ui.min.js"/>"></script>
<script src="<c:url value="/js/datepicker.js"/>"></script>
<script src="<c:url value="/js/AjouterAdherent.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/datepicker.css"/>" />
<h1>Ajout d'un adhérent</h1>
<form action="#" method="post">
	<fieldset>
		<legend>Informations personnelles</legend>
		
		<div>
			<label>Civilité</label>
			<span>
				<input type="radio" name="civilite" value="F" /> <label for="civilite">Mme</label>
				<input type="radio" name="civilite" value="M"
							checked="checked" /><label for="civilite">M.</label>
			</span>
		</div>
		
		<div>
			<label for="nom" class='required'>Nom </label>
			<input type="text" name="nom" required="required"
						 />
		</div>
		
		<div>
			<label for="prenom" class='required'>Prénom </label>
			<input type="text" name="prenom" required="required"
						 />
		</div>
		
		<div>
			<label for="dateNaiss" class='required'>Date de naissance </label>
			<input type="text" name="dateNaiss" class="datepicker"
						required="required"  />
		</div>
		
		<div>
			<label for="comNaiss" class='required'>Commune de naissance </label>
			<input type="text" name="comNaiss" required="required"
						 />
		</div>
		
		<div>	
			<label for="codePNaiss" class='required'>Code postal </label>
			<input type="text" name="codePostNaiss" required="required" maxlength="5"
						 />
		</div>
		
		<div>
			<label for="telFixe" class='required'>Téléphone fixe </label>
			<input type="text" name="telFixe" pattern="[0][1-9][0-9]{8}"
						required="required"  maxlength="10" autocomplete="on" />
		</div>
		
		<div>
			<label for="telPort" class='required'>Téléphone portable </label>
			<input type="text" name="telPort" pattern="[0][1-9][0-9]{8}"
						required="required" maxlength="10" autocomplete="on" />
		</div>
		
		<div>
			<label for="email" class='required'>E-mail </label>
			<input type="text" name="email" required="required"
						autocomplete="on" />
		</div>
	</fieldset>
	<fieldset>
		<legend>Adresse</legend>
		<div>
			<label for="num" class='required'>N° </label>
			<input type="text" name="num" required="required"
					pattern="\d*"  />
		</div>
		
		<div>	
			<label for="rue" class='required'>Rue </label>
			<input type="text" name="rue" required="required"
					 />
		</div>
		
		<div>	
			<label for="compl">Complément d'adresse </label>
			<input type="text" name="compl"  />
		</div>
		
		<div>	
			<label for="commune" class='required'>Commune </label>
			<input type="text" name="commune" required="required"
					 />
		</div>
		
		<div>	
			<label for="codePostal" class='required'>Code postal </label>
			<input type="text" name="codePostal" required="required" maxlength="5"
					 />
		</div>
	</fieldset>
	<fieldset>
		<legend>Disciplines</legend>
		<div id='disciplines'>
			<div>
				<label>Cours</label>
				<select size="1" name="disciplines1">
					<c:forEach var="discipline" items="${sessionScope.listDiscipline }">
						<option value="${ discipline.getIdDiscipline() }">${ discipline.getNom() }</option>
					</c:forEach>		
				</select>
			</div>
		</div>
		<div class='align-center'>
			<input type="button" value="Retirer" id="retireDiscipline" />
			<input type="button" value="Ajouter" id="ajoutDiscipline" />
		</div>	
	</fieldset>
	<fieldset>
		<legend>Informations complémentaires</legend>
		<div>
			<label for="dateInscri" class='required'>Date d'inscription </label>
			<input type="text" name="dateInscri" class="datepicker"
					required="required"  />
		</div>
		<div>
			<label  class='required'>Droit à l'image </label>
			<span>
				<input type="radio" name="droitImage" value="true" checked="checked" />
				<label for="droitImage">Oui</label>
				<input type="radio" name="droitImage" value="false" />
				<label for="droitImage">Non</label>
			</span>
		</div>
	</fieldset>
	<fieldset class='align-center no-border'>
		<input type="submit" value="Suivant" />
	</fieldset>
</form>
<c:import url="/inc/footer.inc.jsp" />
