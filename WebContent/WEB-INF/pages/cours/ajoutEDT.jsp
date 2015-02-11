<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.gemao.view.Pattern"%>

<c:set var="titre" value="Cours - Ajouter un emploi du temps"
	scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<!--  MODIFIER LE CSS AVEC CELUI EN LOCAL -->
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.2/themes/dot-luv/jquery-ui.css">
<script src="<c:url value="/js/emploiDuTemps.js"/>"></script>

<div id="dialog-form" title="Ajouter un cours">
	<form>
		<label for="duree">Durée</label> <select name="duree" id="duree"
			class="select ui-widget-content ui-corner-all">
			<option value="0,50">0:30</option>
			<option value="1,00">1:00</option>
			<option value="1,50">1:30</option>
			<option value="2,00">2:00</option>
		</select> <label for="cours">Cours</label> <select name="cours" id="cours"
			class="select ui-widget-content ui-corner-all">
			<option value="Français">Français</option>
			<option value="Maths">Maths</option>
		</select> <label for="professeur">Professeur</label> <select name="professeur"
			id="professeur" class="select ui-widget-content ui-corner-all">
			<option value="Mr CHAUPIN">Mr CHAUPIN</option>
			<option value="Mme INETTE">Mme INETTE</option>
		</select> <label for="salle">Salle</label> <select name="salle" id="salle"
			class="select ui-widget-content ui-corner-all">
			<option value="R46">R46</option>
			<option value="R52">R52</option>
		</select>
		<label for="couleur">Couleur</label> <select name="couleur" id="couleur"
			class="select ui-widget-content ui-corner-all">
			<option value="rgb(255, 0, 0)">Rouge</option>
			<option value="rgb(0, 128, 0)">Vert</option>
			<option value="rgb(128, 128, 128)">Gris</option>
			<option value="rgb(0, 0, 0)">Noir</option>
		</select>
		<!--<input type="submit">-->
	</form>
</div>
<h1>Ajouter un emploi de temps</h1>
<table border="1">
	<c:forEach items="${Jour}" var="jour">
		<tr>
			<th><c:out value="${jour}" /></th>
			<c:forEach var="heure" begin="8" end="18" step="1">
				<c:if test="${empty jour}">
					<th><c:out value="${heure}" />h00</th>
					<c:if test="${! (heure==18)}">
						<th><c:out value="${heure}" />h30</th>
					</c:if>
				</c:if>
				<c:if test="${! empty jour}">
					<c:if test="${(heure<18)}">
						<td id="<c:out value="${jour}" /><c:out value="${heure}" />h00"></td>
					</c:if>
					<c:if test="${(heure==18)}">
						<th></th>
					</c:if>
					<c:if test="${! (heure==18)}">
						<td id="<c:out value="${jour}" /><c:out value="${heure}" />h30"></td>
					</c:if>
				</c:if>
			</c:forEach>
		</tr>
	</c:forEach>
</table>

<c:import url="/inc/footer.inc.jsp" />