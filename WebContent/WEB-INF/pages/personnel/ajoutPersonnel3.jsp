<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Personnel" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<h1>Ajout d'un personnel</h1>
<p>La personne suivante a été ajoutée avec succès à la liste du personnel.</p>

<label>Nom : <c:out value="${personnel['nom']}" /></label>
<br>
<label>Prénom : <c:out value="${personnel['prenom']}" /></label>
<br>
<label>Login : <c:out value="${personnel['login']}" /></label>
<br>
<label>Mot de passe : <c:out value="${personnel['password']}" /></label>
<c:import url="/inc/footer.inc.jsp" />