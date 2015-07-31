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
			<td><spring:message code="libelle" /></td>
			<td><spring:message code="solde" /></td>
		</tr>

		<c:forEach items="${comptes}" var="com">
			<tr>
				<td>${com.libelle}</td>
				<td>${com.solde}</td>

				<td><a href="/BankonetSpringMVC/comptes/${cl.id}/comptescourantsedit">éditer
						Comptes courants</a></td>
				<td><a href="/BankonetSpringMVC/comptes/${cl.id}/comptesepargnesdelete">supprimer
						Comptes courants</a></td>
			</tr>
		</c:forEach>
	</table>

	<form:form modelAttribute="comptecourant" action="/BankonetSpringMVC/comptes/${cl.id}/saveCompte">
		<table>
			
			
			
			<tr>
				<td><form:label path="libelle">
						<spring:message code="libelle" /> :</form:label></td>
				<td><form:input path="libelle" /></td>
				<td><form:errors path="libelle" /></td>
			</tr>
			<tr>
				<td><form:label path="solde">
						<spring:message code="solde" />:</form:label></td>
				<td><form:input path="solde" /></td>
				<td><form:errors path="solde" /></td>
			</tr>
			
		</table>
		<button value="submit">
			<spring:message code="valider" />
		</button>
	</form:form>

</body>
</html>