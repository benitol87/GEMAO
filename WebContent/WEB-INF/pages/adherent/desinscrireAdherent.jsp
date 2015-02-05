<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.gemao.view.Pattern"%>

<c:set var="titre" value="Désinscription d'un adhérent" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<script src="<c:url value="/js/desinscrireAdherent.js"/>"></script>

<h1>Désinscription d'un adhérent</h1>

<form action="#" method="post" id="desinscrire">
	<fieldset>
		<div>
			<label for="dateSortie" class="required">Date de sortie : </label>
			<input type="text" name="dateSortie" id="dateSortie" class="datepicker" required="required" />
		</div>
		<div id="motifsSortie">	
			<label for="motifSortie" class="required">Motif de sortie : </label>
			<select name="motifSortie" required="required">
				<c:forEach var="motif" items="${requestScope.listMotifSortie}">
					<option value="${motif.getIdMotif()}">${motif.getLibelle()}</option>
				</c:forEach>
			</select>
			<input type="button" value="+" id="ajoutMotif" title="Ajouter" />
			<input type="text" name="libelleMotif" id="libelleMotif" class="hidden"/>
		</div>
	</fieldset>
	
	<fieldset class='align-center no-border'>
		<a href="<c:url value="<%=Pattern.ADHERENT_LISTER%>"/>"> <input
			type="button" value="Retour" />
		</a>
		<input type="submit" value="Valider" id="valider"/>
	</fieldset>
</form>

<c:import url="/inc/footer.inc.jsp" />