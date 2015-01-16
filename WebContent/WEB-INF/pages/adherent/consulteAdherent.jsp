<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Consultation d'un adhérent" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<h1>Consultation d'un adhérent</h1>
<table>
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
</table>
<br />

<fieldset>
	<legend>Adresse</legend>
	<table>
		<tr>
			<td><label for="num">Numéro : </label></td>
			<td><p><c:out value="${adherent.adresse.numRue}"/></p></td>
		</tr>
		<tr>
			<td><label for="rue">Rue : </label></td>
			<td><p><c:out value="${adherent.adresse.nomRue}"/></p></td>
		</tr>
		<tr>
			<td><label for="compl">Complémentaire : </label></td>
			<td><p><c:out value="${adherent.adresse.infoCompl}"/></p></td>
		</tr>
		<tr>
			<td><label for="codeP">Code Postal : </label></td>
			<td><p><c:out value="${adherent.adresse.commune.codePostal}"/></p></td>
		</tr>
		<tr>
			<td><label for="commune">Commune : </label></td>
			<td><p><c:out value="${adherent.adresse.commune.nomCommune}"/></p></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend>Discipline</legend>
	<table>
		<tbody id="disciplines">
			<tr>
				<td><p>Discipline</p></td>
			</tr>
			<c:forEach items="${requestScope.adherent['disciplines']}" var="discipline">
				<tr>
					<td><p><c:out value="${discipline }"></c:out></p></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</fieldset>
<div>
	<span>Droit à l'image :<c:choose>
			<c:when test="${adherent['droitImage']==true}">Oui</c:when>
			<c:otherwise>Non</c:otherwise>
		</c:choose>

	</span>
</div>

<c:if test="${adherent.responsable.idResponsable!=null}">
	<table>
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
	<a href="ListeAdherents">
		<input type="button" value="Retour" />
	</a>
	<input type="button" value="Modifier" />
</div>

<c:import url="/inc/footer.inc.jsp" />