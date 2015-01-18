<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Consultation d'un adhérent" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<h1>Consultation d'un adhérent</h1>

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
				<c:out value="${adherent.communeNaiss['nomCommune']}" />
			</p></td>
		<td><label for="codePNaiss">Code Postal : </label></td>
		<td><p>
				<c:out value="${adherent.communeNaiss['codePostal']}" />
			</p></td>
	</tr>
	<tr>
		<th><p>Adresse</p></th>
	</tr>
	<tr>
		<td><label for="num">Numéro : </label></td>
		<td><p>
				<c:out value="${adherent.adresse['numRue']}" />
			</p></td>
		<td><label for="rue">Rue : </label></td>
		<td><p>
				<c:out value="${adherent.adresse['nomRue']}" />
			</p></td>
		<td><label for="compl">Complémentaire : </label></td>
		<td><p>
				<c:out value="${adherent.adresse['infoCompl']}" />
			</p></td>
	</tr>
	<tr>
		<td><label for="commune">Commune : </label></td>
		<td><p>
				<c:out value="${adherent.adresse.commune['nomCommune']}" />
			</p></td>
		<td><label for="codePostal">Code Postal : </label></td>
		<td><p>
				<c:out value="${adherent.adresse.commune['codePostal']}" />
			</p></td>
	</tr>
</table>
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

<table>
<tr>
	<th>Informations complémentaires</th>
</tr>
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

<c:if test="${adherent.responsable!=null}">
<table>
	<caption>Responsable</caption>
	<tr>
		<td><label for="nom">Nom : </label></td>
		<td><p>
				<c:out value="${adherent.responsable['nom']}" />
			</p></td>
		<td><label for="prenom">Prénom : </label></td>
		<td><p>
				<c:out value="${adherent.responsable['prenom']}" />
			</p></td>
	</tr>
	<tr>
		<td><label for="tel">Téléphone : </label></td>
		<td><p>
				<c:out value="${adherent.responsable['telephone']}" />
			</p></td>
		<td><label for="email">E-mail : </label></td>
		<td><p>
				<c:out value="${adherent.responsable['email']}" />
			</p></td>
	</tr>
</table>
</c:if>


<div>
	<a href="ListeAdherents"> <input type="button" value="Retour" />
	</a>
</div>

<c:import url="/inc/footer.inc.jsp" />