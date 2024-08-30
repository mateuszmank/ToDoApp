<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create User</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="userForm.css" rel="stylesheet"> <!-- Odniesienie do pliku CSS -->
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
    <h1 class="text-center mt-5">Create User</h1>
    <form:form action="${pageContext.request.contextPath}/users/create" method="post" modelAttribute="user" class="mt-4">
        <div class="form-group">
            <label for="username">Username:</label>
            <form:input path="username" cssClass="form-control" id="username" required="true"/>
            <form:errors path="username" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <form:input path="email" cssClass="form-control" id="email" type="email" required="true"/>
            <form:errors path="email" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <form:input path="password" cssClass="form-control" id="password" type="password" required="true"/>
            <form:errors path="password" cssClass="text-danger"/>
        </div>
        <button type="submit" class="btn btn-primary btn-block">Create</button>
    </form:form>
</div>
</body>
</html>

