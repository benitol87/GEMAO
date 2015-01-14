<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Materiel" scope="request" />

<c:import url="/inc/head.inc.jsp" />
<script type="text/javascript" src="js/ajoutMateriel.js"
></script>
<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
	<form id="ajouterMateriel" action="#" method="post">
		<label for="categorie">Catégorie : </label>
			<select name="categorie" id="categorie">
				<option value="1">Instrument</option>
				<option value="2">Mobilier</option>
				<option value="3">Fourniture</option>
			</select> 
				
		<label for="valeurAch">Valeur d'achat : </label>
		<input type="number" name="ValeurAch" />
		
		<label for="dateAch">Date d'achat : </label>
		<input type="date" name="dateAch"/>
	</form>
	<form id="ajouterMaterielInstrument" action="#" methode="post" hidden>
		<table>
			<tr>
				<td>
					<fieldset>
						<legend>Instrument</legend>
						<table>
							<tr>
								<td><label for="type">Type : </label></td>
								<td><select name="Type"></select></td>
							</tr>
							<tr>
								<td><label for="designation">Désignation : </label></td> 
								<td><select name="designation" id="designation"></select></td>
							</tr>
							<tr>
								<td><label for="etat">Etat : </label></td>
								<td><select name="etat" id="etat"></select></td>
							</tr>	
							<tr>
								<td><label for="marque">Marque : </label></td>
								<td><select name="marque" id="marque"></select></td>
							</tr>
							<tr>
								<td><label for="numSerie">Numéro de série : </label></td>
								<td><input type="text" name="numSerie"/></td>
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
											<td><label for="valRea">Valeur de réaprovisionnement : </label></td>
											<td><input type="number" name="valRea"/></td>
										</tr>
										<tr>
											<td><label for="deplacable">Déplaçable : </label></td>
											<td>
												<label for="deplacableOui"> <input type="radio" 
												checked="checked" name="deplace" value="oui"/> oui</label>
												<label for="deplacableNon"> <input type="radio" 
												checked="checked" name="deplace" value="non"/> non</label>
											</td>
										</tr>
									</table>
								</fieldset>
							</td>
						</tr>
						<tr>
							<td>
								<label for="observation">Observation : </label>
								<textarea rows="5" cols="50"></textarea>
							</td>
						</tr>		
					</table>
				</td>
			</tr>
			<tr>
				<td><input type="submit" name="valider" value="Valider"/></td>
				<td></td><td></td>
				<td><input type="reset" name="annuler" value="Annuler" /></td>
			</tr>
		</table>
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
								<td><select name="Type"></select></td>
							</tr>
							<tr>
								<td><label for="designation">Désignation : </label></td> 
								<td><select name="designation" id="designation"></select></td>
							</tr>
							<tr>
								<td><label for="quantite">Quantité : </label></td>
								<td><input type="text" name="quantite"/></td>
							</tr>	
							<tr>
								<td><label for="marque">Marque : </label></td>
								<td><select name="marque" id="marque"></select></td>
							</tr>
							<tr>
								<td><label for="prixU">Prix unitaire : </label></td>
								<td><input type="text" name="prixU"/></td>
							</tr>
						</table>
					</fieldset>
				</td>
				<td>
					<label for="observation">Observation : </label>
					<textarea rows="5" cols="50"></textarea>
				</td>
			</tr>
			<tr>
				<td><input type="submit" name="valider" value="Valider"/></td>
				<td></td><td></td>
				<td><input type="reset" name="annuler" value="Annuler" /></td>
			</tr>
		</table>
	</form>
	<form id="ajouterMaterielFourniture" action="#" methode="post" hidden>
		<table>
			<tr>
				<td>
					<fieldset >
						<legend>Fourniture</legend>
						<table>
							<tr>
								<td><label for="type">Type : </label></td>
								<td><select name="Type"></select></td>
							</tr>
							<tr>
								<td><label for="designation">Désignation : </label></td> 
								<td><select name="designation" id="designation"></select></td>
							</tr>
							<tr>
								<td><label for="quantite">Quantité : </label></td>
								<td><input type="text" name="quantite"/></td>
							</tr>	
							<tr>
								<td><label for="marque">Marque : </label></td>
								<td><select name="marque" id="marque"></select></td>
							</tr>
							<tr>
								<td><label for="prixU">Prix unitaire : </label></td>
								<td><input type="text" name="prixU"/></td>
							</tr>
						</table>
					</fieldset>
				</td>
				<td>
					<label for="observation">Observation : </label>
					<textarea rows="5" cols="50"></textarea>
				</td>
			</tr>
			<tr>
				<td><input type="submit" name="valider" value="Valider"/></td>
				<td></td><td></td>
				<td><input type="reset" name="annuler" value="Annuler" /></td>
			</tr>
		</table>
	</form>
	
<c:import url="/inc/footer.inc.jsp" />