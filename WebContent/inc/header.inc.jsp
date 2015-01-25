<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<header>
		<span>${sessionScope.sessionObjectPersonnel.prenom} ${sessionScope.sessionObjectPersonnel.nom}</span>
		<a href="<c:url value="/Deconnexion"/>" id="disconnect">Déconnexion</a>
		<a class="icon icon-settings" title="Paramètres" href="<c:url value="/Configuration"/>"></a>
		
	</header>