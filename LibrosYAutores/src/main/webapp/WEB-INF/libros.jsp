<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- // El de abajo no siempre es necesario -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
<title>Libros</title>
</head>
<body>
	<h1>Nuestros Libros</h1>

	<c:forEach items="${listaLibros}" var="receta">
		<h2 class="receta-titulo">${receta.key}</h2>

	</c:forEach>

	<a href="/libros/formulario">Crear libro</a>
</body>
</html>