<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modifier un responsable</title>
</head>
<body>
	<h1>Modifier un responsable</h1>
	<form action="">
		<table>
			<tr>
				<td><label for="nom">Nom : </label></td>
				<td><input type="text" name="nom" required="required"
					autocomplete="off" value="ancienne valeur"/></td>
				<td><label for="prenom">Prénom : </label></td>
				<td><input type="text" name="prenom" required="required"
					autocomplete="off" value="ancienne valeur"/></td>
			</tr>
			<tr>
				<td><label for="telFixe">Téléphone fixe : </label></td>
				<td><input type="text" name="telFixe"
					pattern="[0][1-9][0-9]{8}" required="required" autocomplete="off" value="ancienne valeur"/></td>
				<td><label for="telPort">Téléphone portable : </label></td>
				<td><input type="text" name="telPort"
					pattern="[0][1-9][0-9]{8}" required="required" autocomplete="off" value="ancienne valeur"/></td>
				<td><label for="email">E-mail : </label></td>
				<td><input type="text" name="email" required="required"
					autocomplete="off" value="ancienne valeur"/></td>
			</tr>
		</table>
		<div>
			<input type="button" value="Annuler" /> <input type="button"
				value="Suivant" /> <input type="button" value="Valider" />
		</div>
	</form>
</body>
</html>