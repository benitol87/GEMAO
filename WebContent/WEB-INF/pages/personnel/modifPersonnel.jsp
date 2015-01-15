<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Personnel" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
	<form id="modifp" method="post" action="#">
			<h2>Modification des informations</h2>
			<table>
				<tr>
					<td>
						<label for="nom">NOM :</label>
						<label for="nomResult">${sessionScope.sessionObjectPersonnel.getNom()}</label>
					</td>
					<td>
						<label for="prenom">Prénom :</label>
						<label for="prenomResult">${sessionScope.sessionObjectPersonnel.getPrenom()}</label>
					</td>
				</tr>
				<tr>
					<td>
						<label for="email">Email :</label>
						<label for="emailResult">${sessionScope.sessionObjectPersonnel.getEmail()}</label>
					</td>
				</tr>
				<tr>
					<td>
						<label for="fixe">Téléphone fixe :</label>
						<label for="fixeResult">${sessionScope.sessionObjectPersonnel.getTelFixe()}</label>
					</td>
					<td>
						<input type="text" name="fixe" pattern="[0][0-9]{9}" />
					</td>
					<td>
						<label for="portable">Téléphone portable :</label>
						<label for="portableResult">${sessionScope.sessionObjectPersonnel.getTelPort()}</label>
					</td>
					<td>
						<input type="text" name="portable" pattern="[0][0-9]{9}" />
					</td>
				</tr>
			</table>	
			<fieldset>
				<legend>Adresse</legend>
				<table>
					<tr>
						<td>
							<label for="adresse">Adresse :</label>
							<label for="adresseResult">${sessionScope.sessionObjectPersonnel.getIdAdresse()}</label>
						</td>
					</tr>
					<tr>
						<td>
							<label for="ville">Ville :</label>
							<label for="villeResult">${sessionScope.sessionObjectPersonnel.getCommune.getNomCommune()}</label>
						</td>
					</tr>
					<tr>
						<td>
							<label for="code">Code postal :</label>
							<label for="codeResult">${sessionScope.sessionObjectPersonnel.getCommune().getCodePostal()}</label>
						</td>
					</tr>
				</table>
		</fieldset>
		<fieldset>
			<legend>Professionnel</legend>
			<table>
				<tr>
					<td>
						<label for="diplome">Diplome :</label>
						<label for="diplomeResult">${sessionScope.sessionObjectPersonnel.get }</label>
					</td>
				</tr>
				<tr>
					<td>
						<input type="button" value="+" />
						<input type="button" value="-"/>
					</td>
				</tr>
				<tr>
					<td>
						<label for="fonction">Fonction :</label>
					</td>
				</tr>
				<tr>
					<td>
						<input type="button" value="+"/>
						<input type="button" value="-" />
					</td>
				</tr>
			</table>
		</fieldset>
		<br/>
			<input type="reset" value="Annuler"/>
			<input type="submit" value="Modifier"/>
	</form>
<c:import url="/inc/footer.inc.jsp" />