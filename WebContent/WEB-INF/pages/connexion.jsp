<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/inc/head.inc.jsp" />
<body>
	
	<form method="post" action="Connexion">
            <fieldset>
                <legend>Merci de vous authentifier</legend>

                <label for="nom"><span class="requis">*</span> Identifiant </label>
                <input type="text" id="login" name="login" value="<c:out value="${personnel.login}"/>" size="20" maxlength="60" />
                <span>${form.erreurs['login']}</span>
                <br />

                <label for="motdepasse"><span class="requis">*</span> Mot de passe </label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <span>${form.erreurs['motdepasse']}</span>
                <br />

                <input type="submit" value="Connexion"/>
                <br />
                
                <p>${form.erreurs['Connexion']}</p>
                
                <%-- Vérification de la présence d'un objet personnel en session --%>
                <c:if test="${!empty sessionScope.sessionObjectPersonnel}">
                    <p>Vous êtes connecté(e) avec le login : ${sessionScope.sessionObjectPersonnel.login}</p>
                    <a href="/GEMAO/">Accueil</a>
                </c:if>
            </fieldset>
        </form>
</body>
</html>