<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Auteurs : Corinne & Laura -->
<html>
<head>
<link href="resources/stylesheets/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="resources/stylesheets/css/style.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ergosum</title>

<script src="resources/stylesheets/jquery-2.1.3.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		// Si erreur => popup
		var erreurs = "<c:out value='${MesErreurs}' />";
		if(erreurs != ""){
			alert(erreurs);
		}
		
		
		// Selection des listes déroulantes
		var codetranche = "<c:out value='${jouet.trancheage.codetranche}' />";
		var codecateg = "<c:out value='${jouet.categorie.codecateg}' />";
		
		if(codetranche == "") codetranche = "1";
		if(codecateg == "") codecateg = "1";
		
		$('#codetranche').val(codetranche);
		$('#codecateg').val( codecateg);
	});
</script>

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
		<div class="row">
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
		</div>

		<!-- 		Contenu -->
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-10 col-lg-10 contenu">
				<h2>${title}</h2>
				<input type="hidden" name="uneErreur" value="${MesErreurs}"
					id="id_erreur">
				<form class="form-horizontal" method="post" action="${page}"
					onsubmit="return verif();">
					<input type="hidden" name="type" value="${action}" id="type" /> <input
						type="hidden" name="action" value="${page}" />

					<!-- input fields -->
					<div class="form-group">
						<label class="col-sm-4 col-md-5 control-label">Numéro</label>
						<div class="col-sm-6 col-md-4">
							<input type="text" name="id" value="${jouet.numero}" id="id"
								class="form-control" required pattern="\d*" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 col-md-5 control-label">Libellé</label>
						<div class="col-sm-6 col-md-4">
							<input type="text" name="libelle" value="${jouet.libelle}"
								id="libelle" class="form-control" required />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 col-md-5 control-label">Catégorie :</label>
						<div class="col-sm-6 col-md-4">
							<select name="codecateg" id="codecateg">
								<c:forEach items="${listCategorie}" var="item">
									<option value="${item.codecateg}">${item.libcateg}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 col-md-5 control-label">Tranche âge
							:</label>
						<div class="col-sm-6 col-md-4">
							<select name="codetranche" id="codetranche">
								<c:forEach items="${listTrancheAge}" var="item">
									<option value="${item.codetranche}">${item.agemin}à
										${item.agemax} ans</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 col-md-5 control-label">Quantité de
							distribution</label>
						<div class="col-sm-6 col-md-4">
							<input type="text" name="quantiteDistribution"
								value="${catalogue.quantiteDistribuee}"
								id="quantiteDistribution" class="form-control" required pattern="\d*" />
						</div>
						<label> dans le catalogue </label> <select name="codecatalogue"
							id="codecatalogue">
							<c:forEach items="${listCatalogue}" var="item">
								<option value="${item.annee}">${item.annee}</option>
							</c:forEach>
						</select>
					</div>

					<!-- Boutons Ajouter/Reset -->
					<div class="form-group">
						<div class="col-sm-6 col-sm-offset-4 col-md-4 col-md-offset-5">
							<button type="submit" name="ajouter"
								class="btn btn-default btn-primary">${textButton}</button>
							<button type="reset" name="reset"
								class="btn btn-default btn-primary">Reset</button>
						</div>
					</div>
				</form>
			</div>

			<!-- aside -->
			<div class="col-xs-12 col-sm-2 col-md-2 col-lg-2 contenu">
			<div class="row asideTitre">Pages</div>
			<div class="row">
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
									<li class="active"><a href="ajouterJouet.htm">Ajouter</a></li>
								</ul>
							</div>
						</div></li>
					<hr>
					<li role="presentation"><a href="listerCatalogues.htm">Catalogues</a></li>
					<hr>
					<li role="presentation"><a
						href="afficherDictionnaire.htm">Dictionnaires</a></li>
				</ul>
			</div>
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
