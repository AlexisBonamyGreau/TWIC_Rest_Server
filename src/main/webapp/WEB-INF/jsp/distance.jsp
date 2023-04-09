<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Villes</title>
	<meta name="description" content="TP ESEO API REST + CLIENT">
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core">
</head>

<header>
	<nav>
		<ul>
			<li><a href="home">Calcul de distance</a></li>
			<li><a href="list">Liste des villes</a></li>
			<li><a href="config">#TEMP configuration</a></li>
		</ul>
	</nav>
</header>

<body class="distance">
	<h1>Calcul de distance entre des villes</h1>
	<form action="distance" method="post">
		<label for="villeA">Ville A</label>
		<select name="villeA" id="villeA">
			<c:forEach items="${villes}" var="ville">
				<option value="${ville.id}">${ville.nom}</option>
			</c:forEach>
		</select>
		<br>
		<label for="villeB">Ville B</label>
		<select name="villeB" id="villeB">
			<c:forEach items="${villes}" var="ville">
				<option value="${ville.code_insee}">${ville.nom}</option>
			</c:forEach>
		</select>
		<br>
		<input type="submit" value="Calculer">
	</form>
	<c:if test="${distance != null}">
		<p>La distance entre ${villeA.nom} et ${villeB.nom} est de ${distance} km</p>
	</c:if>
	<footer>
		<p>Made with <span class="heart">&hearts;</span> by Alexis Bonamy &copy; 2023</p>
	</footer>
</body>
</html>