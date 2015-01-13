<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Liste des adhérents" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />



<h1>Liste des adhérents</h1>

<table>
  <tr>
    <th>Nom</th>
    <th>Prenom</th>
    <th></th>
  </tr>
  <tr>
    <td>Barnabé</td>
    <td>Jean</td>
    <td><a href="consulteAdherent.jsp?id=125"><input type="button" value="Détails"/></a></td>
  </tr>
  <tr>
    <td>Malou</td>
    <td>Eddy</td>
    <td><a href="consulteAdherent.jsp?id=126"><input type="button" value="Détails"/></a></td>
  </tr>
				<c:forEach items="${listeAdherent}" var="adh">
					<tr>
						<td><c:out value="${adh['nom']}" /></td>
						<td><c:out value="${adh['prenom']}" /></td>
						<td><a href="consulteAdherent.jsp?id=<c:out value="${adh['idPersonne']}" />"><input type="button" value="Détails"/></a></td>
					</tr>
				</c:forEach>
</table>

<c:import url="/inc/footer.inc.jsp" />