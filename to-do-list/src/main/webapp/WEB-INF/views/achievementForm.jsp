<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Achievement</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/achievementForm.css" rel="stylesheet">
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
    <h1 class="text-center mt-5">Create Achievement</h1>
    <form:form action="${pageContext.request.contextPath}/achievements/create" method="post" modelAttribute="achievement" class="mt-4">

        <!-- Hidden field for the ID (for updates) -->
        <form:hidden path="id"/>

        <div class="form-group">
            <label for="name">Name:</label>
            <form:input path="name" cssClass="form-control" id="name" required="true"/>
            <form:errors path="name" cssClass="text-danger"/>
        </div>

        <div class="form-group">
            <label for="description">Description:</label>
            <form:textarea path="description" cssClass="form-control" id="description" rows="3" placeholder="Enter achievement description"/>
            <form:errors path="description" cssClass="text-danger"/>
        </div>

        <button type="submit" class="btn btn-primary btn-block">Save</button>
    </form:form>
</div>
<!-- Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.amazonaws.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
