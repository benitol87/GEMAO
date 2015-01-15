<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Consultation d'un personnel" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
<h1>Consultation d'un personnel</h1>
<table>
	<tr>
		<td><label for="nom">NOM : </label></td>
		<td><c:out value="${personnel['nom']}" /></td>
		<td><label for="prenom">Prénom : </label></td>
		<td><c:out value="${personnel['prenom']}" /></td>
	</tr>
	<tr>
		<td><label for="email">Email : </label></td>
		<td><c:out value="${personnel['email']}" /></td>
	</tr>
	<tr>
		<td><label for="fixe">Téléphone fixe : </label></td>
		<td><c:out value="${personnel['telFixe']}" /></td>
		<td><label for="portable">Téléphone portable : </label></td>
		<td><c:out value="${personnel['telPort']}" /></td>
	</tr>
</table>
<fieldset>
	<legend>Adresse</legend>
	<table>
		<tr>
			<td><label for="num">Numéro : </label></td>
			<td><p>
					<c:out value="${adresse['numRue']}" />
				</p></td>
		</tr>
		<tr>
			<td><label for="rue">Rue : </label></td>
			<td><p>
					<c:out value="${adresse['nomRue']}" />
				</p></td>
		</tr>
		<tr>
			<td><label for="compl">Complémentaire : </label></td>
			<td><p>
					<c:out value="${adresse['infoCompl']}" />
				</p></td>
		</tr>
		<tr>
			<td><label for="codeP">Code Postal : </label></td>
			<td><p>
					<c:out value="${commune['codePostal']}" />
				</p></td>
		</tr>
		<tr>
			<td><label for="commune">Commune : </label></td>
			<td><p>
					<c:out value="${commune['nomCommune']}" />
				</p></td>
		</tr>
	</table>
</fieldset>
<fieldset>
	<legend>Professionnel</legend>
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
			<td><label for="fonction">Responsabilité :</label> <c:forEach
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