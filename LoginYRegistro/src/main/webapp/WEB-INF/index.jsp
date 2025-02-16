<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login y Registro</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    
            <div class="container mt-5">
        <div class="row">
            <!-- Login Form -->
            <div class="col-md-6">
                <h2>Login</h2>
                <form action="/procesa/login" method="post">
                    <div class="mb-3">
                        <label class="form-label">Email:</label>
                        <input type="email" class="form-control" name="correo" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Contraseña:</label>
                        <input type="password" class="form-control" name="contraseña" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Iniciar Sesión</button>
                </form>
                <c:if test="${not empty errorMessage}">
                    <div class="alert alert-danger mt-3">${errorMessage}</div>
                </c:if>
            </div>

            <!-- Register Form -->
            <div class="col-md-6">
                <h2>Registro</h2>
                <form action="/procesa/registro" method="post">
                    <div class="mb-3">
                        <label class="form-label">Nombre de Usuario:</label>
                        <input type="text" class="form-control" name="nombreUsuario" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Nombre:</label>
                        <input type="text" class="form-control" name="nombre" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Apellido:</label>
                        <input type="text" class="form-control" name="apellido" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Email:</label>
                        <input type="email" class="form-control" name="correo" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Contraseña:</label>
                        <input type="password" class="form-control" name="contraseña" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Fecha de Nacimiento:</label>
                        <input type="date" class="form-control" name="fechaDeNacimiento" required>
                    </div>
                    <button type="submit" class="btn btn-success">Registrarse</button>
                </form>
                <c:if test="${not empty registroError}">
                    <div class="alert alert-danger mt-3">${registroError}</div>
                </c:if>
            </div>
        </div>
    
</body>
</html>