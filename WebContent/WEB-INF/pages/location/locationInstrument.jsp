<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Location d'un instrument" scope="request" />

<c:import url="/inc/head.inc.jsp" />
<script type="text/javascript" src=""></script>
<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<script src="<c:url value="/js/jquery.min.js"/>"></script>
<script
	src="<c:url value="/js/jquery-ui.min.js"/>"></script>
<script src="<c:url value="/js/datepicker.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/datepicker.css"/>" />

	<h2>Location d'instrument</h2>

	<c:choose >
		<c:when test="${empty resultat}">
			<form id="location" method="post" action="<c:url value="/location/locationInstrument"/>">
				<fieldset>
					<legend>Instrument</legend>
					<c:choose>
						<c:when test="${!empty requestScope.listeCategorie}">
							<label for="categorie">Catégorie :</label>
							<select name="categorie">
								<c:forEach items="${requestScope.listeCategorie}" var="categorie">
									<option value="<c:out value="${categorie['idCategorie']}" />"><c:out
											value="${categorie['libelleCat']}" /></option>
								</c:forEach>
							</select>
						</c:when>
						<c:otherwise>
							<p>Catégorie : <c:out value="${nomCategorie}" /></p>
						</c:otherwise>
					</c:choose>
					
					<c:choose>
						<c:when test="${!empty requestScope.listeDesignation}">
							<label for="designation">Désignation :</label>
							<select name="designation">
							<c:forEach items="${requestScope.listeDesignation}" var="designation">
								<option value="<c:out value="${designation['idDesignation']}" />"><c:out
										value="${designation['libelleDesignation']}" /></option>
							</c:forEach>
							</select>
						</c:when>
						<c:when test="${!empty requestScope.nomDesignation}">
							<p>Désignation : <c:out value="${nomDesignation}" /></p>
						</c:when>
					</c:choose>
					
				</fieldset>
				<c:if test="${!empty requestScope.listeAdherent}">
					<fieldset>
						<legend>Adhérent</legend>
						<label for="adherent">Nom :</label>
						<select name="adherent">
							<c:forEach items="${requestScope.listeAdherent}" var="adherent">
								<option value="<c:out value="${adherent['idPersonne']}" />">
									<c:out value="${adherent['nom']} ${adherent['prenom']}" />
								</option>
							</c:forEach>
						</select>
					</fieldset>
					
					<fieldset>
						<legend>Dates</legend>
						
						<label for="datedeb">Date d'emprunt :</label>
						<input class='datepicker' type="text" name="datedeb" required />
						
						<label for="datefin">Date de retour :</label>
						<input class='datepicker' type="text" name="datefin" required />
					</fieldset>
				</c:if>
				
				<input type="submit" value="Valider" />
				
			</form>
		</c:when>
		<c:otherwise>
			<p><c:out value="${resultat}"/></p>
		</c:otherwise>
	</c:choose>
	

<c:import url="/inc/footer.inc.jsp" />