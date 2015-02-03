<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Modification d'un adhérent" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<script src="<c:url value="/js/modifierAdherent.js"/>"></script>
<h1>Echec</h1>
<c:choose>
	<c:when test="${dejaInscrit==true}">
		<p class="offset">L'adhérent <c:out value="${adherent['nom']}" /> <c:out value="${adherent['prenom']}" /> existe déjà.</p>
	</c:when>
	<c:otherwise>
		<p class="offset">L'adhérent <c:out value="${adherent['nom']}" /> <c:out value="${adherent['prenom']}" /> n'a pas été ajouté.</p>
	</c:otherwise>
</c:choose>

<c:import url="/inc/footer.inc.jsp" />
