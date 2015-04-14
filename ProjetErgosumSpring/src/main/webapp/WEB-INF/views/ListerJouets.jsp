<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date,java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
				<a href="#">ERGOSUM</a> <small><%=DateFormat.getDateTimeInstance(DateFormat.FULL,
					DateFormat.FULL).format(new Date())%></small>
			</h1>
		</div>

		<!-- 		Barre de navigation -->
		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<div class="navbar-collapse collapse">
				<ul class="nav nav-pills nav-justified">
					<li role="presentation"><a href="index.htm">Accueil</a></li>
					<li class="active"  role="presentation"><a
						href="afficherJouets.htm">Jouets</a></li>
					<li role="presentation"><a
						href="Controleur?action=rechercheStage">Catalogues</a></li>
					<li role="presentation"><a
						href="Controleur?action=saisieModifierStage">Dictionnaires</a></li>
				</ul>
			</div>
			<br>
			<br>
		</div>

		<!-- 		Contenu -->
		<div class="col-xs-12 col-sm-12 col-md-10 col-lg-10">
			<h2>Liste des jouets</h2>
			<table class="table table-bordered">
<!-- 				<CAPTION>Tableau des Stages</CAPTION> -->
				<thead>
					<tr>
						<th class="col-md-2">Numero</th>
						<th class="col-md-2">Libellé</th>
						<th class="col-md-2">Code catégorie</th>
						<th class="col-md-2">Code tranche Age</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${jouets}" var="item">
						<tr>
							<td>${item.numero}</td>
							<td>${item.libelle}</td>
							<td>${item.categorie.codecateg}</td>
							<td>${item.trancheage.codetranche}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<!--         aside -->
		<div class="col-xs-12 col-sm-2 col-md-2 col-lg-2">
			<ul class="nav nav-pills nav-stacked">
				<li role="presentation"><a href="#">Accueil</a></li>
				<li role="presentation"><a
					href="Controleur?action=afficheStage">Jouets</a>
					Ajouter<br>
					Supprimer</li>
				<li role="presentation"><a
					href="Controleur?action=rechercheStage">Catalogues</a></li>
				<li role="presentation"><a
					href="Controleur?action=saisieModifierStage">Dictionnaires</a></li>
			</ul>
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
