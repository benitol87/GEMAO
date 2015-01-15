<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Materiel" scope="request" />

<c:import url="/inc/head.inc.jsp" />
<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<form name="consulterMateriel" action="#" method="post">
	<table>
		<tr>
			<td>
				<label for="categorie">Catégorie : </label> 
				<label for="categorieResult">${sessionScope.sessionObjectMateriel.getCategorie().getLibelleCat()}</label>
			</td>

			<td>
				<label for="designation">Désignation : </label> 
				<label for="designationResult">${sessionScope.sessionObjectMateriel.getDesignation().getLibelleDesignation()}</label>
			</td>
		</tr>
		<tr>
			<td>
				<label for="valeurAch">Valeur d'achat : </label> 
				<label for="valeurAchResult">${sessionScope.sessionObjectMateriel.getValeurAchat()}€</label>
			</td>

			<td>
				<label for="dateAch">Date d'achat : </label> 
				<label for="dateAchResult">${sessionScope.sessionObjectMateriel.getDateAchat()}</label> 
			</td>
		</tr>
	</table>
	<table>
		<tr>
			<td>
				<fieldset>
					<table>
						<tr>
							<td><label for="type">Type : </label></td>
							<td><label for="typeResult">${sessionScope.sessionObjectMateriel.getTypeMat()}</label></td>
						</tr>
						<tr>
							<!--% Etat à empêcher de s'améliorer -->
							<td><label for="etat">Etat : </label></td>
							<td><label for="etatResult">${sessionScope.sessionObjectMateriel.getEtat().getLibelleEtat()}</label>
						</tr>

						<tr>
							<td><label for="marque">Marque : </label></td>
							<td><label for="marqueResult">${sessionScope.sessionObjectMateriel.getMarque().getNomMarque()}</label></td>
						</tr>
						<tr>
							<td><label for="quantite">Quantité : </label></td>
							<td><label for="quantiteResult">${sessionScope.sessionObjectMateriel.getQuantite()}</label></td>
						</tr>
						<tr>
							<td><label for="prixU">Prix unitaire : </label></td>
							<td><label for="prixU">${sessionScope.sessionObjectMateriel.getValeurAchat()}</label></td>
						</tr>
						<tr>
							<td><label for="numSerieResult">Numéro de série : </label></td>
							<td><label for="numSerieResult">${sessionScope.sessionObjectMateriel.getNumSerie()}</label></td>
						</tr>
						<tr>
							<td><label for="fournisseurResult">Fournisseur : </label></td>
							<td><label for="fournisseurResult">${sessionScope.sessionObjectMateriel.getFournisseur().getNomFournisseur()}</label></td>
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
										<td><label for="valReaResult">${sessionScope.sessionObjectMateriel.getValeurReap()}</label></td>
									</tr>
									<tr>
										<td><label for="deplacable">Déplaçable : </label></td>
										<td><c:choose>
												<c:when
													test="${sessionScope.sessionObjectMateriel.isDeplacable()==true}">
													<label for="deplacable">oui</label>
												</c:when>
												<c:otherwise>
													<label for="deplacable">non</label>
												</c:otherwise>
											</c:choose></td>
									</tr>
								</table>
							</fieldset>
						</td>
					</tr>
					<tr>
						<td><label for="observation">Observation : </label> 
						<label for="observation">${sessionScope.sessionObjectMateriel.getObservation()}</label></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td><input type="button" name="annuler" value="Retour" onClick="javascript:window.history.go(-1)" /></td>
		</tr>
	</table>
</form>
<c:import url="/inc/footer.inc.jsp" />