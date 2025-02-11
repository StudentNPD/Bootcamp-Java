<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<title>Detalle de ${nombre}</title>
</head>
<body>
<div class="container">
   <c:choose>
       <c:when test="${empty receta}">
           <div class="error-message">
               La receta no se encuentra en nuestra lista.
           </div>
       </c:when>
       <c:otherwise>
           <div class="recipe-card">
               <div class="recipe-header">
                   <h1 class="recipe-title">${nombre}</h1>
               </div>
               <div class="recipe-content">
                   <div class="ingredients-section">
                       <h2 class="section-title">Ingredientes</h2>
                       <ul class="ingredients-list">
                           <c:forEach items="${receta}" var="ingrediente">
                               <li class="ingredient-item">${ingrediente}</li>
                           </c:forEach>
                       </ul>
                   </div>
                   <div class="actions">
                       <a href="/recetas" class="button">Volver a todas las recetas</a>
                   </div>
               </div>
           </div>
       </c:otherwise>
   </c:choose>
</div>

</body>
</html>