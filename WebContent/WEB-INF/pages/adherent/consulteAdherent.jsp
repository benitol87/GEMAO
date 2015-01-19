<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Consultation d'un adhérent" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<h1>Consultation d'un adhérent</h1>

<table class='table-col-2'>
	<caption>Informations personnelles</caption>
	<tr>
		<td>Civilité :</td>
		<td><c:out value="${adherent['civilite']}"></c:out></td>
	</tr>
	<tr>
		<td>Nom : </td>
		<td><c:out value="${adherent['nom']}" /></td>
	</tr>
	<tr>
		<td>Prénom : </td>
		<td><c:out value="${adherent['prenom']}" /></td>
	</tr>
	<tr>
		<td>Date de naissance : </td>
		<td><c:out value="${dateNaissance}" /></td>
	</tr>
	<tr>
		<td>Commune de naissance : </td>
		<td><c:out value="${adherent.communeNaiss['nomCommune']}" /></td>
	</tr>
	<tr>
		<td>Code postal : </td>
		<td><c:out value="${adherent.communeNaiss['codePostal']}" /></td>
	</tr>
	<tr>
		<td>Téléphone fixe : </td>
		<td><c:out value="${adherent['telFixe']}" /></td>
	</tr>
	<tr>
		<td>Téléphone portable : </td>
		<td><c:out value="${adherent['telPort']}" /></td>
	</tr>
	<tr>
		<td>E-mail : </td>
		<td><c:out value="${adherent['email']}" /></td>
	</tr>
</table>
<table  class='table-col-2'>
	<caption>Adresse</caption>
	<tr>
		<td>N° : </td>
		<td><c:out value="${adherent.adresse['numRue']}" /></td>
	</tr>
	<tr>
		<td>Rue : </td>
		<td><c:out value="${adherent.adresse['nomRue']}" /></td>
	</tr>
	<tr>
		<td>Complément d'adresse : </td>
		<td><c:out value="${adherent.adresse['infoCompl']}" /></td>
	</tr>
	<tr>
		<td>Commune : </td>
		<td><c:out value="${adherent.adresse.commune['nomCommune']}" /></td>
	</tr>
	<tr>
		<td>Code postal : </td>
		<td><c:out value="${adherent.adresse.commune['codePostal']}" /></td>
	</tr>
</table>
<table class='table-col-2'>
	<caption>Disciplines</caption>
	<tbody id="disciplines">
		<c:forEach var="discipline" items="${adherent.getDisciplines()}">
			<tr>
				<td class='align-center'>${ discipline.getNom() }</td>
			</tr>
		</c:forEach>	
	</tbody>
</table>
<table class='table-col-2'>
	<caption>Informations complémentaires</caption>
	<tr>
		<td>Date d'inscription : </td>
		<td><c:out value="${dateInscription}" /></td>
	</tr>
	<tr>
		<td>Montant de la cotisation : </td>
		<td><c:out value="${adherent['cotisation']}" /></td>
	</tr>
	<tr>
		<td>Droit à l'image :</td>
		<td>
			<c:choose>
				<c:when test="${adherent['droitImage']==true}">Oui</c:when>
				<c:otherwise>Non</c:otherwise>
			</c:choose>
		</td>
	</tr>
</table>
<c:if test="${adherent.responsable!=null}">
<table class='table-col-2'>
	<caption>Responsable</caption>
	<tr>
		<td>Nom : </td>
		<td><c:out value="${adherent.responsable['nom']}" /></td>
	</tr>
	<tr>
		<td>Prénom : </td>
		<td><c:out value="${adherent.responsable['prenom']}" /></td>
	</tr>
	<tr>
		<td>Téléphone : </td>
		<td><c:out value="${adherent.responsable['telephone']}" /></td>
	</tr>
	<tr>
		<td>E-mail : </td>
		<td><c:out value="${adherent.responsable['email']}" /></td>
	</tr>
</table>
</c:if>


<div class='align-center'>
	<a href="ListeAdherents"><input type="button" value="Retour" />
	</a>
</div>

<c:import url="/inc/footer.inc.jsp" />