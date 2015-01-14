<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Matériel" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
	<form id="retour" method="post" action="#">
			<h2>Retour d'un instrument</h2>	
		<fieldset>
			<legend>Instrument</legend>
			<label for="categorie">Catégorie :</label>
			<label for="categorieResult">Cuivre</label>
			<br/><br/>
			<label for="designation">Désignation :</label>
			<label for="designationResult">Trompette01 :</label>
			<br/><br/>
			<label for="etat">Etat :</label>
			<label for="etatResult">Neuf</label>
		</fieldset>
		<fieldset>
			<legend>Adhérent</legend>
			<label for="adherentNom">Nom :</label>
			<label for="adherentNomResult">Chirac</label>
			<br/><br/>
			<label for="adherentPrenom">Prenom :</label>
			<label for="adherentPrenomResult">Patrick</label>
			<br/><br/>
			<label for="reparation">Réparation : </label>
			<label for="reparationOui"> 
			<input type="radio" checked="checked" name="reparation" value="oui"/> oui</label>
			<label for="reparationNon"> 
			<input type="radio" checked="checked" name="reparation" value="non"/> non</label>
		</fieldset>
		<br/><br/>
		<label for="datedeb">Date d'emprunt :</label>
		<label for="datedebResult">01/02/2003</label>
		<br/>
		<label for="datefin">Date de retour :</label>
		<label for="datefinResult">01/02/2004</label>
		<br/>
		<label for="dateRetourEffectif">Date de retour effectif :</label>
		<label for="dateRetourEffectifResult">02/02/2004</label>
		<br/><br/>
		<input type="reset" value="Annuler"/>
		<input type="submit" value="Valider"/>
	</form>

<c:import url="/inc/footer.inc.jsp" />