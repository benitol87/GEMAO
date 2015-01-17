<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:set var="titre" value="Materiel" scope="request" />

<c:import url="/inc/head.inc.jsp" />
<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
<form id="ajouterMateriel" action="#" method="post">
	<fieldset>
		<div>
			<label for="categorie">Catégorie</label>
			 <select name="categorie" id="categorie">
				<c:forEach var="cat" items="${requestScope['LISTE_CATEGORIE']}">	
					<option value="${cat.getIdCategorie()}">${cat.getLibelleCat()}</option>
				</c:forEach>
			</select>
	
			<input type="button" name="ajoutCat" id="ajoutCat" value="+" />
			<input type="text" name="nomCat" id="nomCat" class="hidden"/>
		</div>
		<div>
			<label for="ValeurAch">Valeur d'achat</label> 
			<input type="text" name="ValeurAch" value="${sessionScope.INFOS['valeurAchat']}"/> 
		</div>
		<div>
			<label for="dateAch">Date d'achat</label> 
			<input type="date" name="dateAch" class="datePicker" value="${sessionScope.INFOS['dateAchat']}"/> 
		</div>
		<div>
			<label for="fournisseur">Fournisseur</label> 
			<select name="fournisseur" id="fournisseur">
				<c:forEach var="fourn" items="${requestScope['LISTE_FOURNISSEUR']}">
					<option value="${fourn.getIdFournisseur()}">${fourn.getNomFournisseur()}</option>
				</c:forEach>
			</select>
			<input type="button" name="ajoutFour" id="ajoutFour" value="+" />
			<input type="text" name="nomFour" id="nomFour" class="hidden"/>
		</div>
	</fieldset>

	<fieldset>
		<div>
			<label for="designation">Désignation</label>
				
			<select name="designation" id="designation">
				<c:forEach var="des" items="${requestScope['LISTE_DESIGNATION']}">
					<option value="${des.getIdDesignation()}">${des.getLibelleDesignation()}</option>
				</c:forEach>
			</select>
			<input type="button" name="ajoutDes" id="ajoutDes" value="+" />
			<input type="text" name="nomDes" id="nomDes" class="hidden"/>
		</div>
		
		<div>
			<label for="type">Type</label>
			<input type="text" name="type" value="${sessionScope.INFOS['typeMat']}"/>
		</div>
		
		<div>
			<label for="etat">Etat</label>
			<select name="etat" id="etat">
				<c:forEach var="etat" items="${requestScope['LISTE_ETAT']}">
					<option value="${etat.getIdEtat()}">${etat.getLibelleEtat()}</option>
				</c:forEach>
			</select>
			<input type="button" name="ajoutEtat" id="ajoutEtat" value="+" />
			<input type="text" name="nomEtat" id="nomEtat" class="hidden"/>
		</div>
		<div>
			<label for="marque">Marque</label>
			<select name="marque" id="marque">
				<c:forEach var="marque" items="${requestScope['LISTE_MARQUE']}">
					<option value="${marque.getIdMarque()}">${marque.getNomMarque()}</option>
				</c:forEach>
			</select>
			<input type="button" name="ajoutMarque" id="ajoutMarque" value="+" />
			<input type="text" name="nomMarque" id="nomMarque" class="hidden"/>
		</div>
		<div>
			<label for="situation">Situation</label>
			<select name="situation" id="situation">
			</select>
		</div>
		<div>
			<label for="quantite">Quantité</label>
			<input type="text" name="quantite" id="quantite" value="${sessionScope.INFOS['quantite']}"/>
		</div>
		<div>
			<label for="numSerie">Numéro de série</label>
			<input type="text" name="numSerie" value="${sessionScope.INFOS['numSerie']}"/>
		</div>
		<div>
			<label for="deplacable">Déplaçable</label>
			<input type="checkbox" name="deplacable" value="on" />
		</div>
	</fieldset>
		
	<fieldset>
		<legend>Ouvert à la location</legend>
		<div>
			<label for="valRea">Valeur de réaprovisionnement : </label>
			<input type="text" name="valRea" value="${sessionScope.INFOS['valeurReap']}"/>
		</div>
		<div>
			<label>Louable :</label>
			<input type="checkbox" name="louable" value="on" />
		</div>
	</fieldset>
	<fieldset class='align-center'>
		<label for="observation">Observation : </label>
		<div>
			<textarea name="observation" rows="5" cols="50" >${sessionScope.INFOS['observation']}</textarea>
		</div>
	</fieldset>
	<fieldset class='align-center no-border'>
		<div>
			<input type="submit" name="valider" value="Valider" />
		</div>
	</fieldset>
</form>
<script src="<c:url value="/js/ajouterMateriel.js"/>" ></script>
<c:import url="/inc/footer.inc.jsp" />
