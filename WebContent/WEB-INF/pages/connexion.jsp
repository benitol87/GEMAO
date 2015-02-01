<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="fr.gemao.view.Pattern"%>

<c:set var="titre" value="Connexion" scope="request" />

<c:import url="/inc/head.inc.jsp" />
<body>
	<article id='pageConnexion' class='align-center'>
		<form method="post" action="<c:url value="<%= Pattern.CONNEXION %>" />">
            <fieldset>
                <legend>Merci de vous authentifier</legend>

                <div>
	                <label class="required" for="nom">Identifiant</label>
	                <input type="text" id="login" name="login" value="<c:out value="${personnel.login}"/>" size="20" maxlength="60" />
	            </div>
                
				<div class='align-center text-danger'>${form.erreurs['login']}</div>
                
				<div>
	                <label class="required" for="motdepasse">Mot de passe</label>
	                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
	            </div>
                
				<div class='align-center text-danger'>${form.erreurs['motdepasse']}</div>
                
				<div class='align-center'>
             	   <input type="submit" value="Connexion"/>
				</div>
				
				<div class='align-center text-danger'>${form.erreurs['Connexion']}</div>
                
                <%-- Vérification de la présence d'un objet personnel en session --%>
                <c:if test="${!empty sessionScope.sessionObjectPersonnel}">
	                <div class='align-center'>
	                    <p>Vous êtes connecté(e) avec le login : ${sessionScope.sessionObjectPersonnel.login}</p>
	                    <a href="<c:url value="<%= Pattern.ACCUEIL %>" />"><input type='button' value='Accueil'/></a>
                    </div>
                </c:if>
            </fieldset>
        </form>
	</article>
</body>
</html>