<!-- /WEB-INF/views/editarCancion.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Canción</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
.error {
	color: red;
	font-size: 0.9em;
}
</style>
</head>
<body>
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<div class="card">
					<div class="card-header">
						<h2>Editar Canción</h2>
					</div>
					<div class="card-body">
						<form:form action="/canciones/actualizar/${cancion.id}"
							method="POST" modelAttribute="cancion">
							<div class="mb-3">
								<form:label path="titulo" class="form-label">Título:</form:label>
								<form:input path="titulo" class="form-control" />
								<form:errors path="titulo" cssClass="error" />
							</div>

							<div class="mb-3">
								<form:label path="artista" class="form-label">Artista:</form:label>
								<form:input path="artista" class="form-control" />
								<form:errors path="artista" cssClass="error" />
							</div>

							<div class="mb-3">
								<form:label path="album" class="form-label">Álbum:</form:label>
								<form:input path="album" class="form-control" />
								<form:errors path="album" cssClass="error" />
							</div>

							<div class="mb-3">
								<form:label path="genero" class="form-label">Género:</form:label>
								<form:input path="genero" class="form-control" />
								<form:errors path="genero" cssClass="error" />
							</div>

							<div class="mb-3">
								<form:label path="idioma" class="form-label">Idioma:</form:label>
								<form:input path="idioma" class="form-control" />
								<form:errors path="idioma" cssClass="error" />
							</div>

							<div class="d-grid gap-2">
								<button type="submit" class="btn btn-primary">Actualizar
									Canción</button>
								<a href="/canciones" class="btn btn-secondary">Cancelar</a>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>