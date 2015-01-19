<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Validation" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<h1>Validation</h1>

<form action="#" method="post">
	<fieldset>
		<legend>Informations personnelles</legend>
		<div>
			<span class='text-label'>Civilité :</span>
			<c:out value="${adherent['civilite']}"></c:out>
		</div>
		<div>
			<span class='text-label'>Nom : </span>
			<c:out value="${adherent['nom']}" />
		</div>
		<div>
			<span class='text-label'><label for="prenom">Prénom : </label></span>
			<c:out value="${adherent['prenom']}" />
		</div>
		<div>
			<span class='text-label'>Date de naissance : </span>
			<c:out value="${dateNaissance}" />
		</div>
		<div>
			<span class='text-label'>Téléphone fixe : </span>
			<c:out value="${adherent['telFixe']}" />
		</div>
		<div>
			<span class='text-label'>Téléphone portable : </span>
			<c:out value="${adherent['telPort']}" />
		</div>
		<div>
			<span class='text-label'>E-mail : </span>
			<c:out value="${adherent['email']}" />
		</div>
		<div>
			<span class='text-label'>Commune de naissance : </span>
			<c:out value="${communeNaiss['nomCommune']}" />
		</div>
		<div>
			<span class='text-label'>Code postal : </span>
			<c:out value="${communeNaiss['codePostal']}" />
		</div>			
	</fieldset>
	<fieldset>
		<legend>Adresse</legend>
		<div>
			<span class='text-label'>Numéro : </span>
			<c:out value="${adresse['numRue']}" />
		</div>
		<div>
			<span class='text-label'>Rue : </span>
			<c:out value="${adresse['nomRue']}" />
		</div>
		<div>
			<span class='text-label'>Complémentaire : </span>
			<c:out value="${adresse['infoCompl']}" />
		</div>
		<div>
			<span class='text-label'>Commune : </span>
			<c:out value="${commune['nomCommune']}" />
		</div>
		<div>
			<span class='text-label'>Code postal : </span>
			<c:out value="${commune['codePostal']}" />
		</div>
	</fieldset>
	<fieldset>
		<legend>Disciplines</legend>
			<c:forEach var="discipline" items="${sessionScope.ajout_adh_adherent.getDisciplines()}">
			<div class='align-center'>${ discipline.getNom() }</div>
			</c:forEach>		
	</fieldset>
	<fieldset>
		<legend>Informations complémentaires</legend>
		<div>
			<span class='text-label'>Date d'inscription : </span>
			<c:out value="${dateInscription}" />
		</div>
		<div>
			<span class='text-label'>Montant de la cotisation : </span>
			<c:out value="${adherent['cotisation']}" />
		</div>
		<div>
			<span class='text-label'>Droit à l'image : </span><c:choose>
							<c:when test="${adherent['droitImage']==true}">Oui</c:when>
							<c:otherwise>Non</c:otherwise>
						</c:choose>
			
		</div>
	</fieldset>
<c:if test="${responsable!=null}">
	<fieldset>
		<legend>Responsable</legend>
		<div>
			<span class='text-label'>Nom : </span>
			<c:out value="${responsable['nom']}" />
		</div>
		<div>
			<span class='text-label'>Prénom : </span>
			<c:out value="${responsable['prenom']}" />
		</div>
		<div>
			<span class='text-label'>Téléphone : </span>
			<c:out value="${responsable['telephone']}" />
		</div>
		<div>
			<span class='text-label'>E-mail : </span>
			<c:out value="${responsable['email']}" />
		</div>
	</fieldset>
</c:if>
<fieldset class='align-center no-border'>
	<input type="submit" value="Valider" />
</fieldset>
</form>


<c:import url="/inc/footer.inc.jsp" />