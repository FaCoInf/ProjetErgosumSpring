<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Auteurs : Corinne & Laura -->
<html>
<head>
<!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
<link href="resources/stylesheets/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="resources/stylesheets/css/style.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ergosum</title>
</head>
<body>
	<!-- Conteneur principal -->
	<div class="container">

		<!-- Entete -->
		<div class="page-header">
			<h1>
				<a href="#">ERGOSUM</a> <small>${serverTime}</small>
			</h1>
		</div>

		<!-- 		Barre de navigation -->
		<div class="row">
		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<div class="navbar-collapse collapse">
				<ul class="nav nav-pills nav-justified">
					<li class="active" role="presentation"><a href="index.htm">Accueil</a></li>
					<li role="presentation"><a
						href="afficherJouets.htm">Jouets</a></li>
					<li role="presentation"><a
						href="listerCatalogues.htm">Catalogues</a></li>
					<li role="presentation"><a
						href="afficherDictionnaire.htm">Dictionnaires</a></li>
				</ul>
			</div>
			<br> <br>
		</div>
		</div>

		<!-- 		Contenu -->
		<section class="row">
		<div class="col-xs-12 col-sm-12 col-md-10 col-lg-10 contenu">
			<h2>Bienvenue</h2>
			Cette application vous permettra de modifier les jouets ainsi que
			leurs catalogues. <br> En vous souhaitant une agréable visite.<br><br>
		<div class="col-xs-5 col-sm-2 col-md-2 col-lg-2">
<!-- 		<span class="txt"> -->
		<img align="right" class="img-responsive" alt="Polytech Lyon" src="resources/pictures/polytech.png"></img>
<!-- 		</span> -->
		</div>
		</div>

		<!-- aside -->
			<div class="col-xs-12 col-sm-2 col-md-2 col-lg-2 contenu">
			<div class="row asideTitre">Pages</div>
			<div class="row">
				<ul class="nav nav-pills nav-stacked">
					<li role="presentation" class="active"><a href="index.htm">Accueil</a></li>
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
					<li role="presentation"><a
						href="afficherDictionnaire.htm">Dictionnaires</a></li>
				</ul>
			</div>
		</div>
	</div>



		</section>

		<!--         <footer class="row"> -->
		<!--         <div class="col-sm-12"> -->
		<!--           Pied de page -->
		<!--         </div> -->
		<!--       </footer> -->

	</div>
</body>
</html>
