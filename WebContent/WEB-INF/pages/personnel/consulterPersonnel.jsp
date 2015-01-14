<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Personnel" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
	<h1>Consultation d'un personnel</h1>
	<table>
		<tr><td>
			<label for="nom">NOM : </label>
		</td><td>
				<c:out value="${personnel['nom']}" />
		</td><td>
			<label for="prenom">Prénom : </label>
		</td><td>
				<c:out value="${personnel['prenom']}" />
		</td></tr>
		<tr><td>
			<label for="email">Email : </label>
		</td><td>
				<c:out value="${personnel['email']}" />
		</td></tr>
		<tr><td>
			<label for="fixe">Téléphone fixe : </label>
		</td><td>
			<c:out value="${personnel['telFixe']}" />
		</td><td>
			<label for="portable">Téléphone portable : </label>
		</td><td>
			<c:out value="${personnel['telPort']}" />
		</td></tr>
	</table>
	<fieldset>
		<legend>Adresse</legend>
		<table>
			<tr><td>
				<label for="adresse">Adresse: </label>
			</td><td>
				
			</td></tr>
			<tr><td>
				<label for="ville">Ville:</label>
			</td><td>
				
			</td></tr>
			<tr><td>
				<label for="code">Code postal:</label>
			</td><td>
			
			</td></tr>
		</table>
	</fieldset>
	<fieldset>
		<legend>Professionnel</legend>
		<table>
			<tr><td>
				<label for="diplome">Diplome:</label>
			</td><td>
				
			</td></tr>
			<tr><td>
				<label for="fonction">Fonction:</label>
			</td><td>
	
			</td></tr>
		</table>
	</fieldset>
	<div>
		<a href="ListeAdherents"><input type="button" value="Retour" /></a> <input type="button"
			value="Modifier" />
	</div>
<c:import url="/inc/footer.inc.jsp" />