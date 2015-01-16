<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Personnel" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
<script src=<c:url value="/js/jquery.min.js"/>"></script>
<script
	src=<c:url value="/js/jquery-ui.min.js"/>"></script>
<script src="<c:url value="/js/datepicker.js"/>"></script>
<script src=<c:url value="/js/AjouterPersonnel.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/datepicker.css"/>" />
	<!-- 1er partie du formulaire -->
	<h1>Ajout d'un personnel</h1>
	<form id="ajoutp1" method="post" action="<c:url value="/personnel/AjoutPersonnel" />">
		<table>
		<tr><td><input type="radio" name="civilite" value="Madame" checked>Madame</td>
			<td><input type="radio" name="civilite" value="Monsieur">Monsieur</td>
		</tr>
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
					<input type="text" name="date" class="datepicker" required/>
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
					<label for="numRue">*N°:</label>
				</td><td>
					<input type="text" name="numRue" size="2" required/>
				</td></tr>
				<tr><td>
					<label for="nomRue">*Nom:</label>
				</td><td>
					<input type="text" name="nomRue" required/>
				</td></tr>
				<tr><td>
					<label for="infoComplem">Complément :</label>
				</td><td>
					<input type="text" name="infoComplem" />
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
			<tbody id="diplomes">
				<tr>
					<td><label for="diplome">Diplome:</label></td>
					<td><input type="text" name="diplome" /></td>
				</tr>
			</tbody>
		</table>
		<div>
				<input type="button" value="+" id="ajoutDiplome"/>
				<input type="button" value="-" id="retireDiplome"/>
			</div>
			<table>
				<tbody id="diplomes">
				<label for="fonction">*Fonction:</label>
				</td><td>
				<input type="text" name="fonction1" required />
				</td></tr>
				<tr><td>
				<input type="button" value="+" id="ajoutDiplome"/>
				<input type="button" value="-" id="retireDiplome"/>
				</td></tr>
				</tbody>
			</table>
		</fieldset></p>
		<br/>
			<input type="reset" value="Annuler"/>
			<input type="submit" value="Valider"/>
	</form>
	
	
<c:import url="/inc/footer.inc.jsp" />