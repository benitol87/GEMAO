<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
<script src="js/AjouterAdherent.js"></script>
<link rel="stylesheet" type="text/css" href="css/datepicker.css" />
<title>Ajouter un adhérent</title>
</head>
<body>
	<h1>Ajouter un adhérent</h1>
	<form action="">
		<table>
			<tr>
				<td><label for="nom">Nom : </label></td>
				<td><input type="text" name="nom" /></td>
				<td><label for="prenom">Prénom : </label></td>
				<td><input type="text" name="prenom" /></td>
				<td><label for="dateNaiss">Date de naissance : </label></td>
				<td><input type="text" name="dateNaiss" id="date" /></td>
			</tr>
			<tr>
				<td><label for="telFixe">Téléphone fixe : </label></td>
				<td><input type="text" name="telFixe" /></td>
				<td><label for="telPort">Téléphone portable : </label></td>
				<td><input type="text" name="telPort" /></td>
				<td><label for="email">E-mail : </label></td>
				<td><input type="text" name="email" /></td>
			</tr>
		</table>
		<br />

		<fieldset>
			<legend>Adresse</legend>
			<table>
				<tr>
					<td><label for="num">Numéro : </label></td>
					<td><input type="text" name="num" /></td>
				</tr>
				<tr>
					<td><label for="rue">Rue : </label></td>
					<td><input type="text" name="rue" /></td>
				</tr>
				<tr>
					<td><label for="compl">Complémentaire : </label></td>
					<td><input type="text" name="compl" /></td>
				</tr>
				<tr>
					<td><label for="codeP">Code Postal : </label></td>
					<td><input type="text" name="codeP" /></td>
				</tr>
				<tr>
					<td><label for="commune">Commune : </label></td>
					<td><input type="text" name="comunne" /></td>
				</tr>
			</table>
		</fieldset>

		<fieldset>
			<legend>Discipline</legend>
			<table>
				<tbody id="disciplines">
					<tr>
						<td><p>Discipline</p></td>
						<td><p>Classe</p></td>
					</tr>
					<tr id="1">
						<td><select size="1" name="discipline1">
								<option value="1">Test 1</option>
								<option value="2">Test 2</option>
						</select></td>
						<td><select size="1" name="classe1">
								<option value="1">Test 1</option>
								<option value="2">Test 2</option>
						</select></td>
					</tr>
				</tbody>
			</table>
			<input type="button" value="Retirer" id="retireDiscipline" /> <input
				type="button" value="Ajouter" id="ajoutDiscipline" />
		</fieldset>

		<div>
			<span>Droit à l'image : </span> <input type="radio" name="droitImOui"
				value="true" checked="checked" /> <label for="droitImOui">Oui</label>
			<input type="radio" name="droitImNon" value="false" /> <label
				for="droitImNon">Non</label>
		</div>
		<div>
			<input type="button" value="Annuler" /> <input type="button"
				value="Suivant" /> <input type="button" value="Valider" />
		</div>
	</form>
</body>
</html>