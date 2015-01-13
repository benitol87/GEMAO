<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Personnel" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
	<form id="modifp method="post" action="#">
			<h2>Modification des informations</h2>
			<table>
				<tr><td>
					<label for="nom">NOM:</label>
				</td><td>
					<input type="text" name="nom"/>
				</td><td>
					<label for="prenom">Prénom:</label>
				</td><td>
					<input type="text" name="prenom"/>
				</td></tr>
				<tr><td>
					<label for="email">Email:</label>
				</td><td>
					<input type="email" name="email"/>
				</td></tr>
				<tr><td>
					<label for="fixe">Téléphone fixe:</label>
				</td><td>
					<input type="text" name="fixe" pattern="[0][0-9]{9}" />
				</td><td>
					<label for="portable">Téléphone portable:</label>
				</td><td>
					<input type="text" name="portable" pattern="[0][0-9]{9}" />
				</td></tr>
			</table>	
			<fieldset>
				<legend>Adresse</legend>
				<table>
					<tr><td>
						<label for="adresse">Adresse:</label>
					</td><td>
						<input type="text" name="adresse"/>
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
					<label for="fonction">Fonction:</label>
				</td><td>
					<input type="text" name="fonction"/>
				</td></tr>
				<tr><td>
					<input type="button" value="+" action=""/>
					<input type="button" value="-" action=""/>
				</td></tr>
			</table>
		</fieldset>
		<br/>
			<input type="reset" value="Annuler"/>
			<input type="submit" value="Modifier"/>
	</form>
<c:import url="/inc/footer.inc.jsp" />