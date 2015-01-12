<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<!-- 1er partie du formulaire -->
	<form id="ajoutp1" method="post" action="#">
		<table>
			<tr><td>
					<label for="nom">*NOM:</label>
				</td><td>
					<input type="text" name="nom" required/>
				</td><td>
					<label for="prenom">*Prénom:</label>
				</td><td>
					<input type="text" name="prenom" required/>
				</td>
			</tr><tr>
				<td>
					<label for="date">*Date de naissance:</label>
				</td><td>
					<input type="date" name="date" required/>
				</td><td>
					<label for="email">*Adresse Email:</label>
				</td><td>
					<input type="email" name="email" required/>
				</td>
			</tr><tr>
				<td>
					<label for="fixe">Téléphone fixe:</label>
				</td><td>
					<input type="text" name="fixe" pattern="[0][0-9]{9}" />
				</td><td>
					<label for="portable">Téléphone portable:</label>
				</td><td>
					<input type="text" name="portable" pattern="[0][0-9]{9}" />
				</td></tr>
		</table>
		<p>
		<fieldset>
			<legend>Adresse</legend>
			<table>
				<tr><td>
					<label for="adresse">*Adresse:</label>
				</td><td>
					<input type="text" name="adresse" required/>
				</td></tr>
				<tr><td>
					<label for="ville">Ville:</label>
				</td><td>
					<input type="text" name="ville" />
				</td></tr>
				<tr><td>
					<label for="code">Code postal:</label>
				</td><td>
					<input type="text" name="code" />
				</td></tr>
			</table>
		</fieldset>
		<fieldset>
			<legend>Professionnel</legend>
			<table>
				<tr><td>
				<label for="diplome">Diplome:</label>
				</td><td>
				<input type="text" name="diplome" />
				</td></tr>
				<tr><td>
				<input type="button" value="+" action=""/>
				<input type="button" value="-" action=""/>
				</td></tr>
				<tr><td>
				<label for="fonction">*Fonction:</label>
				</td><td>
				<input type="text" name="fonction" required />
				</td></tr>
				<tr><td>
				<input type="button" value="+" action=""/>
				<input type="button" value="-" action=""/>
				</td></tr>
			</table>
		</fieldset></p>
		<br/>
			<input type="reset" value="Annuler"/>
			<input type="submit" value="Valider"/>
	</form>
	
	<!-- 2eme partie du formulaire -->
	<form id="ajoutp2" method="post" action="#">
		<table>
			<tr><td>
				<label for="nom">NOM:</label>
			</td><td>
				<input type="text" name="nom"/>
			</td></td>
			</td><td>
				<label for="prenom">Prénom:</label>
			</td><td>
				<input type="text" name="prenom"/>
			</td></tr>
			<tr><td>
				<label for="type">Type de contrat:</label>
			</td><td>
				<select name="type">
					<option>CDD</option>
					<option>CDI</option>
					<option>CTT</option>
					<option>Bénévolat</option>
				</select>
			</td></tr>
			<tr><td>
				<label for="datedeb">Date de début:</label>
			</td><td>
				<input type="date" name="datedeb"/>
			</td></tr>
			<tr><td>
				<label for="duree">Durée:</label>
			</td><td>
				<input type="text" name="duree" size="2"/> mois
			</td></tr>
			<tr><td>
				<label for="datefin">Date de fin:</label>
			</td><td>
				<input type="date" name="datefin"/>
			</td></tr>
		</table>
		<input type="reset" value="Annuler"/>
		<input type="submit" value="Valider"/>
	</form>
</body>
</html>