<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Liste des materiel" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />

<h1>Liste des Materiel</h1>

<table>
	<tr>
		<th>Designation</th>
		<th>Categorie</th>
		<th>Quantité</th>
		<th></th>
	</tr>
	<tr>
 		<td>Batterie01</td>
 		<td>Instrument</td>
 		<td>N/A</td>
 		<td><input type="button" value="Détails"/></td>
 	</tr>
	<tr>
		<td>Trombonne</td>
 		<td>Fournitures</td>
 		<td>3019</td>
 		<td><input type="button" value="Détails"/></td>
	</tr>
	<tr>
		<td>chaise</td>
 		<td>Mobilier</td>
 		<td>208</td>
 		<td><input type="button" value="Détails"/></td>
	</tr>
</table>

<c:import url="/inc/footer.inc.jsp" />