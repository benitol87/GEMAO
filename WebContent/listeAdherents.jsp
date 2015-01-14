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
    <td><input type="button" value="Détails"/></td>
  </tr>
  <tr>
    <td>Malou</td>
    <td>Eddy</td>
    <td><input type="button" value="Détails"/></td>
  </tr>
</table>

<c:import url="/inc/footer.inc.jsp" />