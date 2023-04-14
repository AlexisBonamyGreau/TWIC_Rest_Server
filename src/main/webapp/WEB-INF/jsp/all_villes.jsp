<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Villes</title>
	<meta name="description" content="TP ESEO API REST + CLIENT">
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<!-- <taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"> -->
</head>

<header>
	<nav>
		<ul>
			<li><a href="home">Calcul de distance</a></li>
			<li><a class="selected" href="list">Liste des villes</a></li>
			<li><a href="config">#TEMP configuration</a></li>
		</ul>
	</nav>
</header>

<body>
	<h1>Liste des villes</h1>
	<table>
		<thead>
			<tr>
				<th>Nom</th>
				<th>Code INSEE</th>
				<th>Code postal</th>
				<th>Population</th>
				<th>Latitude</th>
				<th>Longitude</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${villes}" var="ville">
				<tr>
					<a href="">${ville.nom}</a>
					<td>${ville.code_insee}</td>
					<td>${ville.code_postal}</td>
					<td>${ville.population}</td>
					<td>${ville.latitude}</td>
					<td>${ville.longitude}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<footer>
		<p>Made with <span class="heart">&hearts;</span> by Alexis Bonamy &copy; 2023</p>
	</footer>
</body>
</html>