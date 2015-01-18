<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Modification d'un adhérent" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
<h1>Modification d'un adhérent</h1>
<form action="#" method="post">
	<fieldset>
	<legend>Informations personnelles</legend>
		<table>
			<tr>
	
				<td><p>
						<c:out value="${adherent['civilite']}" />
					</p>
				</td>
			</tr>
			<tr>
				<td><label for="nom">Nom : </label></td>
				<td><p>
						<c:out value="${adherent['nom']}" />
					</p></td>
				<td><label for="prenom">Prénom : </label></td>
				<td><p>
						<c:out value="${adherent['prenom']}" />
					</p></td>
				<td><label for="dateNaiss">Date de naissance : </label></td>
				<td><p>
						<c:out value="${dateNaissance}" />
					</p></td>
			</tr>
			<tr>
				<td><label for="comNaiss">Commune de naissance : </label></td>
				<td><p>
						<c:out value="${adherent.communeNaiss.nomCommune}" />
					</p></td>
				<td><label for="codePNaiss">Code postal : </label></td>
				<td><c:out value="${adherent.communeNaiss.codePostal}" /></td>
			</tr>
			<tr>
				<td><label for="telFixe">Téléphone fixe : </label></td>
				<td><input type="text" name="telFixe" pattern="[0][1-9][0-9]{8}"
					required="required" maxlength="10" autocomplete="on"
					value="<c:out value="${adherent['telFixe']}"/>" /></td>
				<td><label for="telPort">Téléphone portable : </label></td>
				<td><input type="text" name="telPort" pattern="[0][1-9][0-9]{8}"
					required="required" maxlength="10" autocomplete="on"
					value="<c:out value="${adherent['telPort']}"/>" /></td>
				<td><label for="email">E-mail : </label></td>
				<td><input type="text" name="email" required="required"
					autocomplete="on" value="<c:out value="${adherent['email']}"/>" /></td>
			</tr>
		</table>
	</fieldset>
	<fieldset>
	<legend>Adresse</legend>
		<table>
			<tr>
				<td><label for="num">Numéro : </label></td>
				<td><input type="text" name="num" required="required"
					pattern="\d*" autocomplete="off"
					value="<c:out value="${adherent.adresse.numRue}"/>" /></td>
				<td><label for="rue">Rue : </label></td>
				<td><input type="text" name="rue" required="required"
					autocomplete="off"
					value="<c:out value="${adherent.adresse.nomRue}"/>" /></td>
				<td><label for="compl">Complémentaire : </label></td>
				<td><input type="text" name="compl" autocomplete="off"
					value="<c:out value="${adherent.adresse.infoCompl}"/>" /></td>
			</tr>
			<tr>
				<td><label for="commune">Commune : </label></td>
				<td><input type="text" name="commune" required="required"
					autocomplete="off"
					value="<c:out value="${adherent.adresse.commune.nomCommune}"/>" /></td>
				<td><label for="codePostal">Code postal : </label></td>
				<td><input type="text" name="codePostal" required="required" maxlength="5"
					autocomplete="off"
					value="<c:out value="${adherent.adresse.commune.codePostal}"/>" /></td>
			</tr>
		</table>
	</fieldset>
	<fieldset>
	<legend>Disciplines</legend>
		<table>
			<tr>
				<td>
					<table>
						<tbody id="disciplines">
							<tr>
								<th><p>Disciplines</p></th>
							</tr>
							<tr>
								<td>Discipline</td>
								<td>Classe</td>
							</tr>
							<tr id="1">
								<td><select size="1" name="dis1">
										<option value="1">Test 1</option>
										<option value="2">Test 2</option>
								</select></td>
								<td><select size="1" name="clas1">
										<option value="1">Test 1</option>
										<option value="2">Test 2</option>
								</select></td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
		</table>
		<table>
			<tr>
				<td><input type="button" value="Retirer" id="retireDiscipline" />
					<input type="button" value="Ajouter" id="ajoutDiscipline" /></td>
			</tr>
		</table>
	</fieldset>
	<c:if test="${responsable!=null}">
	<fieldset>
	<legend>Responsable</legend>
		<table>
			<c:if test="${adherent.responsable!=null}">
				<tr>
					<td><label for="nomResp">Nom : </label></td>
					<td><input type="text" name="nomResp"
						value="<c:out value="${adherent.responsable['nom']}" />" /></td>
					<td><label for="prenomResp">Prénom : </label></td>
					<td><input type="text" name="prenomResp"
						value="<c:out value="${adherent.responsable['prenom']}" />" /></td>
				</tr>
				<tr>
					<td><label for="telResp">Téléphone : </label></td>
					<td><input type="text" name="telResp" maxlength="10"
						value="<c:out value="${adherent.responsable['telephone']}" />" /></td>
					<td><label for="emailResp">E-mail : </label></td>
					<td><input type="text" name="emailResp"
						value="<c:out value="${adherent.responsable['email']}" />" /></td>
				</tr>
			</c:if>
		</table>
	</fieldset>
	</c:if>
	<fieldset>
	<legend>Informations complémentaires</legend>
		<table>
			<tr>
				<td><label for="dateInscri">Date d'inscription : </label></td>
				<td><p>
						<c:out value="${dateInscription}" />
					</p></td>
			</tr>
			<tr>
				<td><span>Droit à l'image :</span> <input type="radio"
					name="droitImage" value="true"
					<c:if test="${adherent['droitImage'] == true}"> checked="checked" 
				</c:if> />
					<label for="droitImage">Oui</label> <input type="radio"
					name="droitImage" value="false"
					<c:if test="${adherent['droitImage'] == false}"> checked="checked" </c:if> />
					<label for="droitImage">Non</label></td>
			</tr>
		</table>
	</fieldset>
	<div>
		<input type="button" value="Annuler" /> <input type="submit" value="Valider" />
	</div>
</form>
<c:import url="/inc/footer.inc.jsp" />