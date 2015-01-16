<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Validation" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<h1>Validation</h1>


<table>
	<tr>
		<td><p>Civilité :</p></td>
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
				<c:out value="${adherent['dateNaissance']}" />
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
		<td><label for="codePNaiss">Code Postal : </label></td>
		<td><p>
				<c:out value="${communeNaiss['codePostal']}" />
			</p></td>
	</tr>
	<tr>
		<th><p>Adresse</p></th>
	</tr>
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
		<td><label for="codePostal">Code Postal : </label></td>
		<td><p>
				<c:out value="${commune['codePostal']}" />
			</p></td>
	</tr>
	<tr>
		<td>
			<table>
				<tbody id="disciplines">
					<tr>
						<th><p>Disciplines</p></th>
					</tr>
					<tr>
						<td>Discipline</td>
						<td>Classe</td>
					</tr>
					<tr>
						<td>test</td>
						<td>test</td>
					</tr>
				</tbody>
			</table>
		</td>
	</tr>

	<tr>
		<th>Informations supplémentaires</th>
	</tr>
	<tr>
		<td><label for="dateInscri">Date d'inscripton : </label></td>
		<td><p>
				<c:out value="${adherent['dateEntree']}" />
			</p></td>
		<td><label for="cotisation">Cotisation : </label></td>
		<td><p>
				<c:out value="${adherent['cotisation']}" />
			</p></td>
		<td><span>Droit à l'image :<c:choose>
					<c:when test="${adherent['droitImage']==true}">Oui</c:when>
					<c:otherwise>Non</c:otherwise>
				</c:choose>
		</span></td>
	</tr>
	<c:if test="${responsable!=null}">
		<tr>
			<th>Responsable</th>
		</tr>
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
	</c:if>
</table>

<form action="#" method="post">
	<a href="index.jsp"><input type="button" value="Annuler" /></a><input
		type="submit" value="Valider" />
</form>


<c:import url="/inc/footer.inc.jsp" />