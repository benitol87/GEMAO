<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Materiel" scope="request" />

<c:import url="/inc/head.inc.jsp" />
<script type="text/javascript" src=""
></script>
<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
	<form id="location" method="post" action="#">
		<h2>Location d'instrument</h2>
		<label for="categorie">Catégorie :</label>
		<select name="categorie">
			<option>Cuivre</option>
			<option>Bois</option>
			<option>Corde</option>
			<option>Percution</option>
		</select>
		
		<label for="souscat">Sous catégorie :</label>
		<select name="souscat">
		
		</select>
		
		<label for="designation">Désignation :</label>
		<select name="designation">
		
		</select>
		<br/><br/>
		<label for="adherent">Adhérent :</label>
		<select name="adherent">
		
		</select>
		<br/><br/>
		<label for="datedeb">Date d'emprunt :</label>
		<input type="date" name="datedeb" required/>
		
		<label for="datefin">Date de retour :</label>
		<input type="date" name="datefin" required/>
	</form>
	
<c:import url="/inc/footer.inc.jsp" />