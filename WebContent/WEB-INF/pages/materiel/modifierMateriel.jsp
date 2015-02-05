<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.gemao.view.Pattern"%>

<%@ page buffer="32kb" %>
<%@ page isErrorPage="true" %>

<c:set var="titre" value="Materiel" scope="request" />

<c:import url="/inc/head.inc.jsp" />
<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<h1>Modification d'un matériel</h1>
<p>${form.getErreurs().get("Modification")}</p>
<form name="modifierMaterielInstrument" action="#" method="post">
	<fieldset>
		<legend>Informations générales</legend>
		<div>
			<label for="categorie">Catégorie : </label> <select name="categorie"
				id="categorie">
				<option
					value="${sessionScope.sessionObjectMateriel.getCategorie().getIdCategorie()}">
					${sessionScope.sessionObjectMateriel.getCategorie().getLibelleCat()}</option>
				<c:forEach items="${listeCat}" var="cat">
					<option value="${cat.getIdCategorie()}">${cat.getLibelleCat()}</option>
				</c:forEach>
			</select> <input type="button" name="ajoutCategorie" id="ajoutCategorie"
				value="+" />
				<p>${form.getErreurs().get("categorie")}</p>
		</div>

		<div>
			<label for="valeurAch">Valeur d'achat : </label> <input type="number"
				id="valeurAch" name="valeurAch"
				value="${sessionScope.sessionObjectMateriel.getValeurAchat()}" />
				<p>${form.getErreurs().get("valeurAch")}</p>
		</div>
		<div>
			<label for="dateAch">Date d'achat : </label> <input type="text"
				id="dateAch" name="dateAch"
				value="${dateAchat}" />
				<p>${form.getErreurs().get("dateAch")}</p>
		</div>


		<div>
			<label for="valRea">Valeur de réapprovisionnement : </label> <input
				type="text" name="valRea"
				value="${sessionScope.sessionObjectMateriel.getValeurReap()}" /> <span
				class="euro"></span>
				<p>${form.getErreurs().get("valRea")}</p>
		</div>
		

		<div>
			<label for="fournisseurResult">Fournisseur : </label> <select
				name="fournisseur" id="fournisseur">
				<option
					value="${sessionScope.sessionObjectMateriel.getFournisseur().getIdFournisseur()}">
					${sessionScope.sessionObjectMateriel.getFournisseur().getNomFournisseur()}</option>
				<c:forEach items="${listeFourn}" var="fou">
					<option value="${fou.getIdFournisseur()}">${fou.getNomFournisseur()}</option>
				</c:forEach>
			</select> <input type="button" name="ajoutFournisseur" id="ajoutFournisseur"
				value="+" />
				<p>${form.getErreurs().get("fournisseur")}</p>
		</div>

	</fieldset>

	<fieldset>
		<legend>Informations détaillées</legend>
		<div>
			<label for="designation">Désignation : </label> <select
				name="designation" id="designation">
				<option
					value="${sessionScope.sessionObjectMateriel.getDesignation().getIdDesignation()}">
					${sessionScope.sessionObjectMateriel.getDesignation().getLibelleDesignation()}</option>
				<c:forEach items="${listeDes}" var="des">
					<option value="${des.getIdDesignation()}">${des.getLibelleDesignation()}</option>
				</c:forEach>
			</select> <input type="button" name="ajoutDesignation" id="ajoutDesignation"
				value="+" />
				<p>${form.getErreurs().get("designation")}</p>
		</div>

		<div>
			<label for="type">Type : </label> <input type="text" id="type"
				name="type"
				value="${sessionScope.sessionObjectMateriel.getTypeMat()}" />
				<p>${form.getErreurs().get("type")}</p>
		</div>

		<!--% Etat à empêcher de s'améliorer -->
		<div>
			<label for="etat">Etat : </label> <select name="etat" id="etat">
				<option
					value="${sessionScope.sessionObjectMateriel.getEtat().getIdEtat()}">
					${sessionScope.sessionObjectMateriel.getEtat().getLibelleEtat()}</option>
				<c:forEach items="${listeEtats}" var="etat">
					<option value="${etat.getIdEtat()}">${etat.getLibelleEtat()}</option>
				</c:forEach>
			</select> <input type="button" name="ajoutEtat" id="ajoutEtat" value="+" />
			<p>${form.getErreurs().get("etat")}</p>
		</div>

		<div>
			<label for="marque">Marque : </label> <select name="marque"
				id="marque">
				<option
					value="${sessionScope.sessionObjectMateriel.getMarque().getIdMarque()}">${sessionScope.sessionObjectMateriel.getMarque().getNomMarque()}</option>
				<c:forEach items="${listeMarque}" var="marque">
					<option value="${marque.getIdMarque()}">${marque.getNomMarque()}</option>
				</c:forEach>
			</select>
			<p>${form.getErreurs().get("marque")}</p>
		</div>
		<div>
			<label for="quantite">Quantité : </label> <input name="quantite"
				type="number" min="1"
				value="${sessionScope.sessionObjectMateriel.getQuantite()}" />
				<p>${form.erreurs['quantite'] }</p>
		</div>
		

		<div>
			<label for="prixU">Prix unitaire : </label> <input name="prixU"
				type="number"
				value="${sessionScope.sessionObjectMateriel.getValeurAchat()}" />
				<p>${form.getErreurs().get("prixU")}</p>
		</div>

		<div>
			<label for="numSerieResult">Numéro de série : </label> <input
				name="numSerie" type="text"
				value="${sessionScope.sessionObjectMateriel.getNumSerie()}" />
				<p>${form.getErreurs().get("numSerie")}</p>
		</div>



		<div>
			<label for="deplacable">Déplaçable : </label> <span> <c:choose>
					<c:when
						test="${sessionScope.sessionObjectMateriel.isDeplacable()==true}">
						<label for="deplacableOui">Oui</label>
						<input type="radio" name="deplacable" id="deplacable" value="oui"
							checked="checked" />
						<label for="deplacableNon">Non</label>
						<input type="radio" name="deplacable" id="deplacable" value="non" />
					</c:when>
					<c:otherwise>
						<label for="deplacableOui">Oui</label>
						<input type="radio" name="deplacable" id="deplacable" value="oui" />
						<label for="deplacableNon">Non</label>
						<input type="radio" name="deplacable" id="deplacable" value="non" checked="checked" />
					</c:otherwise>
				</c:choose>
			</span>
		</div>
		<div>
			<label for="louable">Ouvert à la location : </label> 
			<span> 
				<c:choose>
					<c:when
						test="${sessionScope.sessionObjectMateriel.isLouable()==true}">
						<label for="louableeOui">Oui</label>
						<input type="radio" name="louable" id="louable" value="oui" checked="checked" />
						<label for="louableNon">Non</label>
						<input type="radio" name="louable" id="louable" value="non" />
					</c:when>
					<c:otherwise>
						<label for="louableOui">Oui</label>
						<input type="radio" name="louable" id="louable" value="oui" />
						<label for="louableNon">Non</label>
						<input type="radio" name="louable" id="louable" value="non" checked="checked" />
					</c:otherwise>
				</c:choose>
			</span>
		</div>
	</fieldset>
	<fieldset>
		<legend>Observations</legend>

		<div class='align-center'>
			<textarea name="observation" id="observation" rows="5"
				placeholder="Ajoutez ici toute information que vous jugez nécessaire de mentionner."
				cols="30">${sessionScope.sessionObjectMateriel.getObservation()}</textarea>
		</div>
	</fieldset>
	<fieldset class='align-center no-border'>
		
		<input type="button" name="precedent" value="Précédent"
			onClick="javascript:window.history.go(-1)" /> <input type="submit"
			name="valider" value="Valider" />
	</fieldset>
</form>
<script src="<c:url value="/js/ajouterMateriel.js"/>"></script>
<c:import url="/inc/footer.inc.jsp" />