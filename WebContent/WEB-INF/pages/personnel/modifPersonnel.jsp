<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Personnel" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
	<h1>Modification des informations</h1>
	<form id="modifp" method="post" action="#">
		<fieldset>
		<legend>Informations personnelles</legend>
		<table>
			<tr>
				<td>
					<label for="nom">Nom : </label>
					<c:out value="${sessionScope.personnel['nom']}" />
				</td>
				<td>
					<label for="prenom">Prénom : </label>
					<c:out value="${sessionScope.personnel['prenom']}" />
				</td>
			</tr>
			<tr>
				<td>
					<label for="email">E-mail : </label>
					<input type="email" name="email" value="${sessionScope.personnel['email']}"/>
				</td>
				<td>
					<label for="civilite">Civilité : </label>
					<c:out value="${sessionScope.personnel['civilite']}" />
				</td>
			</tr>
			<tr>
				<td>
					<label for="telFixe">Téléphone fixe : </label>
					<input type="text" name="telFixe" value="${sessionScope.personnel['telFixe']}" pattern="[0][0-9]{9}" />
				</td>
				<td>
					<label for="telPort">Téléphone portable : </label>
					<input type="text" name="telPort" value="${sessionScope.personnel['telPort']}" pattern="[0][0-9]{9}" />
				</td>
			</tr>
		</table>	
		</fieldset>
		<fieldset>
			<legend>Adresse</legend>
			<table>
				<tr>
					<td>
						<label for="numRue">N° : </label>
					</td>
					<td>
						<input name="numRue" type="text" value="${sessionScope.personnel.adresse.numRue}" />
					</td>
				</tr>
				<tr>
					<td>
						<label for="nomRue">Rue : </label>
					</td>
					<td>
						<input type="text" name="nomRue" value="${sessionScope.personnel.adresse.nomRue}" />
					</td>
				</tr>
				<tr>
					<td>
						<label for="infoCompl">Complément d'adresse : </label>
					</td>
					<td>
						<input type="text" name="infoCompl" value="${sessionScope.personnel.adresse.infoCompl}"/>
					</td>
				</tr>
				<tr>
					<td>
						<label for="ville">Commune : </label>
					</td>
					<td>
						<input type="text" name="ville" value="${commune['nomCommune']}"/>
					</td>
				</tr>
				<tr>
					<td>
						<label for="code">Code postal : </label>
					</td>
					<td>
						<input type="text" name="code" value="${commune['codePostal']}"/>
					</td>
				</tr>
			</table>
		</fieldset>
		<fieldset>
			<legend>Informations professionnelles</legend>
			<table>
				<tr>
					<td>
						<input name="idContrat" type="number" hidden="true" value="${sessionScope.personnel.getContrat().getIdContrat()}"/>
						<input name="pointsAncien" type="number" hidden="true" value="${sessionScope.personnel.getPointsAncien()}"/>
						<input name="password" type="text" hidden="true" value="${sessionScope.personnel.getPassword()}"/>
						<input name="login" type="text" hidden="true" value="${sessionScope.personnel.getLogin()}"/>
						
						<label for="diplome">Diplôme : </label>
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
						<label for="fonction">Fonction : </label>
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