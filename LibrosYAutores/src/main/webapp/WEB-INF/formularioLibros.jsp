<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
<title>Formulario Libro</title>
</head>
<body>
	<h1>Formulario Libro</h1>
	<form action="/procesa/libro" method="POST">
		<label for="nombre">Nombre:</label><br> <input type="text"
			id="nombre" name="nombre" required><br> <label
			for="autor">Autor:</label><br> <input type="autor" id="autor"
			name="autor" required><br> <input type="submit"
			value="Enviar">
	</form>
</body>
</html>