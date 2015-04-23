<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="resources/stylesheets/bootstrap/css/bootstrap.css"
	rel="stylesheet" />
<!-- <link href="resources/stylesheets/bootstrap-3.3.4/dist/css/bootstrap.css" -->
<!-- 	rel="stylesheet" /> -->
<!-- <link href="resources/stylesheets/bootstrap_2.3.2/css/bootstrap.css" -->
<!-- 	rel="stylesheet" /> -->
<link href="resources/stylesheets/css/style.css" rel="stylesheet">
<!-- <link href="resources/stylesheets/datepicker/css/datepicker.css" -->
<!-- 	rel="stylesheet"> -->
<!-- <link href="resources/stylesheets/django-bootstrap3-datetimepicker-2.2.3/bootstrap3_datetime/static/bootstrap3_datetime/css/bootstrap-datetimepicker.min.css" -->
<!-- 	rel="stylesheet"> -->
	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<!-- 	Conteneur principal -->
	<div class="container">

<!-- 	Entete  -->
		<div class="page-header">
			<h1>
				<a href="#">ERGOSUM</a>
			</h1>
		</div>

<!-- Barre de navigation -->
		<div class="row">
		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<div class="navbar-collapse collapse">
				<ul class="nav nav-pills nav-justified">
					<li role="presentation"><a href="index.htm">Accueil</a></li>
					<li role="presentation"><a href="afficherJouets.htm">Jouets</a></li>
					<li role="presentation" ><a href="listerCatalogues.htm">Catalogues</a></li>
					<li role="presentation" class="active"><a
						href="afficherDictionnaire.htm">Dictionnaires</a></li>
				</ul>
			</div>
			<br> <br>
		</div>
		</div>

<!-- Contenu -->
		<div class="row">
		<div id="dpMonths" class="input-append date"
			data-date-minviewmode="months" data-date-viewmode="years"
			data-date-format="mm/yyyy" data-date="102/2012">
			<input class="span2" type="text" readonly="" value="02/2012"
				size="16"> <span class="add-on"> <i
				class="icon-calendar"></i>
			</span>
		</div>
		</div>
		
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-10 col-lg-10">
				<h2>Liste des jouets</h2>
				<input type="hidden" name="uneErreur" value="${MesErreurs}"
					id="id_erreur">
				<table class="table table-bordered">
					<CAPTION>Tableau des Stages</CAPTION>
					<thead>
						<tr>
							<th class="col-md-2">Catégorie</th>
							<th class="col-md-2">Quantitée</th>
							<th class="col-md-2">distribuée</th>
						</tr>
					</thead>
					<tbody>
							<c:forEach items="${catalogue.comportes}" var="itemComporte">
								<tr>
<%-- 									<td>${itemCatalogue.annee}"</td> --%>
<%-- 									<td>${itemComporte.quantite}</td> --%>
<%-- 									<td>${catalogue.quantiteDistribuee}</td> --%>
										<!-- Retirer tous les jeux, vérif dans quel catalogue -->
								</tr>
							</c:forEach>
					</tbody>
				</table>
			</div>

<!-- 			aside -->
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
					<li role="presentation"><a href="listerCatalogues.htm">Catalogues</a></li>
					<hr>
					<li role="presentation" class="active" ><a
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
<script src="resources/stylesheets/jquery-2.1.3.js"></script>
	<script
		src="resources/stylesheets/datepicker/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#dpMonths').datepicker({});
		});
	</script>
</body>
</html>