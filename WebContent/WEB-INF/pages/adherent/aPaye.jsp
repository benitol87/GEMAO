<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.gemao.view.Pattern"%>

<c:set var="titre" value="Adhérent a payé" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<h1>Adhérent a payé</h1>

<c:if test="${!confirmation}">
	<form method="post" action="#">
		<fieldset>
			<div>
				<label for="cotisation">Le montant total à payer</label>
				<input type="text" id="cotisation" name="cotisation" value="${cotisation}" disabled="disabled"/>
			</div>
			<div class="offset">
				Confirmez que la cotisation est payée.
			</div>
		</fieldset>
		
		<fieldset class='align-center no-border'>
			<a href="<c:url value="<%=Pattern.ADHERENT_LISTER%>"/>"> <input
				type="button" value="Retour" />
			</a> <input type="submit" value="Valider" />
		</fieldset>
	</form>
</c:if>
<c:if test="${confirmation}">
	<p class="offset">
	Le paiement de l'adhérent 
	<c:out value="${adherent['nom']}" />
	<c:out value="${adherent['prenom']}" />
	a bien été enregistré.
</p>
	<a class="offset" href="<c:url value="<%=Pattern.ADHERENT_LISTER%>"/>"> <input
	type="button" value="Retour" />
</a>
</c:if>
<c:import url="/inc/footer.inc.jsp" />