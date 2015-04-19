<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
<link href="resources/stylesheets/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="resources/stylesheets/css/style.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="resources/stylesheets/jquery-2.1.3.js"></script>
<script type="text/javascript">
	function Chargement() {
		var obj = document.getElementById("id_erreur");
		if (obj.value != '')
			alert('Erreur signalée  : "' + obj.value + "'");
	}
</script>
<title>Ergosum</title>
</head>
<body>
	<!-- Conteneur principal -->
	<div class="container">

		<!-- Entete -->
		<div class="page-header">
			<h1>
				<a href="#">ERGOSUM</a>
			</h1>
		</div>

		<!-- Barre de navigation -->
		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<div class="navbar-collapse collapse">
				<ul class="nav nav-pills nav-justified">
					<li role="presentation"><a href="index.htm">Accueil</a></li>
					<li role="presentation"><a href="afficherJouets.htm">Jouets</a></li>
					<li role="presentation" class="active" ><a href="listerCatalogues.htm">Catalogues</a></li>
					<li role="presentation"><a
						href="afficherDictionnaire.htm">Dictionnaires</a></li>
				</ul>
			</div>
			<br> <br>
		</div>

		<!-- Contenu -->
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-10 col-lg-10">
				<h2>Liste des jouets</h2>
				<input type="hidden" name="uneErreur" value="${MesErreurs}"
					id="id_erreur">
				<table class="table table-bordered">
					<!-- <CAPTION>Tableau des Stages</CAPTION> -->
					<thead>
						<tr>
							<th class="col-md-2">Catégorie</th>
							<th class="col-md-2">Quantitée affectée</th>
							<th class="col-md-2">Quantitée distribuée</th>
							<th class="col-md-2">Différence</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${mesCatalogues}" var="itemCatalogue">
							<c:forEach items="${itemCatalogue.comportes}" var="itemComporte">
								<tr>
									<td>Année ${itemCatalogue.annee}"</td>
									<td>${itemComporte.quantite}</td>
									<td>${itemCatalogue.quantiteDistribuee}</td>
									<td>${itemComporte.quantite - itemCatalogue.quantiteDistribuee}</td>
								</tr>
							</c:forEach>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<!-- aside -->
			<div class="col-xs-12 col-sm-2 col-md-2 col-lg-2">
				<ul class="nav nav-pills nav-stacked">
					<li role="presentation"><a href="index.htm">Accueil</a></li>
					<hr>
					<li role="presentation"><a href="afficherJouets.htm">Jouets</a>
						<div class="row">
							<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2"></div>
							<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
								<ul class="nav nav-pills nav-stacked">
									<li><a href="afficherJouets.htm">Lister</a></li>
									<hr>
									<li><a href="ajouterJouet.htm">Ajouter</a></li>
								</ul>
							</div>
						</div></li>
					<hr>
					<li class="active" role="presentation"><a href="listerCatalogues.htm">Catalogues</a></li>
					<hr>
					<li role="presentation" ><a
						href="afficherDictionnaire.htm">Dictionnaires</a></li>
				</ul>
			</div>
		</div>

		<!--         <footer class="row"> -->
		<!--         <div class="col-sm-12"> -->
		<!--           Pied de page -->
		<!--         </div> -->
		<!--       </footer> -->

	</div>

</body>
</html>