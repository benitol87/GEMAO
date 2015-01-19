<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Materiel" scope="request" />

<c:import url="/inc/head.inc.jsp" />
<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<h1>Consultation d'un matériel</h1>
<table class='table-col-2'>
	<caption>Informations générales</caption>
	<tr>
		<td>Catégorie : </td> 
		<td>${sessionScope.sessionObjectMateriel.getCategorie().getLibelleCat()}</td>

	</tr>
	
	<tr>
			<td>Valeur d'achat : </td> 
			<td>
				${sessionScope.sessionObjectMateriel.getValeurAchat()}
				<span class="euro"></span>
			</td>
			
	</tr>
	<tr>
			<td>Date d'achat : </td> 
			<td>${sessionScope.sessionObjectMateriel.getDateAchat()}</td>
	</tr>
	
	<tr>
		<td>Valeur de réaprovisionnement : </td>
		<td>
			${sessionScope.sessionObjectMateriel.getValeurReap()}
			<span class="euro"></span>
		</td>
	</tr>
	
	<tr>
		<td>Fournisseur : </td>
		<td>${sessionScope.sessionObjectMateriel.getFournisseur().getNomFournisseur()}</td>
	</tr>
</table>

<table class='table-col-2'>
	<caption>Informations détaillées</caption>
	<tr>
		<td>Désignation : </td> 
		<td>${sessionScope.sessionObjectMateriel.getDesignation().getLibelleDesignation()}</td>
	</tr>
	
	<tr>
		<td>Type : </td>
		<td>${sessionScope.sessionObjectMateriel.getTypeMat()}</td>
	</tr>
	<tr>
		<td>Etat : </td>
		<td>${sessionScope.sessionObjectMateriel.getEtat().getLibelleEtat()}</td>
	</tr>

	<tr>
		<td>Marque : </td>
		<td>${sessionScope.sessionObjectMateriel.getMarque().getNomMarque()}</td>
	</tr>
	
	<!-- Ajouter situation -->
	
	<tr>
		<td>Quantité : </td>
		<td>${sessionScope.sessionObjectMateriel.getQuantite()}</td>
	</tr>
	<tr>
		<td>Prix unitaire : </td>
		<td>${sessionScope.sessionObjectMateriel.getValeurAchat()}</td>
	</tr>
	<tr>
		<td>Numéro de série : </td>
		<td>${sessionScope.sessionObjectMateriel.getNumSerie()}</td>
	</tr>

	<tr>
		<td>Déplaçable : </td>
		<td>
			<c:choose>
				<c:when
					test="${sessionScope.sessionObjectMateriel.isDeplacable()==true}">
					oui
				</c:when>
				<c:otherwise>
					non
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
</table>

<c:if test="${sessionScope.sessionObjectMateriel.getObservation() != null}">
	<table>
		<caption>Observations</caption>
			<tr>
				<td>${sessionScope.sessionObjectMateriel.getObservation()}</td>
			</tr>
	</table>
</c:if>	

<p class='align-center'>
	<a href="ListerMateriel"><input type="button" value="Retour" />
	</a>
</p>
	
<c:import url="/inc/footer.inc.jsp" />