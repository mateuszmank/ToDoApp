<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User List</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="userList.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <!-- Link to the home page -->
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">Home</a>

    <!-- Logout button in the top-right corner -->
    <div class="ml-auto">
        <sec:authorize access="isAuthenticated()">
            <form action="<c:url value='/logout'/>" method="post" class="form-inline">
                <span class="navbar-text mr-3">Logged in as <sec:authentication property="name"/></span>
                <button type="submit" class="btn btn-outline-light">Logout</button>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </sec:authorize>
    </div>
</nav>
<div class="container">
    <h1 class="text-center my-4">User List</h1>
    <ul class="list-group">
        <c:forEach var="user" items="${users}">
            <li class="list-group-item">
                <a href="${pageContext.request.contextPath}/users/${user.id}" class="text-decoration-none">${user.username}</a>
            </li>
        </c:forEach>
        <div class="list-group">
            <a href="${pageContext.request.contextPath}/users/create" class="list-group-item list-group-item-action">Create User</a>
        </div>
    </ul>
</div>
<!-- Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.amazonaws.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
