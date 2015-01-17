<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<!-- Push Wrapper -->
	<div class="mp-pusher" id="mp-pusher">

		<!-- mp-menu -->
		<nav id="mp-menu" class="mp-menu">
			<div class="mp-level">
				<h2>GEMAO</h2>
				<ul>
					<li><a href="<c:url value="/"/>">Accueil</a></li>
					<li class="icon icon-arrow-left"><a href="#">Adhérent</a>
						<div class="mp-level">
							<h2>Adhérent</h2>
							<a class="mp-back" href="#">Retour</a>
							<ul>
								<li><a href="<c:url value="/adherent/AjoutAdherent"/>">Ajouter</a></li>
								<li><a href="<c:url value="/adherent/ModifierAdherent"/>">Modifier</a></li>
								<li><a href="<c:url value="/adherent/ListeAdherents"/>">Lister</a></li>
							</ul>
						</div></li>
					<li class="icon icon-arrow-left"><a href="#">Personnel</a>
						<div class="mp-level">
							<h2>Personnel</h2>
							<a class="mp-back" href="#">Retour</a>
							<ul>
								<li><a href="<c:url value="/personnel/AjoutPersonnel"/>">Ajouter</a></li>
								<li><a href="<c:url value="/personnel/ModifPersonnel"/>">Modifier</a></li>
								<li><a href="<c:url value="/personnel/ListePersonnel"/>">Lister</a></li>
							</ul>
						</div></li>
					<li class="icon icon-arrow-left"><a href="#">Matériel</a>
						<div class="mp-level">
							<h2>Matériel</h2>
							<a class="mp-back" href="#">Retour</a>
							<ul>
								<li><a href="<c:url value="/materiel/AjouterMateriel"/>">Ajouter</a></li>
								<li><a
									href="<c:url value="/materiel/ModifierMateriel"/>">Modifier</a></li>
								<li><a href="<c:url value="/materiel/ListerMateriel"/>">Lister</a></li>
							</ul>
						</div></li>
					<li class="icon icon-arrow-left"><a href="#">Location</a>
						<div class="mp-level">
							<h2>Location</h2>
							<a class="mp-back" href="#">Retour</a>
							<ul>
								<li><a href="<c:url value="/location/locationInstrument"/>">Prêt</a></li>
								<li><a href="/location/retourInstrument">Retour</a></li>
							</ul>
						</div></li>
				</ul>
			</div>
		</nav>
		<!-- /mp-menu -->

		<!-- Top Navigation -->
		<div class="block block-40 clearfix" id="boutonMenu">
			<p>
				<a href="#" id="trigger" class="menu-trigger">Menu</a>
			</p>
		</div>
		<div style="clear: both;"></div>
		<article>