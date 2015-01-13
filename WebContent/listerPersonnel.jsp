<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="titre" value="Personnel" scope="request" />

<c:import url="/inc/head.inc.jsp" />

<c:import url="/inc/header.inc.jsp" />
<c:import url="/inc/menu.inc.jsp" />
	<table>
		<tr>
			<th>ID</th>
			<th>NOM</th>
			<th>Prénom</th>
		</tr>
		
		
	</table>
<c:import url="/inc/footer.inc.jsp" />