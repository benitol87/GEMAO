<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:set var="titre" value="Materiel" scope="request" />

<c:import url="/inc/head.inc.jsp" />
<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
<form id="ajouterMateriel" action="#" method="post">
	<label for="categorie">Catégorie : </label> <select name="categorie"
		id="categorie">
		<c:forEach var="cat" items="${requestScope['LISTE_CATEGORIE']}">
			<option value="${cat.getIdCategorie()}">
				${cat.getLibelleCat()}</option>
		</c:forEach>
	</select> <label for="ValeurAch">Valeur d'achat : </label> <input type="number"
		name="ValeurAch" /> <label for="dateAch">Date d'achat : </label> <input
		type="date" name="dateAch" />
	<table>
		<tr>
			<td>
				<fieldset>
					<table>
						<tr>
							<td><label for="designation">Désignation : </label></td>
							<td><select name="designation" id="designation">
									<c:forEach var="des"
										items="${requestScope['LISTE_DESIGNATION']}">
										<option value="${des.getIdDesignation()}">
											${des.getLibelleDesignation()}</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td><label for="type">Type : </label></td>
							<td><input type="text" name="type" /></td>
						</tr>
						<tr>
							<td><label for="etat">Etat : </label></td>
							<td><select name="etat" id="etat">
									<c:forEach var="etat"
										items="${requestScope['LISTE_ETAT']}">
										<option value="${etat.getIdEtat()}">
											${etat.getLibelleEtat()}</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td><label for="marque">Marque : </label></td>
							<td><select name="marque" id="marque">
									<c:forEach var="marque"
										items="${requestScope['LISTE_MARQUE']}">
										<option value="${marque.getIdMarque()}">
											${marque.getNomMarque()}</option>
									</c:forEach>
							</select></td>
						</tr>

						<tr>
							<td><label for="quantite">Quantité : </label></td>
							<td><input type="text" name="quantite" id="quantite" /></td>
						</tr>
						<tr>
							<td><label for="numSerie">Numéro de série : </label></td>
							<td><input type="text" name="numSerie" /></td>
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
										<td><input type="number" name="valRea" /></td>
									</tr>
									<tr>

										<td><label> <input type="checkbox"
												name="deplacable" value="on" /> Deplacable
										</label></td>
									</tr>
								</table>
							</fieldset>
						</td>
					</tr>
					<tr>
						<td><label for="observation">Observation : </label> <textarea
								name="observation" rows="5" cols="50"></textarea></td>
					</tr>
				</table>
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