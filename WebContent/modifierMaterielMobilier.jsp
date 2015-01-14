<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Materiel" scope="request" />

<c:import url="/inc/head.inc.jsp" />
<script type="text/javascript" src="js/ajoutMateriel.js"
></script>
<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

	<form name="modifierMaterielInstrument" action="#" method="post">
		<table>
			<tr>
				<td>
				<label for="categorie">Catégorie : </label> 
				<label for="categorieResult">Instrument</label>
				</td>
			
				<td>
				<label for="designation">Désignation : </label>
				<label for="designationResult">Chaise </label>
				</td>
			</tr>
			<tr>
				<td>
				<label for="valeurAch">Valeur d'achat : </label>
				<label for="valeurAchResult">42€ </label>
				</td>
		
				<td>
				<label for="dateAch">Date d'achat : </label>
				<label for="dateAchResult">10/10/1010 </label>
				</td>
			</tr>
		</form>
		<form id="ajouterMaterielMobilier" action="#" methode="post" hidden>
		<table>
			<tr>
				<td>
					<fieldset >
						<legend>Mobilier</legend>
						<table>
							<tr>
								<td><label for="type">Type : </label></td>
								<td><label for="typeResult">chaise</label></td>
							</tr>
							<tr>
								<td><label for="quantite">Quantité : </label></td>
								<td><input type="text" name="quantite"/></td>
							</tr>	
							<tr>
								<td><label for="marque">Marque : </label></td>
								<td><label for="marqueResult">Ikea</label></td>
							</tr>
							<tr>
								<td><label for="prixU">Prix unitaire : </label></td>
								<td><label for="prixUResult">12€</label></td>
							</tr>
						</table>
					</fieldset>
				</td>
				<td>
					<label for="observation">Observation : </label>
					<textarea rows="5" cols="30"></textarea>
				</td>
			</tr>
			<tr>
				<td><input type="submit" name="valider" value="Valider"/></td>
				<td></td><td></td>
				<td><input type="reset" name="annuler" value="Annuler" /></td>
			</tr>
		</table>
	</form>

</body>
</html>