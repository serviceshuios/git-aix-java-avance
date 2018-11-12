<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LES PERSONNES</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<h2>Liste des personnes de la BDD</h2>
	<c:if test="${!empty laListe}">
		<table class="table table-striped">
		<!-- entete statique du tableau -->
			<tr>
				<th>ID</th>
				<th>NOM</th>
				<th>PRENOM</th>
				<th>AGE</th>
			</tr>
			<!-- partie dynamique du tableau -->
			<c:forEach var="p" items="${laListe}">
				<tr>
					<td><c:out value="${p.id}"/></td>
					<td><c:out value="${p.nom}"/></td>
					<td><c:out value="${p.prenom}"/></td>
					<td><c:out value="${p.age}"/></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>