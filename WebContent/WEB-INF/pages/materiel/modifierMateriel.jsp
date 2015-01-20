<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Materiel" scope="request" />

<c:import url="/inc/head.inc.jsp" />
<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<h1>Modification d'un matériel</h1>
<form name="modifierMaterielInstrument" action="#" method="post">
	<fieldset>
		<legend>Informations générales</legend>
		<div>
			<label for="categorie">Catégorie : </label>
			<span>${sessionScope.sessionObjectMateriel.getCategorie().getLibelleCat()}</span>
		</div>
		
		<input type="number" id="categorie" name="categorie" hidden="true"
			value="${sessionScope.sessionObjectMateriel.getCategorie().getIdCategorie()}" />
			
		<div>
			<label for="designation">Désignation : </label>
			<span>${sessionScope.sessionObjectMateriel.getDesignation().getLibelleDesignation()}</span>
		</div>
		<div>
			<label for="valeurAch">Valeur d'achat : </label>
			<span class='euro'>${sessionScope.sessionObjectMateriel.getValeurAchat()}</span>
		</div>
		<div>
			<label for="dateAch">Date d'achat : </label>
			<span>${sessionScope.sessionObjectMateriel.getDateAchat()}</span>
		</div>
		<input type="text" hidden="true" id="dateAch" name="dateAch"
			value="${sessionScope.sessionObjectMateriel.getDateAchat()}" />
		<input type="number" hidden="true" id="designation" name="designation"
			value="${sessionScope.sessionObjectMateriel.getDesignation().getIdDesignation()}" />
		<input type="number" hidden="true" id="valeurAch" name="valeurAch"
			value="${sessionScope.sessionObjectMateriel.getValeurAchat()}" />
	
		<div>
			<label for="type">Type : </label>
			<span>${sessionScope.sessionObjectMateriel.getTypeMat()}</span>
		</div>
		
		<input type="text" hidden="true" id="type" name="type"
			value="${sessionScope.sessionObjectMateriel.getTypeMat()}" />
		
		<!--% Etat à empêcher de s'améliorer -->
		<div>
			<label for="etat">Etat : </label>
			<select name="etat" id="etat">
				<option value="${sessionScope.sessionObjectMateriel.getEtat().getIdEtat()}">
					${sessionScope.sessionObjectMateriel.getEtat().getLibelleEtat()}
				</option>
				<c:forEach items="${listeEtats}" var="etat">
					<option value="${etat.getIdEtat()}">${etat.getLibelleEtat()}</option>
				</c:forEach>
			</select>
			<input type="button" name="ajoutEtat" id="ajoutEtat" value="+" />
		</div>
		
		<p>${form.erreurs['etat'] }</p>
		
		<input type="text" name="nomEtat" id="nomEtat" class="hidden" />
		
		<div>
			<label for="marque">Marque : </label>
			<span>${sessionScope.sessionObjectMateriel.getMarque().getNomMarque()}</span>
		</div>
		
		<input type="number" hidden="true" id="marque" name="marque"
			value="${sessionScope.sessionObjectMateriel.getMarque().getIdMarque()}" />
			
		<div>
			<label for="quantite">Quantité : </label>
			<input name="quantite" type="number" value="${sessionScope.sessionObjectMateriel.getQuantite()}" />
		</div>
		<p>${form.erreurs['quantite'] }</p>
		
		<div>
			<label for="prixU">Prix unitaire : </label>
			<span>${sessionScope.sessionObjectMateriel.getValeurAchat()}</span>
		</div>

		<input hidden="true" name="prixU" type="number"
			value="${sessionScope.sessionObjectMateriel.getValeurAchat()}" />
			
		<div>
			<label for="numSerieResult">Numéro de série : </label>
			<span>${sessionScope.sessionObjectMateriel.getNumSerie()}</span>
		</div>

		<input hidden="true" name="numSerie" type="text"
			value="${sessionScope.sessionObjectMateriel.getNumSerie()}" />
			
		<div>
			<label for="fournisseurResult">Fournisseur : </label>
			<span>${sessionScope.sessionObjectMateriel.getFournisseur().getNomFournisseur()}</span>
		</div>
		
		<input hidden="true" name="fournisseur" type="number"
			value="${sessionScope.sessionObjectMateriel.getFournisseur().getIdFournisseur()}" />
	
		<div>
			<label for="valRea">Valeur de réaprovisionnement : </label>
			<input type="number" name="valRea"
				value="${sessionScope.sessionObjectMateriel.getValeurReap()}" />
		</div>
		<p>${form.erreurs['valRea'] }</p>
		<div>
			<label for="deplacable">Déplaçable : </label>
			<span>
				<c:choose>
					<c:when
						test="${sessionScope.sessionObjectMateriel.isDeplacable()==true}">
						<label for="deplacableOui">Oui</label>
						<input type="radio" name="deplacable" id="deplacable"
							value="oui" checked="checked">
						<label for="deplacableNon">Non</label>
						<input type="radio" name="deplacable" id="deplacable"
							value="non">
					</c:when>
					<c:otherwise>
						<label for="deplacableOui">Oui</label>
						<input type="radio" name="deplacable" id="deplacable"
							value="oui">
						<label for="deplacableNon">Non</label>
						<input type="radio" name="deplacable" id="deplacable"
							value="non" checked="checked">
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
						<input type="radio" name="louable" id="louable"
							value="oui" checked="checked">
						<label for="louableNon">Non</label>
						<input type="radio" name="louable" id="louable"
							value="non">
					</c:when>
					<c:otherwise>
						<label for="louableOui">Oui</label>
						<input type="radio" name="louable" id="louable"
							value="oui">
						<label for="louableNon">Non</label>
						<input type="radio" name="louable" id="louable"
							value="non" checked="checked">
					</c:otherwise>
				</c:choose>
			</span>
		</div>
	</fieldset>
	<fieldset>
		<legend>Observations</legend>

		<div class='align-center'>
			<textarea name="observation" id="observation" rows="5" cols="30">${sessionScope.sessionObjectMateriel.getObservation()}</textarea>
		</div>
	</fieldset>
	<fieldset class='align-center no-border'>
		<p>${form.erreurs['Modification']}</p>
		<input type="button" name="precedent" value="Précédent"
			onClick="javascript:window.history.go(-1)" />
		<input type="submit" name="valider" value="Valider" />
	</fieldset>
</form>
<script src="<c:url value="/js/ajouterMateriel.js"/>"></script>
<c:import url="/inc/footer.inc.jsp" />