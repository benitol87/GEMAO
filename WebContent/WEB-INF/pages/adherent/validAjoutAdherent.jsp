<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Validation" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<h1>Validation</h1>

<form>
	<fieldset>
		<legend>Informations personnelles</legend>
		<table>
			<tr>
				<td><label>Civilité :</label></td>
				<td><p>
						<c:out value="${adherent['civilite']}"></c:out>
			</tr>
			<tr>
				<td><label for="nom">Nom : </label></td>
				<td><p>
						<c:out value="${adherent['nom']}" />
					</p></td>
				<td><label for="prenom">Prénom : </label></td>
				<td><p>
						<c:out value="${adherent['prenom']}" />
					</p></td>
				<td><label for="dateNaiss">Date de naissance : </label></td>
				<td><p>
						<c:out value="${dateNaissance}" />
					</p></td>
			</tr>
			<tr>
				<td><label for="telFixe">Téléphone fixe : </label></td>
				<td><p>
						<c:out value="${adherent['telFixe']}" />
					</p></td>
				<td><label for="telPort">Téléphone portable : </label></td>
				<td><p>
						<c:out value="${adherent['telPort']}" />
					</p></td>
				<td><label for="email">E-mail : </label></td>
				<td><p>
						<c:out value="${adherent['email']}" />
					</p></td>
			</tr>
			<tr>
				<td><label for="comNaiss">Commune de naissance : </label></td>
				<td><p>
						<c:out value="${communeNaiss['nomCommune']}" />
					</p></td>
				<td><label for="codePNaiss">Code postal : </label></td>
				<td><p>
						<c:out value="${communeNaiss['codePostal']}" />
					</p></td>
			</tr>
		</table>
	</fieldset>
	<fieldset>
		<legend>Adresse</legend>
		<table>
			<tr>
				<td><label for="num">Numéro : </label></td>
				<td><p>
						<c:out value="${adresse['numRue']}" />
					</p></td>
				<td><label for="rue">Rue : </label></td>
				<td><p>
						<c:out value="${adresse['nomRue']}" />
					</p></td>
				<td><label for="compl">Complémentaire : </label></td>
				<td><p>
						<c:out value="${adresse['infoCompl']}" />
					</p></td>
			</tr>
			<tr>
				<td><label for="commune">Commune : </label></td>
				<td><p>
						<c:out value="${commune['nomCommune']}" />
					</p></td>
				<td><label for="codePostal">Code postal : </label></td>
				<td><p>
						<c:out value="${commune['codePostal']}" />
					</p></td>
			</tr>
		</table>
	</fieldset>
	<fieldset>
		<legend>Disciplines</legend>
		<table>
			<tr>
				<td>
					<table>
						<tbody id="disciplines">
							<tr>
								<td>Discipline</td>
								<td>Classe</td>
							</tr>
							<c:forEach var="discipline" items="${sessionScope.ajout_adh_adherent.getDisciplines()}">
							<tr>
								<td>${ discipline.getNom() }</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</td>
			</tr>
		</table>
	</fieldset>
	<fieldset>
		<legend>Informations complémentaires</legend>
		<table>
			<tr>
				<td><label for="dateInscri">Date d'inscription : </label></td>
				<td><p>
						<c:out value="${dateInscription}" />
					</p></td>
				<td><label for="cotisation">Montant de la cotisation : </label></td>
				<td><p>
						<c:out value="${adherent['cotisation']}" />
					</p></td>
				<td><span>Droit à l'image :<c:choose>
							<c:when test="${adherent['droitImage']==true}">Oui</c:when>
							<c:otherwise>Non</c:otherwise>
						</c:choose>
				</span></td>
			</tr>
		</table>
	</fieldset>
<c:if test="${responsable!=null}">
	<fieldset>
		<legend>Responsable</legend>
		<table>
			<tr>
				<td><label for="nom">Nom : </label></td>
				<td><p>
						<c:out value="${responsable['nom']}" />
					</p></td>
				<td><label for="prenom">Prénom : </label></td>
				<td><p>
						<c:out value="${responsable['prenom']}" />
					</p></td>
			</tr>
			<tr>
				<td><label for="tel">Téléphone : </label></td>
				<td><p>
						<c:out value="${responsable['telephone']}" />
					</p></td>
				<td><label for="email">E-mail : </label></td>
				<td><p>
						<c:out value="${responsable['email']}" />
					</p></td>
			</tr>
		</table>
	</fieldset>
</form>
</c:if>

<form action="#" method="post">
	<a href="../index.jsp"><input type="button" value="Annuler" /></a><input
		type="submit" value="Valider" />
</form>


<c:import url="/inc/footer.inc.jsp" />