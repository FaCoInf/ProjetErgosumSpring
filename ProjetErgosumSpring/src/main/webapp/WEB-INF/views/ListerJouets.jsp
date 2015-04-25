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
	$(document).ready(function() {
		$('#selecctall').click(function(event) {
			$('.checkbox').each(function() {
				this.checked = true;
			});
		});

	});
</script>
<title>Ergosum</title>
</head>
<body>
	<!-- Conteneur principal -->
	<div class="container">

		<!-- Entete -->
		<div class="page-header">
			<h1>
				<a href="#">ERGOSUM</a> <small>Retrouvez ci-dessous vos jouets préférés !</small>
			</h1>
		</div>

		<!-- Barre de navigation -->
		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<div class="navbar-collapse collapse">
				<ul class="nav nav-pills nav-justified">
					<li role="presentation"><a href="index.htm">Accueil</a></li>
					<li class="active" role="presentation"><a
						href="afficherJouets.htm">Jouets</a></li>
					<li role="presentation"><a href="listerCatalogues.htm">Catalogues</a></li>
					<li role="presentation"><a href="afficherDictionnaire.htm">Dictionnaires</a></li>
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
				<form class="form-horizontal" method="post" action="effacerJouet.htm"
					onsubmit="">
					<table class="table table-bordered">
						<!-- <CAPTION>Tableau des Stages</CAPTION> -->
						<thead>
							<tr>
								<th class="col-md-2"><a id="selecctall">Sélectionner
										tout les éléments</a></th>
								<th class="col-md-2">Action</th>
								<th class="col-md-2">Numero</th>
								<th class="col-md-2">Libellé</th>
								<th class="col-md-2">Code catégorie</th>
								<th class="col-md-2">Code tranche Age</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${mesJouets}" var="item">
								<tr>
									<td><input type="checkbox" class="checkbox" name="id"
										id="checkbox${item.numero}"  value="${item.numero}" aria-label=""></td>
									<td><a href="modifierJouet.htm?id=${item.numero}">Modifier</a></td>
									<td>${item.numero}</td>
									<td>${item.libelle}</td>
									<td>${item.categorie.codecateg}</td>
									<td>${item.trancheage.codetranche}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

					<!-- Boutons Supprimer -->
					<div class="form-group">
						<div class="col-sm-6 col-sm-offset-4 col-md-4 col-md-offset-5">
							<button type="submit" name="supprimerJouet"
								class="btn btn-default btn-primary">
								Supprimer <span class="glyphicon glyphicon-remove"></span>
							</button>
						</div>
					</div>
				</form>
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
									<li class="active"><a href="afficherJouets.htm">Lister</a></li>
									<hr>
									<li><a href="ajouterJouet.htm">Ajouter</a></li>
								</ul>
							</div>
						</div></li>
					<hr>
					<li role="presentation"><a
						href="listerCatalogues.htm">Catalogues</a></li>
					<hr>
					<li role="presentation"><a
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
