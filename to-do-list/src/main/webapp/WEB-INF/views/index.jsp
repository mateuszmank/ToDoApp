<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="index.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Home</a>
    <sec:authorize access="isAuthenticated()">
        <a class="navbar-brand" href="#">You are logged as <sec:authentication property="name"/></a>
    </sec:authorize>

    <div class="navbar-brand " id="navbarSupportedContent">
        <ul class="navbar-brand">
            <li class="navbar-brand">
                <form action="<c:url value="/logout"/>" method="post">
                    <input class="navbar-brand" type="submit" value="Logout">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </li>
        </ul>
    </div>
</nav>
<div class="container">
    <h1 class="text-center my-4">Welcome to To-Do List App</h1>
    <div class="list-group">
        <a href="${pageContext.request.contextPath}/users" class="list-group-item list-group-item-action">User Management</a>
        <a href="${pageContext.request.contextPath}/tasks" class="list-group-item list-group-item-action">Task Management</a>
        <a href="${pageContext.request.contextPath}/achievements" class="list-group-item list-group-item-action">Achievement Management</a>
    </div>
</div>
<!-- Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
