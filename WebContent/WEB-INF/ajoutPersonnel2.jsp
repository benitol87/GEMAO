<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Personnel" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
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
		<br/>
		<input type="reset" value="Annuler"/>
		<input type="submit" value="Valider"/>
	</form>
<c:import url="/inc/footer.inc.jsp" />