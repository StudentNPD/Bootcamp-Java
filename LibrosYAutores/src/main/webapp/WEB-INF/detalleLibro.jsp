<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
<title>Detalle Libro</title>
</head>
<body>
	<div class="container">
		<div class="libros-card">
			<div class="libros-header">
				<h1 class="libros-title">${nombre}</h1>
			</div>
			<div class="libros-content">
				<div class="libros-section">
					<h2 class="section-title">Libros</h2>
					<ul class="ingredients-list">
						<c:forEach items="${libro}" var="librito">
							<li class="librito-item">${librito}</li>
						</c:forEach>
					</ul>
				</div>

				<div class="actions">
					<a href="/libros" class="button">Volver a todos los libros</a>
				</div>
			</div>

		</div>
	</div>

</body>
</html>