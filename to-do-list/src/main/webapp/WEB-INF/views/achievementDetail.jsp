<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Achievement Detail</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrap.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/achievementDetail.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">Home</a>
    <div class="ml-auto">
        <sec:authorize access="isAuthenticated()">
            <form action="${pageContext.request.contextPath}/logout" method="post" class="form-inline">
                <span class="navbar-text mr-3">You are logged in as <sec:authentication property="name"/></span>
                <button type="submit" class="btn btn-outline-light">Logout</button>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </sec:authorize>
    </div>
</nav>
<div class="container">
    <h1 class="text-center my-4">Achievement Detail</h1>
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">${achievement.name}</h5>
            <p class="card-text">Description: ${achievement.description}</p>
            <a href="${pageContext.request.contextPath}/achievements/delete/${achievement.id}" class="btn btn-danger btn-block mt-4">Delete Achievement</a>
        </div>
    </div>
</div>
<!-- Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrap.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
