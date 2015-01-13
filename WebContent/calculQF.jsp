<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Calcul du Quotient Familial</title>
</head>
<body>
	<h1>Calcul du Quotient Familial</h1>
	<table>
		<tr>
			<td><label for="nbPers">Nombre de personne : </label></td>
			<td><input type="number" name="nbPers" required="required"
				autocomplete="off" /></td>
			<td><label for="nbEnf">Nombre d'enfant : </label></td>
			<td><input type="number" name="nbEnf" required="required"
				autocomplete="off" /></td>
			<td><label for="revenues">Revenus annuels : </label></td>
			<td><input type="number" namme="revenues" required="required"
				autocomplete="off" /></td>
		</tr>
	</table>
	<div>
		<input type="button" value="Annuler" /> <input type="button" value="Valider" />
	</div>
</body>
</html>