<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="fr.gemao.entity.materiel.Etat"%>
<%@ page import="fr.gemao.entity.materiel.Designation"%>
<%@ page import="fr.gemao.entity.materiel.Marque"%>
<%@ page import="fr.gemao.entity.materiel.Categorie"%>

<c:set var="titre" value="Materiel" scope="request" />

<c:import url="/inc/head.inc.jsp" />
<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
<form id="ajouterMateriel" action="#" method="post">
	<label for="categorie">Catégorie : </label> <select name="categorie"
		id="categorie">
		<%
			ArrayList<Categorie> categories = (ArrayList) request
					.getAttribute("LISTE_CATEGORIE");
		%>
		<%
			for (int i = 0; i < categories.size(); i++) {
				Categorie item = categories.get(i);
		%>
		<option value="<%=item.getIdCategorie()%>"><%=item.getLibelleCat()%></option>
		<%
			}
		%>
	</select> <label for="valeurAch">Valeur d'achat : </label> <input type="number"
		name="ValeurAch" /> <label for="dateAch">Date d'achat : </label> <input
		type="date" name="dateAch" />
</form>
<form id="ajouterMaterielInstrument" action="#" methode="post" hidden>
	<table>
		<tr>
			<td>
				<fieldset>
					<table>
						<tr>
							<td><label for="designation">Désignation : </label></td>
							<td><select name="designation" id="designation">
									<%
										ArrayList<Designation> designations = (ArrayList) request
												.getAttribute("LISTE_DESIGNATION");
									%>
									<%
										for (int i = 0; i < designations.size(); i++) {
											Designation item = designations.get(i);
									%>
									<option value="<%=item.getIdDesignation()%>"><%=item.getLibelleDesignation()%></option>
									<%
										}
									%>
							</select></td>
						</tr>
						<tr>
							<td><label for="type">Type : </label></td>
							<td><input type="text" name="type" /></td>
						</tr>
						<tr>
							<td><label for="etat">Etat : </label></td>
							<td><select name="etat" id="etat">
									<%
										ArrayList<Etat> Etats = (ArrayList) request
												.getAttribute("LISTE_ETAT");
									%>
									<%
										for (int i = 0; i < Etats.size(); i++) {
											Etat item = Etats.get(i);
									%>
									<option value="<%=item.getIdEtat()%>"><%=item.getLibelleEtat()%></option>
									<%
										}
									%>
							</select></td>
						</tr>
						<tr>
							<td><label for="marque">Marque : </label></td>
							<td><select name="marque" id="marque">
									<%
										ArrayList<Marque> marques = (ArrayList) request
												.getAttribute("LISTE_MARQUE");
									%>
									<%
										for (int i = 0; i < marques.size(); i++) {
											Marque item = marques.get(i);
									%>
									<option value="<%=item.getIdMarque()%>"><%=item.getNomMarque()%></option>
									<%
										}
									%>
							</select></td>
						</tr>
						
						<tr>
							<td><label for="quantite">Quantité : </label></td>
							<td><input type="text" name="quantite" id="quantite"/></td>
						</tr>
						<tr>	
							<td><label for="prixU">Prix unitaire : </label></td>
							<td><input type="text" name="prixU" id="prixU"/></td>
						</tr>
						<tr>
							<td><label for="numSerie">Numéro de série : </label></td>
							<td><input type="text" name="numSerie" /></td>
						</tr>
					</table>
				</fieldset>
			</td>
			<td>
				<table>
					<tr>
						<td>
							<fieldset>
								<legend>louable</legend>
								<table>
									<tr>
										<td><label for="valRea">Valeur de
												réaprovisionnement : </label></td>
										<td><input type="number" name="valRea" /></td>
									</tr>
									<tr>
										<td><label for="deplacable">Déplaçable : </label></td>
										<td><label for="deplacableOui"> <input
												type="radio" checked="checked" name="deplace" value="oui" />
												oui
										</label> <label for="deplacableNon"> <input type="radio"
												checked="checked" name="deplace" value="non" /> non
										</label></td>
									</tr>
								</table>
							</fieldset>
						</td>
					</tr>
					<tr>
						<td><label for="observation">Observation : </label> <textarea
								rows="5" cols="50"></textarea></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td><input type="submit" name="valider" value="Valider" /></td>
			<td></td>
			<td></td>
			<td><input type="reset" name="annuler" value="Annuler" /></td>
		</tr>
	</table>
</form>

<c:import url="/inc/footer.inc.jsp" />