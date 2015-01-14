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
				<label for="designationResult">flute </label>
				</td>
			</tr>
			<tr>
				<td>
				<label for="valeurAch">Valeur d'achat : </label>
				<label for="valeurAchResult">666€ </label>
				</td>
		
				<td>
				<label for="dateAch">Date d'achat : </label>
				<label for="dateAchResult">10/10/1010 </label>
				</td>
			</tr>
		</table>
	</form>
	<form name="modifierMaterielInstrument" action="#" method="post">
		<table>
			<tr>
				<td>
					<fieldset>
						<legend>Instrument</legend>
						<table>
							<tr>
								<td><label for="type">Type : </label></td>
								<td><label for="typeResult">flute a bec</label></td>
							</tr>
							<tr>
								<!--% Etat à empêcher de s'améliorer -->
								<td><label for="etat">Etat : </label></td>
								<td><select name="etat" id="etat"></select></td>
							</tr>	
							<tr>
								<td><label for="marque">Marque : </label></td>
								<td><label for="marqueResult">toshiba</label></td>
							</tr>
							<tr>
								<td><label for="numSerie">Numéro de série : </label></td>
								<td><label for="numSerieResult">254vse</label></td>
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
												<label for="deplacableOui">oui</label>
												<input type="radio" name="title" value="Ms" checked="checked">
												<label for="deplacableNon">non</label>
												<input type="radio" name="title" value="Ms" checked="checked">
											</td>
										</tr>
									</table>
								</fieldset>
							</td>
						</tr>
						<tr>
							<td>
								<label for="observation">Observation : </label>
								<textarea rows="5" cols="30"></textarea>
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
<c:import url="/inc/footer.inc.jsp" />