<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de artistas</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body class="bg-light">

<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-10">
            <!-- Encabezado -->
            <div class="d-flex justify-content-between align-items-center mb-4">
                <h1 class="h2">
                    <i class="fas fa-music me-2"></i>Artistas
                </h1>
                <a href="/artistas/formulario/agregar" class="btn btn-primary">
                    <i class="fas fa-plus me-2"></i>Nuevo Artista
                </a>
            </div>

            <!-- Lista de artistas -->
            <div class="row row-cols-1 row-cols-md-2 g-4">
                <c:forEach items="${artistas}" var="artista">
                    <div class="col">
                        <div class="card song-card shadow-sm">
                            <div class="card-body">
                                <div class="d-flex justify-content-between align-items-center">
                                    <div>
                                        <h5 class="card-title mb-1">
                                            <i class="fas fa-music me-2 text-primary"></i>${artista.nombre} ${artista.apellido}
                                        </h5>
                                        <p class="card-text text-muted">
                                            <i class="fas fa-user me-2"></i>${artista.biografia}
                                        </p>
                                    </div>
                                    <a href="/artistas/detalle/${artista.id}" 
                                       class="btn btn-outline-primary btn-detail">
                                        <i class="fas fa-info-circle me-2"></i>Detalles
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <!-- Si no hay artistas -->
            <c:if test="${empty artistas}">
                <div class="alert alert-info text-center mt-4">
                    <i class="fas fa-info-circle me-2"></i>
                    No hay artistas disponibles
                </div>
            </c:if>

            <!-- Contador de artistas -->
            <div class="text-center mt-4">
                <span class="badge bg-secondary">
                    <i class="fas fa-list me-2"></i>
                    Total de artistas: ${artistas.size()}
                </span>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS y Popper.js -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"></script>

</body>
</html>