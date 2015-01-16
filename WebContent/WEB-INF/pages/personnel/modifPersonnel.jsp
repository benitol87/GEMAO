<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Personnel" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
	<h2>Modification des informations</h2>
	<form id="modifp" method="post" action="#">
		<table>
			<tr>
				<td>
					<label for="nom">NOM : </label>
					<c:out value="${personnel['nom']}" />
				</td>
				<td>
					<label for="prenom">Prénom : </label>
					<c:out value="${personnel['prenom']}" />
				</td>
			</tr>
			<tr>
				<td>
					<label for="email">Email :</label>
					<c:out value="${personnel['email']}" />
				</td>
				<td>
					<label for="civilite">Civilité :</label>
					<c:out value="${personnel['civilite']}" />
				</td>
			</tr>
			<tr>
				<td>
					<label for="fixe">Téléphone fixe :</label>
					<input type="number" value="${personnel['telFixe']}" pattern="[0][0-9]{9}" />
				</td>
				<td>
					<label for="fixe">Téléphone portable :</label>
					<input type="number" value="${personnel['telPort']}" pattern="[0][0-9]{9}" />
				</td>
			</tr>
		</table>	
		<fieldset>
			<legend>Adresse</legend>
			<table>
				<tr>
					<td>
						<label for="adresse">Numéro de rue :</label>
						<input type="text" value="${personnel.adresse.numRue}" />
					</td>
				</tr>
				<tr>
					<td>
						<label for="adresse">Nom de rue :</label>
						<input type="text" value="${personnel.adresse.nomRue}" />
					</td>
				</tr>
				<tr>
					<td>
						<label for="adresse">Informations complémentaires :</label>
						<input type="text" value="${personnel.adresse.infoCompl}"/>
					</td>
				</tr>
				<tr>
					<td>
						<label for="ville">Ville :</label>
						<input type="text" value="${commune['nomCommune']}"/>
					</td>
				</tr>
				<tr>
					<td>
						<label for="code">Code postal :</label>
						<label for="codeResult">${commune['codePostal']}</label>
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
						<c:forEach items="${listeDiplome}" var="dipl">
						<tr>
							<td>
								 - <c:out value="${dipl['nomDiplome']}" />
							</td>
						</tr>
						</c:forEach>
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
						<c:forEach items="${listeResponsabilite}" var="resp">
						<tr>
							<td>
								- <c:out value="${resp['libelle']}" />
							</td>
						</tr>
						</c:forEach>
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