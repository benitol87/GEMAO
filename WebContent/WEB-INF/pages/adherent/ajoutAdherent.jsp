<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Ajout d'un adhérent" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<script src="<c:url value="/js/jquery.min.js"/>"></script>
<script src="<c:url value="/js/jquery-ui.min.js"/>"></script>
<script src="<c:url value="/js/datepicker.js"/>"></script>
<script src="<c:url value="/js/AjouterAdherent.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/datepicker.css"/>" />
<h1>Ajout d'un adhérent</h1>
<form action="#" method="post">
	<fieldset>
	<legend>Identité personnelle</legend>
		<table>
			<tr>
				<td>
					<p>Civilité :</p>
				</td>
				<td><input type="radio" name="civilite" value="M"
					checked="checked" /> <label for="civilite">M.</label> <input
					type="radio" name="civilite" value="F" /> <label for="civilite">Mme.</label></td>
			</tr>
			<tr>
				<td><label for="nom">Nom : </label></td>
				<td><input type="text" name="nom" required="required"
					autocomplete="off" /></td>
				<td><label for="prenom">Prénom : </label></td>
				<td><input type="text" name="prenom" required="required"
					autocomplete="off" /></td>
				<td><label for="dateNaiss">Date de naissance : </label></td>
				<td><input type="text" name="dateNaiss" class="datepicker"
					required="required" autocomplete="off" /></td>
			</tr>
			<tr>
				<td><label for="telFixe">Téléphone fixe : </label></td>
				<td><input type="text" name="telFixe" pattern="[0][1-9][0-9]{8}"
					required="required"  maxlength="10" autocomplete="on" /></td>
				<td><label for="telPort">Téléphone portable : </label></td>
				<td><input type="text" name="telPort" pattern="[0][1-9][0-9]{8}"
					required="required" maxlength="10" autocomplete="on" /></td>
				<td><label for="email">E-mail : </label></td>
				<td><input type="text" name="email" required="required"
					autocomplete="on" /></td>
			</tr>
			<tr>
				<td><label for="comNaiss">Commune de naissance : </label></td>
				<td><input type="text" name="comNaiss" required="required"
					autocomplete="off" /></td>
				<td><label for="codePNaiss">Code Postal : </label></td>
				<td><input type="text" name="codePostNaiss" required="required" maxlength="5"
					autocomplete="off" /></td>
			</tr>
		</table>
	</fieldset>
	<fieldset>
	<legend>Adresse</legend>
		<table>
			<tr>
				<td><label for="num">Numéro : </label></td>
				<td><input type="text" name="num" required="required"
					pattern="\d*" autocomplete="off" /></td>
				<td><label for="rue">Rue : </label></td>
				<td><input type="text" name="rue" required="required"
					autocomplete="off" /></td>
				<td><label for="compl">Complémentaire : </label></td>
				<td><input type="text" name="compl" autocomplete="off" /></td>
			</tr>
			<tr>
				<td><label for="commune">Commune : </label></td>
				<td><input type="text" name="commune" required="required"
					autocomplete="off" /></td>
				<td><label for="codePostal">Code Postal : </label></td>
				<td><input type="text" name="codePostal" required="required" maxlength="5"
					autocomplete="off" /></td>
			</tr>
		</table>
	</fieldset>
	<fieldset>
	<legend>Disciplines</legend>
		<table>
			<tr>
				<td>
					<table>
						<tbody id="disciplines">
							<tr>
								<th><p>Disciplines</p></th>
							</tr>
							<tr>
								<td>Discipline</td>
								<td>Classe</td>
							</tr>
							<tr id="1">
								<td><select size="1" name="dis1">
									<c:forEach var="discipline" items="${sessionScope.listDiscipline }">
										<option value="${ discipline.getIdDiscipline() }">${ discipline.getNom() }</option>
									</c:forEach>		
								</select></td>
								<td><select size="1" name="clas1">
										<option value="1">Test 1</option>
										<option value="2">Test 2</option>
								</select></td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
			<tr>
				<td><input type="button" value="Retirer" id="retireDiscipline" />
					<input type="button" value="Ajouter" id="ajoutDiscipline" /></td>
			</tr>
		</table>
	</fieldset>
	<table>
		<tr>
			<td><label for="dateInscri">Date d'inscripton : </label></td>
			<td><input type="text" name="dateInscri" class="datepicker"
				required="required" autocomplete="off" /></td>
		</tr>
		<tr>
			<td>
				<span>Droit à l'image :</span> <input type="radio" name="droitImage"
				value="true" checked="checked" /> <label for="droitImage">Oui</label>
				<input type="radio" name="droitImage" value="false" /> <label
				for="droitImage">Non</label>
			</td>
		</tr>
	</table>
	<div>
		<input type="button" value="Annuler" /> <input type="submit"
			value="Suivant" />
	</div>
</form>
<c:import url="/inc/footer.inc.jsp" />
