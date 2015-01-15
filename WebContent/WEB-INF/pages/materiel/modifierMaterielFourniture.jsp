<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Materiel" scope="request" />

<c:import url="/inc/head.inc.jsp" />
<script type="text/javascript" src="js/ajoutMateriel.js"></script>
<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<table>
	<tr>
		<td><label for="categorie">Catégorie : </label> <label
			for="categorieResult">Fourniture</label></td>

		<td><label for="designation">Désignation : </label> <label
			for="designationResult">${materiel.getDesignation().getLibelleDesignation()}
		</label></td>
	</tr>
	<tr>
		<td><label for="valeurAch">Valeur d'achat : </label> <label
			for="valeurAchResult">${materiel.getValeurAchat()}</label></td>

		<td><label for="dateAch">Date d'achat : </label> <label
			for="dateAchResult">${materiel.getDateAchat()} </label></td>
	</tr>
</table>
<form id="ajouterMaterielFourniture" action="#" method="post">
	<table>
		<tr>
			<td>
				<fieldset>
					<table>
						<tr>
							<td><label for="type">Type : </label></td>
							<td><label for="typeResult">${materiel.getTypeMat()}</label></td>
						</tr>
						<tr>
							<td><label for="quantite">Quantité : </label></td>
							<td><input type="number" name="quantite" value="${materiel.getQuantite()}" /></td>
						</tr>
						<tr>
							<td><label for="marque">Marque : </label></td>
							<td><label for="marqueResult">${materiel.getMarque().getNomMarque()}</label></td>
						</tr>
						<tr>
							<td><label for="prixU">Prix unitaire : </label></td>
							<td><label for="prixUResult">${materiel.getValeurAchat()}</label></td>
						</tr>
					</table>
				</fieldset>
			</td>
			<td><label for="observation">Observation : </label> <textarea
					rows="5" cols="30" name="observation">${materiel.getObservation()}</textarea>
			</td>
		</tr>
		<tr>
			<td><input type="submit" name="valider" value="Valider" /></td>
			<td></td>
			<td></td>
			<td><input type="reset" name="annuler" value="Annuler" /></td>
		</tr>
	</table>
</form>
<c:import url="/inc/footer.inc.jsp" />