<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Application Bankonet</title>
</head>
<body>
	<span style="float: right"> <a href="?language=fr">fr</a> <a
		href="?language=en">en</a>
	</span>
	<h2>
		<spring:message code="affichage" />
	</h2>

	<table border="1">
		<tr>
			<td><spring:message code="id" /></td>
			<td><spring:message code="nom" /></td>
			<td><spring:message code="prenom" /></td>
			<td><spring:message code="login" /></td>
			<td><spring:message code="motDePasse" /></td>
		</tr>

		<c:forEach items="${clients}" var="cl">
			<tr>
				<td>${cl.id}</td>
				<td>${cl.prenom}</td>
				<td>${cl.nom}</td>
				<td>${cl.login}</td>
				<td><spring:message code="confidentiel" /></td>
				<td><a href="/BankonetSpringMVC/editclient/${cl.id}"><spring:message
							code="editerclient" /></a></td>
				<td><a href="/BankonetSpringMVC/deleteclient/${cl.id}"><spring:message
							code="supprimerclient" /></a></td>
				<td><a href="/BankonetSpringMVC/comptes/${cl.id}/comptescourantsliste">Gérer
						les Comptes courants du client</a></td>
				<td><a href="/BankonetSpringMVC/comptes/${cl.id}/comptesepargnesliste">Gérer
						les Comptes épargnes du client</a></td>
			</tr>

		</c:forEach>
	</table>
	
	<p>
		<spring:message code="${info}" />
	</p>

	<h2>
		<spring:message code="formulaire" />
	</h2>
	<form:form modelAttribute="client"
		action="/BankonetSpringMVC/saveClient">
		<table>
			<tr>
				<td>ID client:<form:hidden path="id" /></td>
				<td>${client.id}</td>
			</tr>
			<tr>
				<td><form:label path="prenom">
						<spring:message code="prenom" /> :</form:label></td>
				<td><form:input path="prenom" /></td>
				<%-- Show errors for prenom field --%>
				<td><form:errors path="prenom" /></td>
			</tr>
			<tr>
				<td><form:label path="nom">
						<spring:message code="nom" />:</form:label></td>
				<td><form:input path="nom" /></td>
				<%-- Show errors for nom field --%>
				<td><form:errors path="nom" /></td>
			</tr>
			<tr>
				<td><form:label path="login">
						<spring:message code="login" /> :</form:label></td>
				<td><form:input path="login" /></td>
				<%-- Show errors for login field --%>
				<td><form:errors path="login" /></td>
			</tr>
			<tr>
				<td><form:label path="motDePasse">
						<spring:message code="motDePasse" /> :</form:label></td>
				<td><form:input path="motDePasse" /></td>
				<%-- Show errors for motDePasse field --%>
				<td><form:errors path="motDePasse" /></td>
			</tr>
		</table>
		<button value="submit">
			<spring:message code="valider" />
		</button>
	</form:form>

	

</body>
</html>