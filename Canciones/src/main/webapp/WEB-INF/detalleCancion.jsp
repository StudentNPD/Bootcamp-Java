<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detalle de Canción - ${cancion.titulo}</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-4 mb-4">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <!-- Botón Volver -->
            <a href="/canciones" class="btn btn-outline-primary mb-3">
                <i class="fas fa-arrow-left"></i> Volver a la lista
            </a>

            <div class="card shadow detail-card">
                <!-- Cabecera con el título -->
                <div class="detail-header">
                    <h1 class="text-center mb-0">
                        <i class="fas fa-music me-2"></i>${cancion.titulo}
                    </h1>
                </div>

                <!-- Cuerpo con los detalles -->
                <div class="card-body">
                    <!-- Artista -->
                    <div class="detail-item">
                        <div class="row align-items-center">
                            <div class="col-md-4 detail-label">
                                <i class="fas fa-user me-2"></i>Artista
                            </div>
                            <div class="col-md-8">
                                <h5 class="mb-0">${cancion.artista}</h5>
                            </div>
                        </div>
                    </div>

                    <!-- Álbum -->
                    <div class="detail-item">
                        <div class="row align-items-center">
                            <div class="col-md-4 detail-label">
                                <i class="fas fa-compact-disc me-2"></i>Álbum
                            </div>
                            <div class="col-md-8">
                                <h5 class="mb-0">${cancion.album}</h5>
                            </div>
                        </div>
                    </div>

                    <!-- Género -->
                    <div class="detail-item">
                        <div class="row align-items-center">
                            <div class="col-md-4 detail-label">
                                <i class="fas fa-guitar me-2"></i>Género
                            </div>
                            <div class="col-md-8">
                                <span class="badge bg-primary badge-custom">
                                    ${cancion.genero}
                                </span>
                            </div>
                        </div>
                    </div>

                    <!-- Idioma -->
                    <div class="detail-item">
                        <div class="row align-items-center">
                            <div class="col-md-4 detail-label">
                                <i class="fas fa-language me-2"></i>Idioma
                            </div>
                            <div class="col-md-8">
                                <span class="badge bg-info badge-custom">
                                    ${cancion.idioma}
                                </span>
                            </div>
                        </div>
                    </div>

                    <!-- Fecha de Creación -->
                    <div class="detail-item">
                        <div class="row align-items-center">
                            <div class="col-md-4 detail-label">
                                <i class="fas fa-calendar me-2"></i>Fecha de Creación
                            </div>
                            <div class="col-md-8">
                                <fmt:formatDate value="${cancion.fechaCreacion}" pattern="dd/MM/yyyy"/>
                            </div>
                        </div>
                    </div>

                    <!-- Última Actualización -->
                    <div class="detail-item">
                        <div class="row align-items-center">
                            <div class="col-md-4 detail-label">
                                <i class="fas fa-calendar-check me-2"></i>Última Actualización
                            </div>
                            <div class="col-md-8">
                                <fmt:formatDate value="${cancion.fechaActualizacion}" pattern="dd/MM/yyyy"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Botones de acción -->
            <div class="text-center mt-4">
                <a href="/canciones/editar/${cancion.titulo}" class="btn btn-warning me-2">
                    <i class="fas fa-edit"></i> Editar
                </a>
                <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteModal">
                    <i class="fas fa-trash"></i> Eliminar
                </button>
            </div>
        </div>
    </div>
</div>

<!-- Modal de Confirmación de Eliminación -->
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteModalLabel">Confirmar Eliminación</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                ¿Estás seguro de que deseas eliminar la canción "${cancion.titulo}"?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                <form action="/canciones/eliminar/${cancion.titulo}" method="POST" style="display: inline;">
                    <button type="submit" class="btn btn-danger">Eliminar</button>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS y Popper.js -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"></script>

</body>
</html>