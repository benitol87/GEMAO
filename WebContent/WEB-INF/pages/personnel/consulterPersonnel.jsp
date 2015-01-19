<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Consultation d'un membre du personnel" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
<h1>Consultation d'un membre du personnel</h1>
<fieldset>
	<legend>Informations personnelles</legend>
	<div>
	<label for="civilite">Civilité : </label>
	<c:out value="${personnel['civilite']}" />
	</div>
	<div>
	<label for="nom">Nom : </label>
	<c:out value="${personnel['nom']}" />
	</div>
	<div>
	<label for="prenom">Prénom : </label>
	<c:out value="${personnel['prenom']}" />
	</div>
	<div>
	<label for="fixe">Téléphone fixe : </label>
	<c:out value="${personnel['telFixe']}" />
	</div>
	<div>
	<label for="portable">Téléphone portable : </label>
	<c:out value="${personnel['telPort']}" />
	</div>
	<div>
	<label for="email">E-mail : </label>
	<c:out value="${personnel['email']}" />
	</div>
</fieldset>
<fieldset>
	<legend>Adresse</legend>
	<div>
	<label for="num">N° : </label>
	<c:out value="${adresse['numRue']}" />
	</div>
	<div>
	<label for="rue">Rue : </label>
	<c:out value="${adresse['nomRue']}" />
	</div>
	<div>
	<label for="compl">Complément d'adresse : </label>
	<c:out value="${adresse['infoCompl']}" />
	</div>
	<div>
	<label for="codeP">Code postal : </label>
	<c:out value="${commune['codePostal']}" />
	</div>
	<div>
	<label for="commune">Commune : </label>
	<c:out value="${commune['nomCommune']}" />
	</div>
</fieldset>
<fieldset>
	<legend>Informations professionnelles</legend>
	<table>
		<tr>
			<td><label for="contrat">Contrat : </label>
			<td><p>
					<c:out value="${contrat['typeContrat'].libelle}" />
				</p></td>
			</td>
		</tr>
		<tr>
			<td><label for="dateDebContrat">Date de début : </label>
			<td><p>
					<c:out value="${dateDebutContrat}" />
				</p></td>
			</td>
		</tr>
		<c:if test="${contrat['typeContrat'].libelle == 'CDD' }">
			<tr>
				<td><label for="dateFinContrat">Date de fin : </label>
				<td><p>
						<c:out value="${dateFinContrat}" />
					</p></td>
				</td>
			</tr>
		</c:if>
		<tr>
			<td><label for="diplome">Diplôme :</label></td>
			</label> <c:forEach
					items="${listeDiplome}" var="dipl">
					<tr>
						<td> - <c:out value="${dipl['nomDiplome']}" /></td>
					</tr>
				</c:forEach></td>
			<td></td>
		</tr>
		<tr>
			<td><label for="fonction">Responsabilité : </label> <c:forEach
					items="${listeResponsabilite}" var="resp">
					<tr>
						<td> - <c:out value="${resp['libelle']}" /></td>
					</tr>
				</c:forEach></td>
			<td></td>
		</tr>
	</table>
</fieldset>
<div>
	<a href="ListePersonnel"><input type="button" value="Retour" /></a> 
	<a href="ModifPersonnel?id=<c:out value="${personnel['idPersonne']}" />"><input type="button" value="Modifier" /></a>
</div>
<c:import url="/inc/footer.inc.jsp" />