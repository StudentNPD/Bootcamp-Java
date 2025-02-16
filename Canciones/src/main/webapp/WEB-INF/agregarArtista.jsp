<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agregar Nueva Canción</title>
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
            <a href="/artistas" class="btn btn-outline-primary mb-3">
                <i class="fas fa-arrow-left me-2"></i>Volver a la lista
            </a>

            <div class="card">
                <div class="card-header">
                    <h2 class="text-center mb-0">
                        <i class="fas fa-music me-2"></i>Nuevo Artista
                    </h2>
                </div>
                <div class="card-body p-4">
                    <form:form modelAttribute="artista" method="post" action="/artistas/procesa/agregar">
                        
                        <!-- Nombre -->
                        <div class="mb-4">
                            <label for="titulo" class="form-label">
                                <i class="fas fa-heading me-2"></i>Nombre
                            </label>
                            <div class="input-group">
                                <form:input path="nombre" class="form-control" placeholder="Ingrese el nombre del artista"/>
                            </div>
                            <form:errors path="nombre" cssClass="error"/>
                        </div>

                        <!-- Apellido -->
                        <div class="mb-4">
                            <label for="apellido" class="form-label">
                                <i class="fas fa-user me-2"></i>Apellido
                            </label>
                            <div class="input-group">
                                <form:input path="apellido" class="form-control" placeholder="Ingrese el apellido del artista"/>
                            </div>
                            <form:errors path="apellido" cssClass="error"/>
                        </div>

                        <!-- Biografia -->
                        <div class="mb-4">
                            <label for="biografia" class="form-label">
                                <i class="fas fa-compact-disc me-2"></i>Álbum
                            </label>
                            <div class="input-group">
                                <form:input path="biografia" class="form-control" placeholder="Ingrese la biografia del artista"/>
                            </div>
                            <form:errors path="biografia" cssClass="error"/>
                        </div>
          
                        <!-- Fecha de Creación -->
                        <div class="mb-4">             
                            <label for="fechaDeCreacion" class="form-label">
                                <i class="fas fa-calendar me-2"></i>Fecha de Creación
                            </label>
                            <div class="input-group">
                                <form:input path="fechaCreacion" type="date" class="form-control" pattern="yyyy-MM-dd"/>
                            </div>
                            <form:errors path="fechaCreacion" cssClass="error"/>
                        </div>

                        <!-- Botones -->
                        <div class="text-center mt-4">
                            <button type="submit" class="btn btn-primary btn-submit me-2">
                                <i class="fas fa-save me-2"></i>Guardar Artista
                            </button>
                            <a href="/artistas" class="btn btn-secondary">
                                <i class="fas fa-times me-2"></i>Cancelar
                            </a>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS y Popper.js -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"></script>

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