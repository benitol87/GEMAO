<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter un adh�rent</title>
</head>
<body>
	<h1>Ajouter un adh�rent</h1>
	<form action="">
		<table>
			<tr>
				<td><label for="nom">Nom : </label></td>
				<td><input type="text" name="nom" /></td>
				<td><label for="prenom">Pr�nom : </label></td>
				<td><input type="text" name="prenom" /></td>
				<td><label for="dateNaiss">Date de naissance : </label></td>
				<td><input type="text" name="dateNaiss" /></td>
			</tr>
			<tr>
				<td><label for="telFixe">T�l�phone fixe : </label></td>
				<td><input type="text" name="telFixe" /></td>
				<td><label for="telPort">T�l�phone portable : </label></td>
				<td><input type="text" name="telPort" /></td>
				<td><label for="email">E-mail : </label></td>
				<td><input type="email" name="email" /></td>
			</tr>
		</table>
		<br />
		<table>
			<tr>
				<td>
					<fieldset>
						<legend>Adresse</legend>
						<table>
							<tr>
								<td><label for="num">Num�ro : </label></td>
								<td><input type="text" name="num" /></td>
							</tr>
							<tr>
								<td><label for="rue">Rue : </label></td>
								<td><input type="text" name="rue" /></td>
							</tr>
							<tr>
								<td><label for="compl">Compl�mentaire : </label></td>
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
				</td>
				<td>
					<fieldset>
						<legend>Discipline</legend>
					</fieldset>
				</td>
			</tr>
		</table>
		<div>
			<span>Droit � l'image : </span> <input type="radio" name="droitImOui"
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