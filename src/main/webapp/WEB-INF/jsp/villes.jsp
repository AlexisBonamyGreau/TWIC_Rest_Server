<html lang="en">
<head>
<meta charset="utf-8">

<title>Villes</title>
<meta name="description" content="TP ESEO API REST + CLIENT">
<style>
table, td, th {
	border: 1px solid;
}

table {
	border-collapse: collapse;
}
</style>
</head>

<body>
	<h1>Ville</h1>
	<table>

		<c:forEach items="${ville}" var="ville">
			<tr>
				<td>${ville.code_commune_INSEE}</td>
				<td>${ville.libelleAcheminement}</td>
				<td>${ville.codePostal}</td>
				<td>${ville.latitude}</td>
				<td>${ville.longitude}</td>
			</tr>

		</c:forEach>
	</table>
</body>
</html>