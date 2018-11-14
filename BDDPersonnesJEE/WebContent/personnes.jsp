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
	<div class="container">
		<div class="row">
			<div class="col-md-6">
					<h2>mettre à jour une personne</h2>
					<form action="MajController" method="post">
						<input type="hidden" name="id" value="${pers.id}" />
						<div class="form-group">
							<label for="nom">Nom</label> <input type="text"
								class="form-control" id="nom" name="nom"
								placeholder="Entrer le nom" value="${pers.nom}">
						</div>
						<div class="form-group">
							<label for="prenom">Prenom</label> <input type="text"
								class="form-control" id="prenom" name="prenom"
								placeholder="Entrer le prenom" value="${pers.prenom}">
						</div>
						<div class="form-group">
							<label for="prenom">Age</label> <input type="number"
								class="form-control" id="age" name="age"
								placeholder="Entrer votre age" value="${pers.age}">
						</div>
						<button type="submit" class="btn btn-primary">Modifier</button>
					</form>
			</div>
			<div class="col-md-6">
				<div>
					<h2>Liste des personnes de la BDD</h2>
					<c:if test="${!empty laListe}">
						<table class="table table-striped">
							<!-- entete statique du tableau -->
							<tr>
								<th>ID</th>
								<th>NOM</th>
								<th>PRENOM</th>
								<th>AGE</th>
								<th>MAJ</th>
								<th>SUPPR</th>
							</tr>
							<!-- partie dynamique du tableau -->
							<c:forEach var="p" items="${laListe}">
								<tr>
									<td><c:out value="${p.id}" /></td>
									<td><c:out value="${p.nom}" /></td>
									<td><c:out value="${p.prenom}" /></td>
									<td><c:out value="${p.age}" /></td>
									<td><a href="RecupController?id=${p.id}">MAJ</a></td>
									<td><a id="suppr" href="SupprimerController?id=${p.id}">SUPPR</a></td>
								</tr>
							</c:forEach>
						</table>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<script src="js/script.js"></script>
</body>
</html>