<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Paramètres" scope="request" />

<c:import url="/inc/head.inc.jsp" />
<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<h2>Paramètres</h2>
<form  action="#" id="formParametre" method="post">
	<fieldset>
		<legend>Allocations familiales</legend>
		<label for="alloc2">2 enfants : </label>
		<input type="text" id="alloc2" name="alloc2" required="required" pattern="[0-9]*,[0-9]*">
		<span>${form.erreurs['alloc2']}</span>
		<br>
		<label for="alloc3">3 enfants : </label>
		<input type="text" id="alloc3" name="alloc3" required="required" pattern="[0-9]*,[0-9]*">
		<span>${form.erreurs['alloc3']}</span>
		<br>
		<label for="alloc4">4 enfants : </label>
		<input type="text" id="alloc4" name="alloc4" required="required" pattern="[0-9]*,[0-9]*">
		<span>${form.erreurs['alloc4']}</span>
		<br>
		<label for="alloc5">5 enfants et + : </label>
		<input type="text" id="alloc5" name="alloc5" required="required" pattern="[0-9]*,[0-9]*">
		<span>${form.erreurs['alloc5']}</span>  
	</fieldset>
	<br>
	<fieldset>
		<legend>Quotient familial</legend>
		<label for="qMin">Quotient minimal</label>
		<input type="text" id="qfMin" name="qfMin" required="required" pattern="[0-9]*,[0-9]*">
		<span>${form.erreurs['qfMin']}</span>
		<br>
		<label for="qMax">Quotient maximal</label>
		<input type="text" id="qfMax" name="qfMax" required="required" pattern="[0-9]*,[0-9]*">
		<span>${form.erreurs['qfMax']}</span>
	</fieldset>
	<br>
	<input type="submit" value="Modifier">
</form>
<p>${form.erreurs['Parametre']}</p>


<c:import url="/inc/footer.inc.jsp" />