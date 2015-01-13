<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modifier un adhérent</title>
<script>
	
</script>
</head>
<body>
	<h1>Modifier un adhérent</h1>
	<form action="">
		<table>
			<tr>
				<td><label for="nom">Nom : </label></td>
				<td><p>NOM ICI</p></td>
				<td><label for="prenom">Prénom : </label></td>
				<td><p>PRENOM ICI</p></td>
				<td><label for="dateNaiss">Date de naissance : </label></td>
				<td><p>DATE DE NAISSANCE ICI</p></td>
			</tr>
			<tr>
				<td><label for="telFixe">Téléphone fixe : </label></td>
				<td><input type="text" name="telFixe"
					pattern="[0][1-9][0-9]{8}" required="required" autocomplete="off"
					value="ancienne valeur" /></td>
				<td><label for="telPort">Téléphone portable : </label></td>
				<td><input type="text" name="telPort"
					pattern="[0][1-9][0-9]{8}" required="required" autocomplete="off"
					value="ancienne valeur" /></td>
				<td><label for="email">E-mail : </label></td>
				<td><input type="text" name="email" required="required"
					autocomplete="off" value="ancienne valeur" /></td>
			</tr>
		</table>
		<br />

		<fieldset>
			<legend>Adresse</legend>
			<table>
				<tr>
					<td><label for="num">Numéro : </label></td>
					<td><input type="text" name="num" required="required"
						autocomplete="off" value="ancienne valeur" /></td>
				</tr>
				<tr>
					<td><label for="rue">Rue : </label></td>
					<td><input type="text" name="rue" required="required"
						autocomplete="off" value="ancienne valeur" /></td>
				</tr>
				<tr>
					<td><label for="compl">Complémentaire : </label></td>
					<td><input type="text" name="compl" autocomplete="off"
						value="ancienne valeur" /></td>
				</tr>
				<tr>
					<td><label for="codeP">Code Postal : </label></td>
					<td><input type="text" name="codeP" required="required"
						autocomplete="off" value="ancienne valeur" /></td>
				</tr>
				<tr>
					<td><label for="commune">Commune : </label></td>
					<td><input type="text" name="comunne" required="required"
						autocomplete="off" value="ancienne valeur" /></td>
				</tr>
			</table>
		</fieldset>
		<div>
			<span>Droit à l'image : </span> <input type="radio" name="droitImOui"
				value="true" checked="checked" /> <label for="droitImOui">Oui</label>
			<input type="radio" name="droitImNon" value="false" /> <label
				for="droitImNon">Non</label>
		</div>
		<div>
			<input type="button" value="Annuler" /> <input type="button"
				value="Valider" />
		</div>
	</form>
</body>
</html>