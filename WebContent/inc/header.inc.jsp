<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>
<header>
	<span>${sessionScope.sessionObjectPersonnel.prenom} ${sessionScope.sessionObjectPersonnel.nom}</span>
	<a class="icon icon-settings" href="/GEMAO/Connexion"></a>
	<a href="/GEMAO/Deconnexion">Déconnexion</a>
</header>