<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Materiel" scope="request" />

<c:import url="/inc/head.inc.jsp" />
<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
<script src="<c:url value="/js/datepicker.js"/>"></script>
<script src="<c:url value="/js/jquery.min.js"/>"></script>
<script src="<c:url value="/js/jquery-ui.min.js"/>"></script>
<script src="<c:url value="/js/datepicker.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/datepicker.css"/>" />

<h1>Ajout d'un matériel</h1>
<form id="ajouterMateriel" action="#" method="post">
	<fieldset>
		<legend>Informations générales</legend>
		<div>
			<label for="categorie">Catégorie</label>
			 <select name="categorie" id="categorie">
				<c:forEach var="cat" items="${requestScope['LISTE_CATEGORIE']}">	
					<option value="${cat.getIdCategorie()}">${cat.getLibelleCat()}</option>
				</c:forEach>
			</select>
	
			<input type="button" name="ajoutCat" id="ajoutCat" value="Créer..." />
			<input type="text" name="nomCat" id="nomCat" class="hidden"/>
		</div>
		<c:if test="${!empty requestScope.form.erreurs['erreurCat'] }">
			<div class='align-center'><c:out value="${requestScope.form.erreurs['erreurCat']}"/></div>
		</c:if>
		
		<div>
			<label for="ValeurAch">Valeur d'achat</label> 
			<input type="text" name="ValeurAch" value="${sessionScope.INFOS['valeurAchat']}"/> 
			<span class="euro"></span>
		</div>
		
		<div>
			<label for="dateAch">Date d'achat</label> 
			<input type="text" name="dateAch" class="datepicker" value="${sessionScope.INFOS['dateAchat']}"/> 
		</div>
		
		<div>
			<label for="valRea">Valeur de réaprovisionnement</label>
			<input type="text" name="valRea" value="${sessionScope.INFOS['valeurReap']}"/> 
			<span class="euro"></span>
		</div>
		
		<div>
			<label for="fournisseur">Fournisseur</label> 
			<select name="fournisseur" id="fournisseur">
				<c:forEach var="fourn" items="${requestScope['LISTE_FOURNISSEUR']}">
					<option value="${fourn.getIdFournisseur()}">${fourn.getNomFournisseur()}</option>
				</c:forEach>
			</select>
			<input type="button" name="ajoutFour" id="ajoutFour" value="Créer..." />
			<input type="text" name="nomFour" id="nomFour" class="hidden"/>
		</div>
	</fieldset>

	<fieldset>
		<legend>Informations détaillées</legend>
		<div>
			<label for="designation">Désignation</label>
				
			<select name="designation" id="designation">
				<c:forEach var="des" items="${requestScope['LISTE_DESIGNATION']}">
					<option value="${des.getIdDesignation()}">${des.getLibelleDesignation()}</option>
				</c:forEach>
			</select>
			<input type="button" name="ajoutDes" id="ajoutDes" value="Créer..." />
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
			<input type="button" name="ajoutEtat" id="ajoutEtat" value="Créer..." />
			<input type="text" name="nomEtat" id="nomEtat" class="hidden"/>
		</div>
		
		<div>
			<label for="marque">Marque</label>
			<select name="marque" id="marque">
				<c:forEach var="marque" items="${requestScope['LISTE_MARQUE']}">
					<option value="${marque.getIdMarque()}">${marque.getNomMarque()}</option>
				</c:forEach>
			</select>
			<input type="button" name="ajoutMarque" id="ajoutMarque" value="Créer..." />
			<input type="text" name="nomMarque" id="nomMarque" class="hidden"/>
		</div>
		
		<div>
			<label for="quantite">Quantité</label>
			<input type="number" min="1" value="1" name="quantite" id="quantite" value="${sessionScope.INFOS['quantite']}"/>
		</div>
		
		<div>
			<label for="numSerie">Numéro de série</label>
			<input type="text" name="numSerie" value="${sessionScope.INFOS['numSerie']}"/>
		</div>
		
		<div>
			<label for="deplacable">Déplaçable</label>
			<input type="checkbox" name="deplacable" value="on" />
		</div>
	
		<div>
			<label>Ouvert à la location</label>
			<input type="checkbox" name="louable" value="on" />
		</div>
	</fieldset>
	
	<fieldset>
		<legend>Observations</legend>
		<div class='align-center'>
			<textarea name="observation" rows="5" cols="50" placeholder="Ajoutez ici toute information que vous jugez nécessaire de mentionner." >${sessionScope.INFOS['observation']}</textarea>
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