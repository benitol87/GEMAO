<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.gemao.view.Pattern"%>

<div class="container">
	<!-- Push Wrapper -->
	<div class="mp-pusher" id="mp-pusher">

		<!-- mp-menu -->
		<nav id="mp-menu" class="mp-menu">
			<div class="mp-level">
				<h2>GEMAO</h2>
				<ul>
					<li><a href="<c:url value="<%= Pattern.ACCUEIL %>"/>">Accueil</a></li>
					<li class="icon icon-arrow-left"><a href="#">Adhérent</a>
						<div class="mp-level">
							<h2>Adhérent</h2>
							<a class="mp-back" href="#">Retour</a>
							<ul>
								<li><a href="<c:url value="<%= Pattern.ADHERENT_AJOUT %>"/>">Créer</a></li>
								<li><a href="<c:url value="<%= Pattern.ADHERENT_LISTER %>"/>">Lister</a></li>
								<li><a href="<c:url value="<%= Pattern.ADHERENT_PARAMETRE %>"/>">Paramètres</a></li>
							</ul>
						</div>
					</li>
					<li class="icon icon-arrow-left"><a href="#">Personnel</a>
						<div class="mp-level">
							<h2>Personnel</h2>
							<a class="mp-back" href="#">Retour</a>
							<ul>
								<li><a href="<c:url value="<%= Pattern.PERSONNEL_AJOUT %>"/>">Créer</a></li>
								<li><a href="<c:url value="<%= Pattern.PERSONNEL_LISTER %>"/>">Lister</a></li>
							</ul>
						</div></li>
					<li class="icon icon-arrow-left"><a href="#">Matériel</a>
						<div class="mp-level">
							<h2>Matériel</h2>
							<a class="mp-back" href="#">Retour</a>
							<ul>
								<li><a href="<c:url value="<%= Pattern.MATERIEL_AJOUT %>"/>">Créer</a></li>
								<li><a href="<c:url value="<%= Pattern.MATERIEL_LISTER %>"/>">Lister</a></li>
							</ul>
						</div></li>
					<li class="icon icon-arrow-left"><a href="#">Location</a>
						<div class="mp-level">
							<h2>Location</h2>
							<a class="mp-back" href="#">Retour</a>
							<ul>
								<li><a href="<c:url value="<%= Pattern.LOCATION_LOCATION %>"/>">Prêt</a></li>
								<li><a href="<c:url value="<%= Pattern.LOCATION_RETOUR %>"/>">Retour</a></li>
							</ul>
						</div>
					</li>
					<li class="icon icon-arrow-left"><a href="#">Administration</a>
						<div class="mp-level">
							<h2>Administration</h2>
							<a class="mp-back" href="#">Retour</a>
							<ul>
								<li><a href="<c:url value="<%= Pattern.ADMINISTRATION_RESET_PASSWORD %>"/>">Réinit. mot de passe</a></li>
								<li class="icon icon-arrow-left"><a href="#">Profils</a>
									<div class="mp-level">
										<h2>Profils</h2>
										<a class="mp-back" href="#">Retour</a>
										<ul>
											<li><a href="<c:url value="<%= Pattern.ADMINISTRATION_AJOUT_PROFIL %>"/>">Créer</a></li>
											<li><a href="<c:url value="<%= Pattern.ADMINISTRATION_LISTER_PROFIL %>"/>">Lister</a></li>
										</ul>
									</div>
								</li>
							</ul>
						</div>
					</li>
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