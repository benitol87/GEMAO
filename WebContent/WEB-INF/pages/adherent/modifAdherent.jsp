<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.gemao.view.Pattern"%>

<c:set var="titre" value="Modification d'un adhérent" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<script src="<c:url value="/js/modifierAdherent.js"/>"></script>

<h1>Modification d'un adhérent</h1>
<form action="#" method="post">
	<fieldset>
		<legend>Informations personnelles</legend>
		<div><span class='text-label'>Civilité : </span><c:out value="${adherent['civilite']}" /></div>
		<div><span class='text-label'>Nom : </span><c:out value="${adherent['nom']}" /></div>
		<div><span class='text-label'>Prénom : </span><c:out value="${adherent['prenom']}" /></div>
		<div><span class='text-label'>Date de naissance : </span><c:out value="${dateNaissance}" /></div>
		<div><span class='text-label'>Commune de naissance : </span><c:out value="${adherent.communeNaiss.nomCommune}" /></div>
		<div><span class='text-label'>Code postal : </span><c:out value="${adherent.communeNaiss.codePostal}" /></div>
		<div>
			<label for="telFixe">Téléphone fixe : </label>
			<input type="text" name="telFixe" pattern="[0][1-9][0-9]{8}"
				required="required" maxlength="10" autocomplete="on"
				value="<c:out value="${adherent['telFixe']}"/>" />
		</div>
		<div>
			<label for="telPort">Téléphone portable : </label>
			<input type="text" name="telPort" pattern="[0][1-9][0-9]{8}"
				required="required" maxlength="10" autocomplete="on"
				value="<c:out value="${adherent['telPort']}"/>" />
		</div>
		<div>
			<label for="email">E-mail : </label>
			<input type="text" name="email" required="required"
				autocomplete="on" value="<c:out value="${adherent['email']}"/>" />
		</div>
	</fieldset>
	<fieldset>
		<legend>Adresse</legend>
		<div>
			<label for="num">N° : </label>
			<input type="text" name="num" required="required"
				pattern="\d*" autocomplete="off"
				value="<c:out value="${adherent.adresse.numRue}"/>" />
		</div>
		<div>
			<label for="rue">Rue : </label>
			<input type="text" name="rue" required="required"
				autocomplete="off"
				value="<c:out value="${adherent.adresse.nomRue}"/>" />
		</div>
		<div>
			<label for="compl">Complément d'adresse : </label>
			<input type="text" name="compl" autocomplete="off"
				value="<c:out value="${adherent.adresse.infoCompl}"/>" />
		</div>
		<div>
			<label for="commune">Commune : </label>
			<input type="text" name="commune" required="required"
				autocomplete="off"
				value="<c:out value="${adherent.adresse.commune.nomCommune}"/>" />
		</div>
		<div>
			<label for="codePostal">Code postal : </label>
			<input type="text" name="codePostal" required="required" maxlength="5"
				autocomplete="off"
				value="<c:out value="${adherent.adresse.commune.codePostal}"/>" />
		</div>
	</fieldset>
	<fieldset>
		<legend>Disciplines</legend>
		<div id="disciplines">
			<c:set var="i" value="1"></c:set>
			<c:forEach var="disciplines" items="${adherent.getDisciplines() }">
				<div>
					<label>Cours : </label>
					<input name='<c:out value="disciplinesAnciennes${ i }"></c:out>' value="${disciplines.getNom()}" readonly> 
					<input type="button" value="Supprimer" class="supprimerDiscipline">
				</div>
				<c:set var="i" value="${ i + 1}"></c:set>
			</c:forEach>
			<div id="select1">
				<label>Cours : </label>
				<select size="1" name="disciplines1" id="disciplines1">
					<c:forEach var="discipline" items="${sessionScope.listDiscipline }">
						<option value="${ discipline.getIdDiscipline() }">${ discipline.getNom() }</option>
					</c:forEach>		
				</select>
			</div>
		</div>
		<div class='align-center'>
			<input type="button" value="-" id="retireDiscipline" title="Retirer"/>
			<input type="button" value="+" id="ajoutDiscipline" title="Ajouter"/>
		</div>
	</fieldset>
	<c:if test="${ ! empty adherent.responsable }">
	<fieldset>
		<legend>Responsable</legend>
			<div>
				<label for="nomResp">Nom : </label>
				<input type="text" name="nomResp"
					value="<c:out value="${adherent.responsable['nom']}" />" />
			</div>
			<div>
				<label for="prenomResp">Prénom : </label>
				<input type="text" name="prenomResp"
					value="<c:out value="${adherent.responsable['prenom']}" />" />
			</div>
			<div>
				<label for="telResp">Téléphone : </label>
				<input type="text" name="telResp" maxlength="10"
					value="<c:out value="${adherent.responsable['telephone']}" />" />
			</div>
			<div>
				<label for="emailResp">E-mail : </label>
				<input type="text" name="emailResp"
					value="<c:out value="${adherent.responsable['email']}" />" />
			</div>
	</fieldset>
	</c:if>
	<fieldset>
	<legend>Informations complémentaires</legend>
			<div><span class='text-label'>Date d'inscription : </span>
				<c:out value="${dateInscription}" />
			</div>
			<div>
				<label>Droit à l'image :</label>
				<span>
					<input type="radio" name="droitImage" value="true"
						<c:if test="${adherent['droitImage'] == true}"> checked="checked" 
						</c:if> />
					<label for="droitImage">Oui</label>
					<input type="radio" name="droitImage" value="false"
						<c:if test="${adherent['droitImage'] == false}"> checked="checked" </c:if> />
					<label for="droitImage">Non</label>
				</span>
			</div>
	</fieldset>
	<fieldset class='align-center no-border'>
		<a href="<c:url value="<%= Pattern.ADHERENT_LISTER %>"/>">
			<input type="button" value="Retour" />
		</a>
		<input type="submit" value="Valider" />
	</fieldset>
</form>
<c:import url="/inc/footer.inc.jsp" />
