<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.gemao.view.Pattern"%>

<c:set var="titre" value="Personnel" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
	<h1>Modification des informations</h1>
	<form id="modifp" method="post" action="#">
		<fieldset>
			<legend>Informations personnelles</legend>
			<div>
				<span class='text-label'>Civilité : </span> <input type="radio"
				name="civilite" value="F"
				<c:if test="${personnel.civilite['nameCourt'] == 'Mme'}"> checked="checked"</c:if> /><label
				for="civilite">Mme</label> <input type="radio" name="civilite"
				value="M"
				<c:if test="${personnel.civilite['nameCourt'] == 'M.'}"> checked="checked" </c:if> /><label
				for="civilite">M.</label>
			</div>
			<div>
				<label for="nom">Nom</label>
				<input type="text" name="nom" value="${sessionScope.personnel['nom']}"/>
			</div>
			<div>
				<label for="prenom">Prénom</label>
				<input type="text" name="prenom" value="${sessionScope.personnel['prenom']}"/>
			</div>
			<div>
				<label for="email">E-mail</label>
				<input type="email" name="email" value="${sessionScope.personnel['email']}"/>
			</div>
			<div>
				<label for="telFixe">Téléphone fixe</label>
				<input type="text" name="telFixe" value="${sessionScope.personnel['telFixe']}" pattern="[0][0-9]{9}" />
			</div>
			<div>
				<label for="telPort">Téléphone portable</label>
				<input type="text" name="telPort" value="${sessionScope.personnel['telPort']}" pattern="[0][0-9]{9}" />
			</div>
		</fieldset>
		<fieldset>
			<legend>Adresse</legend>
			<div>
				<label for="numRue">N°</label>
				<input name="numRue" type="text" value="${sessionScope.personnel.adresse.numRue}" />
			</div>
			<div>
				<label for="nomRue">Rue</label>
				<input type="text" name="nomRue" value="${sessionScope.personnel.adresse.nomRue}" />
			</div>
			<div>
				<label for="infoCompl">Complément d'adresse</label>
				<input type="text" name="infoCompl" value="${sessionScope.personnel.adresse.infoCompl}"/>
			</div>
			<div>
				<label for="ville">Commune</label>
				<input type="text" name="ville" value="${commune['nomCommune']}"/>
			</div>
			<div>
				<label for="code">Code postal</label>
				<input type="text" name="code" value="${commune['codePostal']}"/>
			</div>
		</fieldset>
		<fieldset>
			<legend>Informations professionnelles</legend>
			<input name="idContrat" type="number" hidden="true" value="${sessionScope.personnel.getContrat().getIdContrat()}"/>
			<input name="pointsAncien" type="number" hidden="true" value="${sessionScope.personnel.getPointsAncien()}"/>
			<input name="password" type="text" hidden="true" value="${sessionScope.personnel.getPassword()}"/>
			<input name="login" type="text" hidden="true" value="${sessionScope.personnel.getLogin()}"/>
					
			<div>	
				<label for="diplome">Diplôme : </label>
				<c:forEach items="${listeDiplome}" var="dipl">
					<c:out value="${dipl['nomDiplome']}" />
				</c:forEach>
				<input type="button" value="+" />
				<input type="button" value="-"/>
			</div>
			
			<div>
				<label for="fonction">Fonction : </label>
				<c:forEach items="${listeResponsabilite}" var="resp">
					<c:out value="${resp['libelle']}" />
				</c:forEach>
				<input type="button" value="+"/>
				<input type="button" value="-" />
			</div>
		</fieldset>
		<fieldset class='align-center no-border'>
			<a href="<c:url value="<%= Pattern.PERSONNEL_LISTER %>" />">
				<input type="button" value="Retour" />
			</a>
			<input type="submit" value="Modifier"/>
		</fieldset>
	</form>
<c:import url="/inc/footer.inc.jsp" />