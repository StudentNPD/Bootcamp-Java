<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<title>Recetas</title>
</head>
<body>
	<div class="container">
		<div class="recipe-card">
			<h1>Nuestras recetas</h1>
			<c:forEach items="${listaRecetas }" var="receta">
				<h2 class="receta-titulo">${receta.key}</h2>
				<h3>Ingredientes necesarios:</h3>
				<ul class="ingredientes-lista">
					<c:forEach items="${receta.value}" var="ingrediente">
						<li class="ingrediente-item">${ingrediente}</li>
					</c:forEach>
				</ul>
			</c:forEach>

		</div>
	</div>


</body>
</html>