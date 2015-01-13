<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="js/ajoutMateriel.js"
></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form id="ajouterMateriel" action="#" methode="post">
		<table>
			<tr>
				<td><label for="categorie">Catégorie : </label></td> 
				<td>
					<select name="categorie" id="categorie">
						<option value="1">Instrument</option>
						<option value="2">Mobilier</option>
					</select> 
				</td>
			
				<td><label for="designation">Désignation : </label></td> 
				<td><input type="text" name="designation" /></td>
			</tr>
			<tr>
				<td><label for="valeurAch">Valeur d'achat : </label></td>
				<td><input type="number" name="ValeurAch" /></td>
		
				<td><label for="dateAch">Date d'achat : </label></td>
				<td><input type="date" name="dateAch"/></td>
			</tr>
			<tr>
				<td><input type="submit" name="valider" value="Valider"/></td>
				<td></td><td></td>
				<td><input type="reset" name="annuler" value="Annuler" /></td>
			</tr>
		</table>
	</form>
	<form id="ajouterMaterielInstrument" action="#" methode="post" hidden>
		<table>
			<tr>
				<td>
					<fieldset >
						<legend>Instrument</legend>
						<table>
							<tr>
								<td><label for="type">Type : </label></td>
								<td><select name="Type"></select></td>
							</tr>
							<tr>
								<td><label for="etat">Etat : </label></td>
								<td><input type="text" name="etat"/></td>
							</tr>	
							<tr>
								<td><label for="marque">Marque : </label></td>
								<td><input type="text" name="marque"/></td>
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
											<label for="deplacableOui">oui</label>
											<input type="radio" name="deplacableOui"/>
											<label for="deplacableNon">non</label>
											<input type="radio" name="deplacableNon"/>
										</td>
									</tr>
								</table>
							</fieldset>
						</tr>
						<tr>
							<td><label for="observation">Observation : </label></td>
							<td><textarea rows="5" cols="50"></textarea></td>
						</tr>		
					</table>
				</td>
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
								<td><label for="quantite">Quantité : </label></td>
								<td><input type="text" name="quantite"/></td>
							</tr>	
							<tr>
								<td><label for="marque">Marque : </label></td>
								<td><input type="text" name="marque"/></td>
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
		</table>
	</form>
</body>
</html>