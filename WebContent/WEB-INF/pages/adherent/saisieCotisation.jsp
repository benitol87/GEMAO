<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Validation" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<h1>Saisie de la cotisation</h1>

<c:if test="${ QF == null }">
	<p class="offset">L'adhérent ne bénéficie pas du quotient familial</p>
</c:if>
<c:if test="${ QF == 'Quotient 3' }">
	<p class="offset">L'adhérent bénéficie du Quotient 3</p>
</c:if>
<c:if test="${ QF == 'Quotient 2' }">
	<p class="offset">L'adhérent bénéficie du Quotient 2</p>
</c:if>
<c:if test="${ QF == 'Quotient 1' }">
	<p class="offset">L'adhérent bénéficie du Quotient 1</p>
</c:if>

<form action="#" method="post">
	<fieldset>
		<div>
			<label for="cotisation" class='required'>Montant de la cotisation </label>
			<input type="number" name="cotisation" required="required" min="0" value="0" autocomplete="off" />
		</div>
	</fieldset>
	<fieldset class='align-center no-border'>
		<input type="button" value="Annuler" /> 
		<input type="submit" value="Valider" />
	</fieldset>
</form>


<c:import url="/inc/footer.inc.jsp" />