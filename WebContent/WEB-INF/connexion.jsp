<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/inc/head.inc.jsp" />
<body>
	
	<form class="well" method="post" action="Connexion">
            <fieldset>
                <legend>Connexion</legend>

                <label class="control-label" for="nom">Identifiant<span class="requis">*</span></label>
                <input class="form-control" type="text" id="login" name="login" value="<c:out value="${utilisateur.email}"/>" size="20" maxlength="60" />
                <span class="text-danger">${form.erreurs['email']}</span>
                <br />

                <label class="control-label" for="motdepasse">Mot de passe<span class="requis">*</span></label>
                <input class="form-control" type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <span class="text-danger">${form.erreurs['motdepasse']}</span>
                <br />

                <input class="btn btn-primary" type="submit" value="Connexion" class="sansLabel" />
                <br />
                
                <p class="${empty form.erreurs ? 'text-success' : 'text-danger'}">${form.resultat}</p>
                
                <%-- Vérification de la présence d'un objet utilisateur en session --%>
                <c:if test="${!empty sessionScope.sessionUtilisateur}">
                    <p class="text-success">Vous êtes connecté(e) avec le login : ${sessionScope.sessionUtilisateur}</p>
                </c:if>
            </fieldset>
        </form>
</body>
</html>