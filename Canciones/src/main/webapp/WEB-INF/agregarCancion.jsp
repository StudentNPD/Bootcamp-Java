<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Agregar Nueva Canción</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
	rel="stylesheet">
<style>
.error {
	color: #dc3545;
	font-size: 0.85em;
	margin-top: 0.25rem;
}

.form-control:focus {
	border-color: #0d6efd;
	box-shadow: 0 0 0 0.25rem rgba(13, 110, 253, 0.25);
}

.card {
	border: none;
	border-radius: 15px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
}

.card-header {
	background: linear-gradient(45deg, #0d6efd, #0dcaf0);
	color: white;
	border-radius: 15px 15px 0 0 !important;
	padding: 1.5rem;
}

.form-label {
	font-weight: 500;
	margin-bottom: 0.5rem;
}

.input-group-text {
	background-color: #f8f9fa;
}

.btn-submit {
	padding: 0.75rem 2rem;
}

.form-control.is-invalid {
	background-image: none;
}
</style>
</head>
<body class="bg-light">

	<div class="container mt-4 mb-4">
		<div class="row justify-content-center">
			<div class="col-md-8">
				<!-- Botón Volver -->
				<a href="/canciones" class="btn btn-outline-primary mb-3"> <i
					class="fas fa-arrow-left me-2"></i>Volver a la lista
				</a>

				<div class="card">
					<div class="card-header">
						<h2 class="text-center mb-0">
							<i class="fas fa-music me-2"></i>Nueva Canción
						</h2>
					</div>
					<div class="card-body p-4">
						<!--modelAttribute!!  -->
						<form:form modelAttribute="cancion" method="post"
							action="/canciones/procesa/agregar">

							<!-- Título -->
							<div class="mb-4">
								<label for="titulo" class="form-label"> <i
									class="fas fa-heading me-2"></i>Título
								</label>
								<div class="input-group">
									<form:input path="titulo" class="form-control"
										placeholder="Ingrese el título de la canción" />
								</div>
								<form:errors path="titulo" cssClass="error" />
							</div>

							<!-- Artista -->
							<div class="mb-4">
								<label for="artista" class="form-label"> <i
									class="fas fa-user me-2"></i>Artista
								</label>
								<div class="input-group">
									<form:input path="artista" class="form-control"
										placeholder="Ingrese el nombre del artista" />
								</div>
								<form:errors path="artista" cssClass="error" />
							</div>

							<!-- Álbum -->
							<div class="mb-4">
								<label for="album" class="form-label"> <i
									class="fas fa-compact-disc me-2"></i>Álbum
								</label>
								<div class="input-group">
									<form:input path="album" class="form-control"
										placeholder="Ingrese el nombre del álbum" />
								</div>
								<form:errors path="album" cssClass="error" />
							</div>

							<!-- Género -->
							<div class="mb-4">
								<label for="genero" class="form-label"> <i
									class="fas fa-guitar me-2"></i>Género
								</label>
								<div class="input-group">
									<form:input path="genero" class="form-control"
										placeholder="Ingrese el género musical" />
								</div>
								<form:errors path="genero" cssClass="error" />
							</div>

							<!-- Idioma -->
							<div class="mb-4">
								<label for="idioma" class="form-label"> <i
									class="fas fa-language me-2"></i>Idioma
								</label>
								<div class="input-group">
									<form:input path="idioma" class="form-control"
										placeholder="Ingrese el idioma de la canción" />
								</div>
								<form:errors path="idioma" cssClass="error" />
							</div>

							<!-- Fecha de Creación -->
							<div class="mb-4">
								<label for="fechaCreacion" class="form-label"> <i
									class="fas fa-calendar me-2"></i>Fecha de Creación
								</label>
								<div class="input-group">
									<form:input path="fechaCreacion" type="date"
										class="form-control" pattern="yyyy-MM-dd" />
								</div>
								<form:errors path="fechaCreacion" cssClass="error" />
							</div>

							<!-- Botones -->
							<div class="text-center mt-4">
								<button type="submit" class="btn btn-primary btn-submit me-2">
									<i class="fas fa-save me-2"></i>Guardar Canción
								</button>
								<a href="/canciones" class="btn btn-secondary"> <i
									class="fas fa-times me-2"></i>Cancelar
								</a>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap JS y Popper.js -->
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"></script>

	<!-- Script para establecer la fecha actual por defecto -->
	<script>
		document.addEventListener('DOMContentLoaded', function() {
			// Obtener la fecha actual en formato YYYY-MM-DD
			const today = new Date().toISOString().split('T')[0];
			// Establecer la fecha actual como valor por defecto
			document.querySelector('input[type="date"]').value = today;
		});
	</script>

</body>
</html>