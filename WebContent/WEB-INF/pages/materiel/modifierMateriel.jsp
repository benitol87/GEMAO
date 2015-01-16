<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Materiel" scope="request" />

<c:import url="/inc/head.inc.jsp" />
<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<form name="modifierMaterielInstrument" action="#" method="post">
	<table>
		<tr>
			<td><label for="categorie">Catégorie : </label> <label
				for="categorieResult">${sessionScope.sessionObjectMateriel.getCategorie().getLibelleCat()}</label>

				<input type="number" id="categorie" name="categorie" hidden="true"
				value="${sessionScope.sessionObjectMateriel.getCategorie().getIdCategorie()}" />
			</td>

			<td><label for="designation">Désignation : </label> <label
				for="designationResult">${sessionScope.sessionObjectMateriel.getDesignation().getLibelleDesignation()}
			</label></td>
		</tr>
		<tr>
			<td><label for="valeurAch">Valeur d'achat : </label> <label
				for="valeurAchResult">${sessionScope.sessionObjectMateriel.getValeurAchat()}€
			</label></td>

			<td><label for="dateAch">Date d'achat : </label> <label
				for="dateAchResult">${sessionScope.sessionObjectMateriel.getDateAchat()}
			</label> <input type="text" hidden="true" id="dateAch" name="dateAch"
				value="${sessionScope.sessionObjectMateriel.getDateAchat()}" /> <input
				type="number" hidden="true" id="designation" name="designation"
				value="${sessionScope.sessionObjectMateriel.getDesignation().getIdDesignation()}" />
				<input type="number" hidden="true" id="valeurAch" name="valeurAch"
				value="${sessionScope.sessionObjectMateriel.getValeurAchat()}" /></td>
		</tr>
	</table>
	<table>
		<tr>
			<td>
				<fieldset>
					<legend>Instrument</legend>
					<table>
						<tr>
							<td><label for="type">Type : </label></td>
							<td><label for="typeResult">${sessionScope.sessionObjectMateriel.getTypeMat()}</label>
								<input type="text" hidden="true" id="type" name="type"
								value="${sessionScope.sessionObjectMateriel.getTypeMat()}" /></td>
						</tr>
						<tr>
							<!--% Etat à empêcher de s'améliorer -->
							<td><label for="etat">Etat : </label></td>
							<td><select name="etat" id="etat">
									<option
										value="${sessionScope.sessionObjectMateriel.getEtat().getIdEtat()}">${sessionScope.sessionObjectMateriel.getEtat().getLibelleEtat()}</option>
									<c:forEach items="${listeEtats}" var="etat">
										<option value="${etat.getIdEtat()}">${etat.getLibelleEtat()}</option>
									</c:forEach>
							</select> <label>${form.erreurs['etat'] }</label></td>
						</tr>

						<tr>
							<td><label for="marque">Marque : </label></td>
							<td><label for="marqueResult">${sessionScope.sessionObjectMateriel.getMarque().getNomMarque()}</label>
								<input type="number" hidden="true" id="marque" name="marque"
								value="${sessionScope.sessionObjectMateriel.getMarque().getIdMarque()}" />
							</td>
						</tr>
						<tr>
							<td><label for="quantite">Quantité : </label></td>
							<td><input name="quantite" type="number"
								value="${sessionScope.sessionObjectMateriel.getQuantite()}" />
								<label>${form.erreurs['quantite'] }</label></td>
						</tr>
						<tr>
							<td><label for="prixU">Prix unitaire : </label></td>
							<td><label for="prixU">${sessionScope.sessionObjectMateriel.getValeurAchat()}</label>
								<input hidden="true" name="prixU" type="number"
								value="${sessionScope.sessionObjectMateriel.getValeurAchat()}" /></td>
						</tr>
						<tr>
							<td><label for="numSerieResult">Numéro de série : </label></td>
							<td><label for="numSerieResult">${sessionScope.sessionObjectMateriel.getNumSerie()}</label>
								<input hidden="true" name="numSerie" type="text"
								value="${sessionScope.sessionObjectMateriel.getNumSerie()}" />
							</td>
						</tr>
						<tr>
							<td><label for="fournisseurResult">Fournisseur : </label></td>
							<td><label for="fournisseurResult">${sessionScope.sessionObjectMateriel.getFournisseur().getNomFournisseur()}</label>
								<input hidden="true" name="fournisseur" type="number"
								value="${sessionScope.sessionObjectMateriel.getFournisseur().getIdFournisseur()}" />
							</td>
						</tr>
					</table>
				</fieldset>
			</td>
			<td>
				<table>
					<tr>
						<td>
							<fieldset>
								<legend>louable</legend>
								<table>
									<tr>
										<td><label for="valRea">Valeur de
												réaprovisionnement : </label></td>
										<td><input type="number" name="valRea"
											value="${sessionScope.sessionObjectMateriel.getValeurReap()}" /><label>${form.erreurs['valRea'] }</label></td>
									</tr>
									<tr>
										<td><label for="deplacable">Déplaçable : </label></td>
										<td><c:choose>
												<c:when
													test="${sessionScope.sessionObjectMateriel.isDeplacable()==true}">
													<label for="deplacableOui">oui</label>
													<input type="radio" name="deplacable" id="deplacable"
														value="oui" checked="checked">
													<label for="deplacableNon">non</label>
													<input type="radio" name="deplacable" id="deplacable"
														value="non">
												</c:when>
												<c:otherwise>
													<label for="deplacableOui">oui</label>
													<input type="radio" name="deplacable" id="deplacable"
														value="oui">
													<label for="deplacableNon">non</label>
													<input type="radio" name="deplacable" id="deplacable"
														value="non" checked="checked">
												</c:otherwise>
											</c:choose></td>
									</tr>
								</table>
							</fieldset>
						</td>
					</tr>
					<tr>
						<td><label for="observation">Observation : </label> <textarea
								name="observation" id="observation" rows="5" cols="30">${sessionScope.sessionObjectMateriel.getObservation()}</textarea></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td><input type="submit" name="valider" value="Valider" /></td>
			<td></td>
			<td></td>
			<td><input type="button" name="annuler" value="Retour"
				onClick="javascript:window.history.go(-1)" /></td>
		</tr>
	</table>
</form>
<c:import url="/inc/footer.inc.jsp" />